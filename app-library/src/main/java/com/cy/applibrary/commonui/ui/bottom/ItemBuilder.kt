package com.cy.applibrary.commonui.ui.bottom

import com.cy.applibrary.commonui.ui.BaseFragment

class ItemBuilder {
    private val mItems = LinkedHashMap<BottomTabBean,BaseFragment?>()

    fun build():LinkedHashMap<BottomTabBean,BaseFragment?> = mItems

    companion object{
        internal fun builder() = ItemBuilder()
    }

    fun addItem(bottomTabBean: BottomTabBean,bottomFragment: BaseFragment?):ItemBuilder{
        mItems[bottomTabBean] = bottomFragment
        return this
    }

    fun addItems(items:LinkedHashMap<BottomTabBean,BaseFragment?>):ItemBuilder{
        mItems.putAll(items)
        return this
    }


}