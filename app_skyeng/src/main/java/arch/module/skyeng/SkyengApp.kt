package arch.module.skyeng

import android.app.Application
import moxy.RegisterMoxyReflectorPackages


//https://github.com/Arello-Mobile/Moxy/wiki/Multiple-modules
@RegisterMoxyReflectorPackages(value = ["arch.module.moxymvp"])
class SkyengApp : Application() {
}