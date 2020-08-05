package com.cy.eyepetizer.ui.home.discover

import android.view.View
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class DiscoverViewHolder(view:View) :BaseViewHolder(view){

    //简单工厂模式
    companion object{
        fun create(view: View):DiscoverViewHolder{
            return DiscoverViewHolder(view)
        }
    }



}