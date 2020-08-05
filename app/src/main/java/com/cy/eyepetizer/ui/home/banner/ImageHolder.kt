package com.cy.eyepetizer.ui.home.banner

import androidx.appcompat.widget.AppCompatImageView
import com.cy.applibrary.R
import com.cy.applibrary.extension.load
import com.cy.eyepetizer.logic.model.ItemX
import com.zhpan.bannerview.BaseViewHolder


class ImageHolder(v: AppCompatImageView) : BaseViewHolder<ItemX>(v) {

    private var imageView:AppCompatImageView = findView(R.id.item_banner_image)

    override fun bindData(data: ItemX, position: Int, pageSize: Int) {
        imageView.load(data.data.image,5f)
    }
}