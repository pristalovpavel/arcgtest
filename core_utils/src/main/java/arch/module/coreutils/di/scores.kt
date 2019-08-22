package arch.module.coreutils.di

import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFeature

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerScreen