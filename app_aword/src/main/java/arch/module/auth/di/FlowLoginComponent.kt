package arch.module.auth.di

import android.content.Context
import arch.module.aword.ui.loginflow.LoginFlowFragment
import arch.module.core.di.NavigationDependencies
import arch.module.core.di.PerFlow
import arch.module.core.di.findComponentDependencies
import arch.module.core.di.modules.FlowNavigationModule
import arch.module.core.di.modules.FlowRouter
import dagger.Component


@PerFlow
@Component(
    dependencies = [
        NavigationDependencies::class
    ],
    modules = [
        FlowNavigationModule::class
    ]
)
interface FlowLoginComponent {

    fun inject(fragment: LoginFlowFragment)

    companion object {
        lateinit var flowLoginComponent: FlowLoginComponent
        fun init(context: Context): FlowLoginComponent {
            flowLoginComponent = DaggerFlowLoginComponent.builder()
                .navigationDependencies(context.findComponentDependencies())
                .build()
            return flowLoginComponent
        }
    }


    fun flowRouter(): FlowRouter

}