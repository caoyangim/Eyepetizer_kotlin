package com.cy.applibrary.commonui.ui.recycler

class MultipleItemEntity internal constructor(fields:LinkedHashMap<*,*>){

    private val mMultipleFields = LinkedHashMap<Any,Any>()

    init {
        mMultipleFields.putAll(fields)
    }

    fun getItemType():Int{
        return mMultipleFields[MultipleFileds.ITEMTYPE] as Int
    }

    fun setItemType(){

    }
}