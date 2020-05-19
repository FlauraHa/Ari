package ro.handrea.flaura.ari.user

import android.content.Context
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Handles User lifecycle. Manages sign in and logs out.
 * Knows when the user is logged in.
 */
@Singleton
class UserManager @Inject constructor(
    private val context: Context,
    // Since UserManager will be in charge of managing the UserComponent lifecycle,
    // it needs to know how to create instances of it
    private val userComponentFactory: UserComponent.Factory
) {

    var userComponent = if (FirebaseAuth.getInstance().currentUser != null) {
            userComponentFactory.create()
        } else {
            null
        }

    fun isUserLoggedIn() = userComponent != null

    fun isUserNew(): Boolean {
        //TODO
        return true
    }

    fun logout() {
        userComponent = null
        AuthUI.getInstance()
            .signOut(context)
            .addOnCompleteListener {
                // TODO
            }
    }

    fun unregister() {
//        val username = storage.getString(REGISTERED_USER)
//        storage.setString(REGISTERED_USER, "")
//        storage.setString("$username$PASSWORD_SUFFIX", "")

        AuthUI.getInstance()
            .delete(context)
            .addOnCompleteListener {
                // TODO
            }
        logout()
    }

    fun userJustLoggedIn() {
        //TODO
        // Store user's properties in DB, name, UID, email, profile pic...
//        val user = Firebase.auth.currentUser
//        user?.let {
//            // Name, email address, and profile photo Url
//            val name = user.displayName
//            val email = user.email
//            val photoUrl = user.photoUrl
//
//            // Check if user's email is verified
//            val emailVerified = user.isEmailVerified
//
//            // The user's ID, unique to the Firebase project. Do NOT use this value to
//            // authenticate with your backend server, if you have one. Use
//            // FirebaseUser.getToken() instead.
//            val uid = user.uid
//        }
        userComponent = userComponentFactory.create()
    }
}
