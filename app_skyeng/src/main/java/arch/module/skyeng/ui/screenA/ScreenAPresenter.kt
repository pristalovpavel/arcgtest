package arch.module.skyeng.ui.screenA

import arch.module.skyeng.ui.base.BasePresenter
import moxy.InjectViewState

sealed class ScreenAOutCmd

object GoPressed : ScreenAOutCmd()
object ChildPressed : ScreenAOutCmd()

class OnCreate(val input: ScreenAIn) : ScreenAOutCmd()


interface ScreenAIn {
    fun done(counter: Int)

    fun coordinatorDone()
}


@InjectViewState
class ScreenAPresenter constructor(
    private val out: (ScreenAOutCmd) -> Unit
) : BasePresenter<IScreenAView>(),
    ScreenAIn {
    override fun onFirstViewAttach() {
        out(OnCreate(this))
    }

    override fun done(counter: Int) {
        viewState.showToast(counter)
    }

    fun openNextScreen() = out(GoPressed)

    fun openChildScreen() = out(ChildPressed)

    override fun coordinatorDone() {
        viewState.coordinatorDone()
    }
}