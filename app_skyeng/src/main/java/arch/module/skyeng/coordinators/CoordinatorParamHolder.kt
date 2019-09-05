package arch.module.skyeng.coordinators


object CoordinatorParamHolder {

     val map = mutableMapOf<String, Any>()

    fun registerOut(key: String, out: Any) {
        map[key] = out
    }

    inline fun <reified T : Any> provideOut(key: String): T {
        return map[key] as? T  ?: throw IllegalArgumentException()
    }
}