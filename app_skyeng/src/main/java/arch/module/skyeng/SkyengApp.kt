package arch.module.skyeng

import android.app.Application
import arch.module.skyeng.di.SkyengAppComponent
import arch.module.skyeng.di.SkyengAppComponent.Companion.appComponent
import moxy.RegisterMoxyReflectorPackages


//https://github.com/Arello-Mobile/Moxy/wiki/Multiple-modules
@RegisterMoxyReflectorPackages(value = ["arch.module.moxymvp"])
class SkyengApp : Application() {


    override fun onCreate() {
        super.onCreate()

        SkyengAppComponent.init(this)
        appComponent.inject(this)
    }
}