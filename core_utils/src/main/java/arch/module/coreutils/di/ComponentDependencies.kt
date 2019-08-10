package arch.module.coreutils.di

import androidx.fragment.app.Fragment


interface ComponentDependenciesProvider {
    fun getComponent(): Any
}

typealias ComponentDependencies = Any

inline fun <reified T : ComponentDependencies> Fragment.findComponentDependencies(): T {
    return (context!!.applicationContext as ComponentDependenciesProvider).getComponent() as T
}
