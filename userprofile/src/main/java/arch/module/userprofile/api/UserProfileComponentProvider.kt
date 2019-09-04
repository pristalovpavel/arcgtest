package arch.module.userprofile.api

import arch.module.userprofile.domain.GetUserInfoUseCase

interface UserProfileDeps {
    fun provideGetUserInfoUseCase(): GetUserInfoUseCase
}