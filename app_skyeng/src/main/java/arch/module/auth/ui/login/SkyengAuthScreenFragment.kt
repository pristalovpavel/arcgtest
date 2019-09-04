package arch.module.auth.ui.login

import arch.module.auth.di.SkyengAuthComponent
import arch.module.core.di.findComponentDependencies

// todo подумать как не делать такое говницо =(
// но если бы
class SkyengAuthScreenFragment : AuthScreenFragment() {

    override fun diInject() {
        // прост передать context и внутри все достать
        SkyengAuthComponent.init(
            findComponentDependencies(),
            findComponentDependencies(),
            findComponentDependencies(),
            findComponentDependencies()
        ).inject(this)
    }
}