package arch.module.skyeng.coordinators


typealias OutCallback = (Out) -> Unit

typealias Out = Any

interface IGetOutProvider {
    fun provideOut(): Out
}