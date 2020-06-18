package com.flauraha.ari.ui.splash

import com.flauraha.ari.user.UserManager
import javax.inject.Inject


/**
 * SplashViewModel is the ViewModel that [SplashActivity] uses to handle complex logic.
 */
class SplashViewModel @Inject constructor(private val userManager: UserManager) {

    fun userJustLoggedIn() {
        userManager.userJustLoggedIn()
    }
}