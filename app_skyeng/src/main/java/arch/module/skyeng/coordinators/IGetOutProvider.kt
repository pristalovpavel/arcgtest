package arch.module.skyeng.coordinators


typealias Out = Any

interface IGetOutProvider {
    fun provideOut(): Out
}