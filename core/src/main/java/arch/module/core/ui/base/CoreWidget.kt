package arch.module.core.ui.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.CallSuper
import moxy.MvpDelegate
import javax.inject.Inject
import javax.inject.Provider


abstract class CoreWidget<P>(
    context: Context, attributeSet: AttributeSet?, defStyleAttr: Int
) : FrameLayout(context, attributeSet, defStyleAttr) {

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    init {
        initView(context, attributeSet, defStyleAttr)
    }

    private var mParentDelegate: MvpDelegate<Any>? = null
    private lateinit var mMvpDelegate: MvpDelegate<CoreWidget<P>>

    abstract var presenter: P

    @Inject
    lateinit var presenterProvider: Provider<P>

    @CallSuper
    open fun providePresenter(): P = presenterProvider.get()

    private fun initView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = mInflater.inflate(getLayoutId(), this, false)
        addView(view)
        onViewCreated(view, attrs, defStyleAttr)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        getMvpDelegate().onSaveInstanceState()
        getMvpDelegate().onDetach()
    }

    fun init(parentDelegate: MvpDelegate<Any>) {
        mParentDelegate = parentDelegate

        getMvpDelegate().onCreate()
        onReady()
        getMvpDelegate().onAttach()
    }


    protected abstract fun getLayoutId(): Int

    protected open fun onViewCreated(view: View, attrs: AttributeSet?, defStyleAttr: Int) {}

    protected open fun onReady() {

    }

    private fun getMvpDelegate(): MvpDelegate<CoreWidget<P>> {
        if (::mMvpDelegate.isInitialized) {
            return mMvpDelegate
        }

        mMvpDelegate = MvpDelegate(this)
        mMvpDelegate.setParentDelegate(mParentDelegate, id.toString())
        return mMvpDelegate
    }
}