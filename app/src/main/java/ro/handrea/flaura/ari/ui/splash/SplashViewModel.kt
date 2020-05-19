package ro.handrea.flaura.ari.ui.splash

import ro.handrea.flaura.ari.user.UserManager
import javax.inject.Inject


/**
 * SplashViewModel is the ViewModel that [SplashActivity] uses to handle complex logic.
 */
class SplashViewModel @Inject constructor(private val userManager: UserManager) {

    fun userJustLoggedIn() {
        userManager.userJustLoggedIn()
    }
}