package com.cy.eyepetizer.ui.community.commend.adapter

import android.widget.ImageView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cy.applibrary.extension.load
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.CommunityRecommend
import jp.wasabeef.glide.transformations.BlurTransformation

class ItemCollectionProvider(
    override val itemViewType: Int = 1,
    override val layoutId: Int = R.layout.item_community_commend_type1
) :BaseItemProvider<CommunityRecommend.Item>(){
    override fun convert(helper: BaseViewHolder, item: CommunityRecommend.Item) {
        (helper.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams).isFullSpan = true
        helper.apply {
            val list =  item.data.itemList
            getView<ImageView>(R.id.item_cc_img).load(list[0].data.bgPicture){
                RequestOptions.bitmapTransform(
                    MultiTransformation(
                        BlurTransformation(),
                        RoundedCorners(7)
                    )
                )
            }
            getView<ImageView>(R.id.item_cc_img_right).load(list[1].data.bgPicture){
                RequestOptions.bitmapTransform(MultiTransformation(BlurTransformation(),RoundedCorners(7)))
            }
            setText(R.id.item_cc_tit,list[0].data.title)
            setText(R.id.item_cc_des,list[0].data.subTitle)
            setText(R.id.item_cc_tit_right,list[1].data.title)
            setText(R.id.item_cc_des_right,list[1].data.subTitle)
        }
    }

}