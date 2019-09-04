package arch.module.core.di

import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFeature

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFlow

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerScreen