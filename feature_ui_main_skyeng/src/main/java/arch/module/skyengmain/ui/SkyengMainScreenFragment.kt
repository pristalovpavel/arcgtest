package arch.module.skyengmain.ui

import android.os.Bundle
import android.view.View
import arch.module.core.di.findComponentDependencies
import arch.module.core.ui.base.BaseFragment
import arch.module.core.ui.base.BasePresenter
import arch.module.skyengmain.R
import arch.module.skyengmain.di.SkyengMainScreenComponent
import arch.module.userprofile.ui.UserProfileInformerWidget
import dagger.MembersInjector
import kotlinx.android.synthetic.main.fragment_skyeng_main_screen.*
import moxy.InjectViewState
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject


internal class SkyengMainScreenFragment : BaseFragment<SkyengMainScreenPresenter>(),
    SkyengMainScreenView {

    @InjectPresenter
    override lateinit var presenter: SkyengMainScreenPresenter

    @ProvidePresenter
    override fun providePresenter(): SkyengMainScreenPresenter = super.providePresenter()

    override fun getLayoutId(): Int = R.layout.fragment_skyeng_main_screen

    override fun diInject() {
        SkyengMainScreenComponent.init(context!!, findComponentDependencies()).inject(this)
    }

    @Inject
    lateinit var userProfileInformerWidgetMembersInjector: MembersInjector<UserProfileInformerWidget>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logout.setOnClickListener {
            presenter.logout()
        }
        attachWidget(userProfileInformerWidget, userProfileInformerWidgetMembersInjector)
    }
}

@InjectViewState
internal class SkyengMainScreenPresenter @Inject constructor() :
    BasePresenter<SkyengMainScreenView>() {
    fun logout() {
        router.exit()
    }
}

internal interface SkyengMainScreenView : MvpView