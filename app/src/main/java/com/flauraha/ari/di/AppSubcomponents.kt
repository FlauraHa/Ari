package com.flauraha.ari.di

import dagger.Module
import com.flauraha.ari.ui.splash.SplashComponent
import com.flauraha.ari.user.UserComponent

// This module tells AppComponent which are its subcomponents
@Module(subcomponents = [SplashComponent::class, UserComponent::class])
class AppSubcomponents