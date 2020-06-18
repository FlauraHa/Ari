package com.flauraha.ari.ui.splash

import dagger.Subcomponent
import com.flauraha.ari.di.ActivityScope

// Scope annotation that the SplashComponent uses
// Classes annotated with @ActivityScope will have a unique instance in this Component
@ActivityScope
// Definition of a Dagger subcomponent
@Subcomponent
interface SplashComponent {

    // Factory to create instances of SplashComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: SplashActivity)
}