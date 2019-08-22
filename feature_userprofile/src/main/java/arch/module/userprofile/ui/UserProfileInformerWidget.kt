package arch.module.userprofile.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.Toast
import arch.module.moxymvp.ui.CoreWidget
import arch.module.userprofile.R
import arch.module.userprofile.domain.UserInfo
import kotlinx.android.synthetic.main.view_userprofileinformer_layout.view.*
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

//@FragmentScope
class UserProfileInformerWidget(context: Context, attributeSet: AttributeSet?) :
    CoreWidget<UserProfileInformerPresenter>(context, attributeSet),
    UserProfileInformerView {

    @InjectPresenter
    override lateinit var presenter: UserProfileInformerPresenter

    @ProvidePresenter
    override fun providePresenter(): UserProfileInformerPresenter = super.providePresenter()

    override fun getLayoutId(): Int =
        R.layout.view_userprofileinformer_layout

    override fun showInfo(info: UserInfo) {
        user_name.text = "Имя: ${info.identity}\nДоступно уроков: ${info.lessonCount}"
    }

    override fun showError(error: Throwable) {
        Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
    }
}

interface UserProfileInformerView : MvpView {

    fun showInfo(info: UserInfo)
    fun showError(error: Throwable)
}