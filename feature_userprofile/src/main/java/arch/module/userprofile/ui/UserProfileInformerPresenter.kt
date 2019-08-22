package arch.module.userprofile.ui;

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import arch.module.moxymvp.ui.BasePresenter
import arch.module.moxymvp.ui.CoreWidget
import arch.module.userprofile.R
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.view_userprofileinformer_layout.view.*
import moxy.InjectViewState
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.util.concurrent.TimeUnit
import javax.inject.Inject


//@FragmentScope
class UserProfileInformerWidget(context: Context, attributeSet: AttributeSet?) :
        CoreWidget<UserProfileInformerPresenter>(context, attributeSet),
        UserProfileInformerView {

    @InjectPresenter
    override lateinit var presenter: UserProfileInformerPresenter

    @ProvidePresenter
    override fun providePresenter(): UserProfileInformerPresenter = super.providePresenter()

    override fun getLayoutId(): Int = R.layout.view_userprofileinformer_layout

    override fun showInfo(name: String) {
        user_name.text = "Имя: $name"
    }
}


@InjectViewState
class UserProfileInformerPresenter @Inject constructor(
) : BasePresenter<UserProfileInformerView>() {

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Single.timer(3, TimeUnit.SECONDS)
                .map { "Алёшка)" }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { info: String ->
                    viewState.showInfo(info)
                }


    }
}

interface UserProfileInformerView : MvpView {

    fun showInfo(name: String)
}