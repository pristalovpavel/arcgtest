package arch.module.aword

import android.app.Application
import arch.module.aword.di.AwordAppComponent
import arch.module.aword.di.AwordAppComponent.Companion.appComponent
import arch.module.core.di.ComponentDependenciesProvider
import moxy.RegisterMoxyReflectorPackages


//https://github.com/Arello-Mobile/Moxy/wiki/Multiple-modules
@RegisterMoxyReflectorPackages(
    value = [
        "arch.module.auth",
        "arch.module.userprofile"
    ]
)
class AwordApp : Application(), ComponentDependenciesProvider {


    override fun onCreate() {
        super.onCreate()

        AwordAppComponent.init(this)
        appComponent.inject(this)
    }

    override fun getComponent(): Any = appComponent
}