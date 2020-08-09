package com.cy.eyepetizer.ui.home.recycle

import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.cy.applibrary.extension.conversionVideoDuration
import com.cy.applibrary.extension.load
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.Item
import com.cy.eyepetizer.logic.model.ItemX
import com.cy.eyepetizer.ui.home.banner.BannerCreator
import com.cy.eyepetizer.ui.home.banner.ImageHolder
import com.cy.eyepetizer.ui.home.discover.DiscoverViewHolder
import com.zhpan.bannerview.BannerViewPager
import jp.wasabeef.glide.transformations.BlurTransformation


class HolderConvert {
    companion object{

        fun convert(holder: DiscoverViewHolder, item: Item){
            val typeid = holder.itemViewType
            when(ItemTypeEnum.getTypeEnum(typeid)){
                ItemTypeEnum.UNKNOWN -> { }
                ItemTypeEnum.TEXTCARD_HEADER4 -> TODO()
                ItemTypeEnum.TEXTCARD_TEXTCARD -> {
                    holder.setText(R.id.tvTitle5,item.data.text)
                }
                ItemTypeEnum.HORIZONTALSCROLLCARD_HORIZONTALSCROLLCARD -> {
                    val banner = holder.getView<BannerViewPager<ItemX,ImageHolder>>(R.id.bannerViewPager)
                    BannerCreator.setDefault(banner, BannerViewPager.OnPageClickListener {

                    })
                    banner.refreshData(item.data.itemList)
                }
                ItemTypeEnum.SPECIALSQUARECARDCOLLECTION_ITEMCOLLECTION -> {
                    val recycle = holder.getView<RecyclerView>(R.id.recyclerView)
                    recycle.layoutManager = GridLayoutManager(recycle.context,2,RecyclerView.HORIZONTAL,false)
                    recycle.adapter = SpecialSquareRcAdapter(R.layout.item_special_square_card_collection_type_item,item.data.itemList.toMutableList())
                    val decoration =
                        DividerItemDecoration(recycle.context, DividerItemDecoration.VERTICAL)
                    recycle.addItemDecoration(GridDecoration(0,4))
                    holder.setText(R.id.tvTitle,item.data.header.title)
                    holder.setText(R.id.tvRightText,item.data.header.rightText)
                }
                ItemTypeEnum.COLUMNCARDLIST_ITEMCOLLECTION -> {
                    holder.getView<RecyclerView>(R.id.recyclerView).run {
                        layoutManager = GridLayoutManager(this.context,2,RecyclerView.VERTICAL,false)
                        adapter = SpecialSquareRcAdapter(R.layout.item_column_card_list_type_item,item.data.itemList.toMutableList())
                        addItemDecoration(GridDecoration(6,6))
                    }

                    holder.setText(R.id.tvTitle,item.data.header.title)
                    holder.setText(R.id.tvRightText,item.data.header.rightText)
                }
                ItemTypeEnum.TEXTCARD_TEXTCARDWITHRIGHTANDLEFTTITLE -> {
                    holder.setText(R.id.tvTitle7,item.data.text)
                    holder.setText(R.id.tvRightText7,item.data.rightText)
                }
                ItemTypeEnum.BANNER_BANNER -> {
                    holder.getView<ImageView>(R.id.ivPicture).load(item.data.image)
                }
                ItemTypeEnum.VIDEOSMALLCARD_VIDEOBEANFORCLIENT -> {
                    holder.run {
                        getView<ImageView>(R.id.ivPicture).load(item.data.cover.feed,4f)
                        setText(R.id.tvVideoDuration,item.data.duration.conversionVideoDuration())
                        setText(R.id.tvTitle,item.data.title)
                        setText(R.id.tvDescription,if (item.data.library == DAILY_LIBRARY_TYPE) "#${item.data.category} / 开眼精选" else "#${item.data.category}")
                    }

                }
                ItemTypeEnum.BRIEFCARD_TAGBRIEFCARD -> {
                    holder.run {
                        getView<ImageView>(R.id.ivPicture).load(item.data.icon)
                        setText(R.id.tvTitle,item.data.title)
                        setText(R.id.tvDescription,item.data.description)
                    }
                }
                ItemTypeEnum.TEXTCARD_TEXTCARDWITHTAGID -> {
                    holder.apply {
                        setText(R.id.tvRefresh,item.data.title)
                        setText(R.id.tvFooterRightText3,item.data.rightText)
                    }
                }
                ItemTypeEnum.FOLLOWCARD_FOLLOWCARD -> {
                    holder.run {
                        getView<ImageView>(R.id.ivAvatar).load(item.data.header.icon)
                        setText(R.id.tvTitle,item.data.header.title)
                        setText(R.id.tvDescription,item.data.header.description)
                        setText(R.id.tvVideoDuration,item.data.content.data.duration.conversionVideoDuration())
                        getView<ImageView>(R.id.ivVideo).load(item.data.content.data.cover.feed)
                    }
                }
                ItemTypeEnum.INFORMATIONCARD_INFORMATIONCARD -> {
                    holder.run {
                        getView<ImageView>(R.id.ivCover).load(item.data.backgroundImage)
                    }
                }

                ItemTypeEnum.UGCSELECTEDCARDCOLLECTION_ITEMCOLLECTION -> {
                    holder.run {
                        setText(R.id.tvTitle,item.data.header.title)
                        setText(R.id.tvRightText,item.data.header.rightText)
                        getView<ImageView>(R.id.ivCoverLeft).load(item.data.itemList[0].data.url)
                        getView<ImageView>(R.id.ivCoverRightTop).load(item.data.itemList[1].data.url)
                        getView<ImageView>(R.id.ivCoverRightBottom).load(item.data.itemList[2].data.url)
                    }
                }
                ItemTypeEnum.BRIEFCARD_TOPICBRIEFCARD -> {
                    holder.run {
                        setText(R.id.tvTitle,item.data.title)
                        setText(R.id.tvDescription,item.data.description)
                        getView<ImageView>(R.id.ivPicture).load(item.data.icon)
                    }
                }
            }
        }

        const val DAILY_LIBRARY_TYPE = "DAILY"
    }

    class SpecialSquareRcAdapter(@LayoutRes layoutResId:Int, itemxs:MutableList<ItemX>):BaseQuickAdapter<ItemX,com.chad.library.adapter.base.viewholder.BaseViewHolder>(layoutResId,itemxs){
        override fun convert(
            holder: com.chad.library.adapter.base.viewholder.BaseViewHolder,
            item: ItemX
        ) {
            holder.setText(R.id.tvTitle,item.data.title)
            val img = holder.getView<ImageView>(R.id.ivPicture)
            img.load(item.data.image){
                RequestOptions.bitmapTransform(MultiTransformation(BlurTransformation(),RoundedCorners(15)))
            }
        }
    }

}