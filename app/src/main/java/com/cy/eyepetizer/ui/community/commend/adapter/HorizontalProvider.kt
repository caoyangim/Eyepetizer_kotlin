package com.cy.eyepetizer.ui.community.commend.adapter

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cy.applibrary.extension.load
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.CommunityRecommend

class HorizontalProvider(
    override val itemViewType: Int = 2,
    override val layoutId: Int = R.layout.item_community_commend_type2
) :BaseItemProvider<CommunityRecommend.Item>() {
    override fun convert(helper: BaseViewHolder, item: CommunityRecommend.Item) {
        (helper.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams).isFullSpan = true
       val rec =  helper.getView<RecyclerView>(R.id.item_cc_rec)
       rec.adapter = HorizontalAdapter(item.data.itemList.toMutableList())
    }

    class HorizontalAdapter(data:MutableList<CommunityRecommend.Item.Data.Item>):BaseQuickAdapter<CommunityRecommend.Item.Data.Item,BaseViewHolder>(R.layout.item_banner_type,data){
        override fun convert(holder: BaseViewHolder, item: CommunityRecommend.Item.Data.Item) {
            holder.getView<ImageView>(R.id.ivPicture).load(item.data.image,5f)
        }
    }
}

