package ro.handrea.flaura.ari

import androidx.multidex.MultiDexApplication
import ro.handrea.flaura.ari.di.AppComponent
import ro.handrea.flaura.ari.di.DaggerAppComponent

class AriApplication: MultiDexApplication() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create(applicationContext)
    }
}