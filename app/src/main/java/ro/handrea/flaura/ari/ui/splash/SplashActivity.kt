package ro.handrea.flaura.ari.ui.splash

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseUiException
import com.firebase.ui.auth.IdpResponse
import ro.handrea.flaura.ari.AriApplication
import ro.handrea.flaura.ari.R
import ro.handrea.flaura.ari.ui.main.MainActivity
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // Creates an instance of Splash component by grabbing the factory from the app graph
        (application as AriApplication).appComponent.splashComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Grab userManager from appComponent to check if the user is logged in or not
        val userManager = (application as AriApplication).appComponent.userManager()

        if (!userManager.isUserLoggedIn()) {
            createSignInIntent()
        } else {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun createSignInIntent() {
        // Choose authentication providers
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.FacebookBuilder().build())

        // Create and launch sign-in intent
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                splashViewModel.userJustLoggedIn()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                if (response != null && response.error != null) {
                    showErrorMessage(response.error!!)
                }
            }
        }
    }

    private fun showErrorMessage(error: FirebaseUiException) {
        Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
        // Sign in failed. If response is null the user canceled the
        // sign-in flow using the back button. Otherwise check
        // response.getError().getErrorCode() and handle the error.
    }

    companion object {
        private const val RC_SIGN_IN = 1637
    }
}
