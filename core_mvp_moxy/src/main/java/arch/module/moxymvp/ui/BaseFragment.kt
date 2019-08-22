package arch.module.moxymvp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.StringRes
import arch.module.corenavigation.NestedNavigation
import dagger.MembersInjector
import moxy.MvpAppCompatFragment
import javax.inject.Inject
import javax.inject.Provider


abstract class BaseFragment<P : BasePresenter<*>>
    : MvpAppCompatFragment(),
    NestedNavigation {

    abstract fun getLayoutId(): Int

    override fun onBackPressed(): Boolean = presenter.onBackPressed()

    abstract var presenter: P

    @Inject
    lateinit var presenterProvider: Provider<P>

    @CallSuper
    open fun providePresenter(): P = presenterProvider.get()

    override fun onAttach(activity: Context) {
        diInject()
        super.onAttach(activity)
    }

    abstract fun diInject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    protected fun <D, T : CoreWidget<D>> attachWidget(moxyWidget: T, members: MembersInjector<T>) {
        members.injectMembers(moxyWidget)
        moxyWidget.init(mvpDelegate)
    }

    fun showToast(text: String) {
        context?.run {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(@StringRes text: Int) {
        showToast(getString(text))
    }
}