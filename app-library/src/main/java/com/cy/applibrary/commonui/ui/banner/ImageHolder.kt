package com.cy.applibrary.commonui.ui.banner

import androidx.appcompat.widget.AppCompatImageView
import com.cy.applibrary.R
import com.cy.applibrary.extension.load
import com.zhpan.bannerview.BaseViewHolder


class ImageHolder(v: AppCompatImageView) : BaseViewHolder<String>(v) {

    private var imageView:AppCompatImageView = findView(R.id.item_banner_image)

    override fun bindData(url: String, position: Int, pageSize: Int) {
        imageView.load(url,5f)
    }
}