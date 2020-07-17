package com.cy.applibrary.global

import android.os.Handler
import com.cy.applibrary.util.storage.MemoryStore
import java.lang.RuntimeException


class Configurator private constructor(){
    private object Holder{
        val INSTANCE = Configurator()
    }

    companion object{
        //全局存储容器
        private val mStore:MemoryStore = MemoryStore.Instance
        //全局handler,因为需要反复配置
        private val mHandler = Handler()

        val Instance:Configurator
            get() = Holder.INSTANCE
    }

    init {
        mStore.addData(GlobalKeys.IS_CONFIGURE_READY,false)
        mStore.addData(GlobalKeys.HANDLER, mHandler)
    }

    /**
     * 访问服务器api设置
     */
    fun withApiHost(host:String):Configurator{
        mStore.addData(GlobalKeys.API_HOST,host)
        return this
    }

    /**
     * 结束配置
     */
    fun configure(){
        mStore.addData(GlobalKeys.IS_CONFIGURE_READY,true)
        //下面可以做一些回收方法
    }

    private fun checkConfiguration(){
        val isReady = mStore.getData<Boolean>(GlobalKeys.IS_CONFIGURE_READY)
        if (!isReady){
            throw RuntimeException("config is not ready")
        }
    }

    fun <T>getConfiguration(key:String):T{
        return mStore.getData(key)
    }

    fun <T>getConfiguration(key:Enum<*>):T{
        return getConfiguration(key.name)
    }
}