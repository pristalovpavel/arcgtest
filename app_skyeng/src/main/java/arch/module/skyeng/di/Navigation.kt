package arch.module.skyeng.di

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router


class Navigation private constructor()  {

    companion object {
        val instanse = Navigation()
    }


    val router = Router()
    val navigatorHolder = Cicerone.create(router).navigatorHolder
}