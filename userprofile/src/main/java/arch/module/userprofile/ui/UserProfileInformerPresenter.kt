package arch.module.userprofile.ui

import android.annotation.SuppressLint
import arch.module.core.ui.base.BasePresenter
import arch.module.userprofile.domain.GetUserInfoUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class UserProfileInformerPresenter @Inject constructor(
    private val getUserInfo: GetUserInfoUseCase
) : BasePresenter<UserProfileInformerView>() {

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getUserInfo()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showInfo(it)
                },
                {
                    viewState.showError(it)
                })
    }
}