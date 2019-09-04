package arch.module.skyeng.ui.mainscreen

import arch.module.core.other.MvpRouter
import javax.inject.Inject


interface ISkyengMainScreenCoordinator {
    fun exit()
}


class SkyengMainScreenCoordinator @Inject constructor(
    private val router: MvpRouter
) : ISkyengMainScreenCoordinator {
    override fun exit() {
        router.exit()
    }
}