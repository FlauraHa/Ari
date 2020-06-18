package com.flauraha.ari.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import com.flauraha.ari.ui.splash.SplashComponent
import com.flauraha.ari.user.UserManager
import javax.inject.Singleton

// Definition of a Dagger component
@Singleton
@Component(modules = [AppSubcomponents::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Expose SplashComponent factory from the graph
    fun splashComponent(): SplashComponent.Factory

    fun userManager(): UserManager
}