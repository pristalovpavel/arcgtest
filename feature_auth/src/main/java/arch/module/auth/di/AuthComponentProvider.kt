package arch.module.auth.di

import arch.module.auth.domain.LoginUseCase
import arch.module.corenetwork.api.RestDependencies
import arch.module.corenetwork.api.UrlDependencies
import dagger.Component


//@Singleton
@Component(
    dependencies = [
        RestDependencies::class, UrlDependencies::class
    ],
    modules = [AuthModule::class]
)
interface AuthComponentProvider {

    companion object {
        fun init(restDependencies: RestDependencies, urlDependencies: UrlDependencies): AuthComponentProvider {
            return DaggerAuthComponentProvider.builder()
                .restDependencies(restDependencies)
                .urlDependencies(urlDependencies)
                .build()
        }
    }

    fun loginUseCase(): LoginUseCase
}

