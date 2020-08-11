package com.flauraha.ari.ui.shelves

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.flauraha.ari.R
import com.flauraha.ari.databinding.FragmentShelvesBinding
import com.flauraha.ari.ui.search.BookSearchActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_shelves.*

class ShelvesFragment : Fragment() {
    private lateinit var shelveCollectionAdapter: ShelveCollectionAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var binding: FragmentShelvesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShelvesBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shelveCollectionAdapter = ShelveCollectionAdapter(this)
        viewPager = binding.pager
        viewPager.adapter = shelveCollectionAdapter

        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            tab.text = context?.getString(
                Shelve.getByPosition(position).titleStringId)
        }.attach()

        binding.addFab.setOnClickListener {
            activity?.let{
                val intent = Intent (it, BookSearchActivity::class.java)
                it.startActivity(intent)
            }
        }
    }
}

class ShelveCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(Shelve.getByPosition(position)) {
            Shelve.READ -> ReadFragment()
            Shelve.READING -> ReadingFragment()
            Shelve.TOBEREAD -> ToBeReadFragment()
        }
    }
}

enum class Shelve(private val position: Int, val titleStringId: Int) {
    READ(0, R.string.title_finished_books),
    READING(1, R.string.title_reading),
    TOBEREAD(2, R.string.title_want_to_read);

    companion object {
        fun getByPosition(position: Int): Shelve {
            for (shelve in values()) {
                if (shelve.position == position) {
                    return shelve
                }
            }

            return READING
        }
    }
}
