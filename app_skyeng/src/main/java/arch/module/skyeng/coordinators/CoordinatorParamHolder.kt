package arch.module.skyeng.coordinators


object CoordinatorParamHolder {

    private val map = mutableMapOf<String, Any>()

    fun registerOut(key: String, out: Any) {
        map[key] = out
    }

    fun provideOut(key: String): Any {
        return map[key] ?: throw IllegalArgumentException()
    }
}