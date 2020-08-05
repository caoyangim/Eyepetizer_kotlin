package com.cy.eyepetizer.ui.home.recycle

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.Item
import com.cy.eyepetizer.logic.model.ItemX
import com.cy.eyepetizer.ui.home.banner.BannerCreator
import com.cy.eyepetizer.ui.home.banner.ImageHolder
import com.cy.eyepetizer.ui.home.discover.DiscoverViewHolder
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.BaseViewHolder

class HolderConvert {
    companion object{
        fun convert(holder: DiscoverViewHolder, item: Item){
            val typeid = holder.itemViewType
            when(ItemTypeEnum.getTypeEnum(typeid)){
                ItemTypeEnum.UNKNOWN -> {

                }
                ItemTypeEnum.TEXTCARD_HEADER4 -> {

                }
                ItemTypeEnum.TEXTCARD_HEADER5 -> TODO()
                ItemTypeEnum.HORIZONTALSCROLLCARD_HORIZONTALSCROLLCARD -> {
                    val banner = holder.getView<BannerViewPager<ItemX,ImageHolder>>(R.id.bannerViewPager)
                    BannerCreator.setDefault(banner, BannerViewPager.OnPageClickListener {

                    })
                    banner.refreshData(item.data.itemList)
                }
                ItemTypeEnum.SPECIALSQUARECARDCOLLECTION_ITEMCOLLECTION -> {
                    val recycle = holder.getView<RecyclerView>(R.id.recyclerView)

                }
                ItemTypeEnum.COLUMNCARDLIST_ITEMCOLLECTION -> {

                }
                ItemTypeEnum.TEXTCARD_TEXTCARDWITHRIGHTANDLEFTTITLE -> {

                }
                ItemTypeEnum.BANNER_BANNER -> {

                }
                ItemTypeEnum.VIDEOSMALLCARD_VIDEOBEANFORCLIENT -> {

                }
                ItemTypeEnum.BRIEFCARD_TAGBRIEFCARD -> {

                }
            }
        }
    }

    class BannerViewHolder<ItemX>(v:ImageView): BaseViewHolder<ItemX>(v) {
        override fun bindData(data: ItemX, position: Int, pageSize: Int) {
            TODO("Not yet implemented")
        }
    }
}