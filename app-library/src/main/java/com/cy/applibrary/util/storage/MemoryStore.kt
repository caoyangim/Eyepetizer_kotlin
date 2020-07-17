package com.cy.applibrary.util.storage

class MemoryStore private constructor(){
    private object Holder{
        internal val INSTANCE = MemoryStore()
    }

    companion object{
        val Instance:MemoryStore
            get() = Holder.INSTANCE
    }

    private val mDataMap = HashMap<String,Any>()

    fun <T>getData(key :String):T{
        @Suppress("UNCHECKED_CAST")
        return mDataMap[key] as T
    }

    fun <T>getData(key :Enum<*>):T{
        return getData(key.name)
    }

    fun addData(key :String ,value:Any):MemoryStore{
        mDataMap[key] = value
        return this
    }

    fun addData(key :Enum<*> ,value:Any):MemoryStore{
        return addData(key.name,value)
    }
}