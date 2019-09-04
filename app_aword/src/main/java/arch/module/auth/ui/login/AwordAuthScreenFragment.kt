package arch.module.auth.ui.login

import arch.module.auth.di.AwordAuthComponent

class AwordAuthScreenFragment : AuthScreenFragment() {
    override fun diInject() {
        AwordAuthComponent.init(
            context!!
        ).inject(this)
    }
}