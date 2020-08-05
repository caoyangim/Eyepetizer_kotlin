package com.cy.eyepetizer.ui.home.banner

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.cy.applibrary.R
import com.cy.eyepetizer.logic.model.ItemX
import com.zhpan.bannerview.BaseBannerAdapter

class ImageAdapter : BaseBannerAdapter<ItemX, ImageHolder>(){
    override fun getLayoutId(viewType: Int): Int = R.layout.item_banner_image

    override fun createViewHolder(itemView: View?, viewType: Int): ImageHolder = ImageHolder(itemView as AppCompatImageView)

    override fun onBind(holder: ImageHolder?, data: ItemX, position: Int, pageSize: Int) {
        holder?.bindData(data,position,pageSize)
    }
}