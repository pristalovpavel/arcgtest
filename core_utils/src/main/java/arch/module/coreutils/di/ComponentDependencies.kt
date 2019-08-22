package arch.module.coreutils.di

import android.content.Context
import androidx.fragment.app.Fragment


interface ComponentDependenciesProvider {
    fun getComponent(): Any
}

typealias ComponentDependencies = Any

inline fun <reified T : ComponentDependencies> Context.findComponentDependencies(): T {
    return (this.applicationContext as ComponentDependenciesProvider).getComponent() as T
}

inline fun <reified T : ComponentDependencies> Fragment.findComponentDependencies(): T {
    return context!!.findComponentDependencies()
}

