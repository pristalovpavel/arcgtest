package arch.module.skyeng.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import arch.module.skyeng.coordinators.IGetOutProvider
import arch.module.skyeng.coordinators.Out


inline fun <F : Fragment> F.withParam(block: Bundle.() -> Unit): F {
    return this.apply {
        this.arguments = Bundle().apply {
            block.invoke(this)
        }
    }
}

fun Fragment.getBooleanParam(key: String): Boolean {
    return arguments?.getBoolean(key) ?: throw IllegalStateException()
}

fun Fragment.getIntParam(key: String): Int {
    return arguments?.getInt(key) ?: throw IllegalStateException()
}

fun Fragment.getStringParam(key: String): String {
    return arguments?.getString(key) ?: throw IllegalStateException()
}


inline fun <reified T : Out> Context?.provideOut(): T {
    return (this!! as IGetOutProvider).provideOut() as? T ?: throw IllegalArgumentException()
}