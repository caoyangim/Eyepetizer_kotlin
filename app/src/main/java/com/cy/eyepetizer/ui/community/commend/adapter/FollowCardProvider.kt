package com.cy.eyepetizer.ui.community.commend.adapter

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cy.applibrary.commonui.view.TypefaceTextView
import com.cy.applibrary.extension.load
import com.cy.applibrary.global.GlobalKeys
import com.cy.applibrary.util.GlobalUtil
import com.cy.applibrary.util.storage.MemoryStore
import com.cy.eyepetizer.EyepetizerApp
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.CommunityRecommend
import de.hdodenhof.circleimageview.CircleImageView


class FollowCardProvider(
    override val itemViewType: Int = 3,
    override val layoutId: Int = R.layout.item_community_columns_card_follow_card_type
) :BaseItemProvider<CommunityRecommend.Item>() {
    override fun convert(helper: BaseViewHolder, item: CommunityRecommend.Item) {
        val height = item.data.content.data.height
        val width = item.data.content.data.width
        val realWidth = GlobalUtil.getWidth()/2
        val realHeight = realWidth * height / width
        val params = RelativeLayout.LayoutParams(realWidth, realHeight)
        helper.apply {
            getView<ImageView>(R.id.ivBgPicture).load(item.data.content.data.url, 6f)
            getView<ImageView>(R.id.ivBgPicture).layoutParams = params
            getView<TypefaceTextView>(R.id.tvDescription).text = item.data.content.data.description
            getView<CircleImageView>(R.id.ivRoundAvatar).load(item.data.content.data.owner.avatar)
            getView<TypefaceTextView>(R.id.tvNickName).text = item.data.content.data.owner.nickname
            getView<TypefaceTextView>(R.id.tvCollectionCount).text = item.data.content.data.consumption.collectionCount.toString()
        }
    }

}