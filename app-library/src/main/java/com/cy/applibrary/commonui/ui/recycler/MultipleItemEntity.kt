package com.cy.applibrary.commonui.ui.recycler

class MultipleItemEntity internal constructor(fields:LinkedHashMap<*,*>){

    private val mMultipleFields = LinkedHashMap<Any,Any>()

    init {
        mMultipleFields.putAll(fields)
    }

    companion object{
        fun builder():MultipleEntityBuilder{
            return MultipleEntityBuilder()
        }
    }

    fun getItemType():Int{
        return mMultipleFields[MultipleFileds.ITEMTYPE] as Int
    }

    @Suppress("UNCHECKED_CAST")
    fun<T> getField(key:Any):T{
        return mMultipleFields[key] as T
    }

    fun setField(key: Any,value:Any):MultipleItemEntity{
        mMultipleFields[key] = value
        return this
    }
}