package com.flauraha.ari.ui.shelves

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.flauraha.ari.databinding.FragmentBaseShelveBinding

/**
 * A simple [Fragment] subclass.
 */
class BaseShelveFragment : Fragment() {

    private lateinit var binding: FragmentBaseShelveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseShelveBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
//            adapter = bookAdapter
        }
    }
}
