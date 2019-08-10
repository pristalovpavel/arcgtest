package arch.module.skyeng

import android.app.Application
import arch.module.coreutils.di.ComponentDependenciesProvider
import arch.module.skyeng.di.SkyengAppComponent
import arch.module.skyeng.di.SkyengAppComponent.Companion.appComponent
import moxy.RegisterMoxyReflectorPackages


//https://github.com/Arello-Mobile/Moxy/wiki/Multiple-modules
@RegisterMoxyReflectorPackages(
    value = [
        "arch.module.auth",
        "arch.module.mainskyeng"
    ]
)
class SkyengApp : Application(), ComponentDependenciesProvider {


    override fun onCreate() {
        super.onCreate()

        SkyengAppComponent.init(this)
        appComponent.inject(this)
    }

    override fun getComponent(): Any = appComponent
}