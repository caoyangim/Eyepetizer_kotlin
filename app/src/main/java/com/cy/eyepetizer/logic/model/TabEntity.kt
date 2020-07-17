package com.cy.eyepetizer.logic.model

import com.flyco.tablayout.listener.CustomTabEntity

class TabEntity(private var title:String,private var selectIcon:Int = 0,private var unSelectIcon:Int = 0) : CustomTabEntity {
    override fun getTabUnselectedIcon(): Int {
        return unSelectIcon
    }

    override fun getTabSelectedIcon(): Int {
        return selectIcon
    }

    override fun getTabTitle(): String {
        return title
    }

}