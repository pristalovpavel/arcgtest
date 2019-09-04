package arch.module.aword.di

import arch.module.aword.di.modules.WelcomeModule
import arch.module.aword.ui.welcome.WelcomeFragment
import arch.module.core.di.PerScreen
import dagger.Subcomponent


@PerScreen
@Subcomponent(modules = [WelcomeModule::class])
interface WelcomeComponent {

    @Subcomponent.Builder
    interface Builder {
//        fun welcome(mod:WelcomeModule): WelcomeComponent.Builder
        fun build(): WelcomeComponent
    }

    fun inject(fragment: WelcomeFragment)
}