package ro.handrea.flaura.ari.di

import dagger.Module
import ro.handrea.flaura.ari.ui.splash.SplashComponent
import ro.handrea.flaura.ari.user.UserComponent

// This module tells AppComponent which are its subcomponents
@Module(subcomponents = [SplashComponent::class, UserComponent::class])
class AppSubcomponents