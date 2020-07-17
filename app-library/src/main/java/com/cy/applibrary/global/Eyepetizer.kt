package com.cy.applibrary.global

import android.content.Context
import com.cy.applibrary.util.storage.MemoryStore

object Eyepetizer {
    private val configurator:Configurator
        get() = Configurator.Instance

    fun init(context:Context):Configurator{
        MemoryStore.Instance.addData(GlobalKeys.APPLICATION_CONTEXT,context)
        return configurator
    }

    fun<T> getConfiguration (key:String):T{
        return configurator.getConfiguration(key)
    }

    fun<T> getConfiguration (key:Enum<GlobalKeys>):T{
        return getConfiguration(key.name)
    }

}