package com.cy.eyepetizer.ui.community.commend.adapter

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.cy.eyepetizer.logic.model.CommunityRecommend
import java.util.*

class CommendAdapter: BaseProviderMultiAdapter<CommunityRecommend.Item>(),LoadMoreModule {

    init {
        addItemProvider(ItemCollectionProvider())
        addItemProvider(HorizontalProvider())
        addItemProvider(FollowCardProvider())
    }

    override fun getItemType(data: List<CommunityRecommend.Item>, position: Int): Int {
        when(cypherType(data[position])){
            "HORIZONTALSCROLLCARD_ITEMCOLLECTION" ->{
                return 1
            }
            "HORIZONTALSCROLLCARD_HORIZONTALSCROLLCARD" ->{
                return 2
            }
            "COMMUNITYCOLUMNSCARD_FOLLOWCARD" ->{
                return 3
            }
        }
        return 0
    }

    private fun cypherType(item: CommunityRecommend.Item):String{
        return "${item.type}_${item.data.dataType}".toUpperCase(Locale.ROOT)
    }
}