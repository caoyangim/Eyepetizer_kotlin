package com.cy.applibrary.commonui.ui.banner

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.cy.applibrary.R
import com.zhpan.bannerview.BaseBannerAdapter

class ImageAdapter : BaseBannerAdapter<String, ImageHolder>(){
    override fun getLayoutId(viewType: Int): Int = R.layout.item_banner_image

    override fun createViewHolder(itemView: View?, viewType: Int): ImageHolder = ImageHolder(itemView as AppCompatImageView)

    override fun onBind(holder: ImageHolder?, data: String, position: Int, pageSize: Int) {
        holder?.bindData(data,position,pageSize)
    }
}