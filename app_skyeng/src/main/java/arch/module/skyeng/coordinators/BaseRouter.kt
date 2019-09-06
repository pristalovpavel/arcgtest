package arch.module.skyeng.coordinators

import ru.terrakok.cicerone.Router


abstract class BaseRouter(
    protected val router: Router,
    protected val callback: OutCallback
) {

    protected fun exit() {
        router.exit()
    }

    protected fun backTo(key: String) {
        router.backTo(key)
    }

    protected fun <T> navigateTo(out: (T) -> Unit, key: String) {
        callback(out)
        router.navigateTo(key)
    }

}