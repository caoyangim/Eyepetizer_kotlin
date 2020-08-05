package com.cy.eyepetizer.ui.home.discover

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.Item
import com.cy.eyepetizer.ui.home.recycle.HolderConvert
import com.cy.eyepetizer.ui.home.recycle.ItemTypeEnum

class DiscoverAdapter :BaseMultiItemQuickAdapter<Item,DiscoverViewHolder>(){

    init {
        addItemType(ItemTypeEnum.UNKNOWN.typeId,R.layout.item_unknow)
        addItemType(ItemTypeEnum.TEXTCARD_HEADER4.typeId,R.layout.item_text_card_type_header_four)
        addItemType(ItemTypeEnum.TEXTCARD_HEADER5.typeId,R.layout.item_text_card_type_header_five)
        addItemType(ItemTypeEnum.HORIZONTALSCROLLCARD_HORIZONTALSCROLLCARD.typeId,R.layout.item_horizontal_scroll_card_type)
        addItemType(ItemTypeEnum.SPECIALSQUARECARDCOLLECTION_ITEMCOLLECTION.typeId,R.layout.item_special_square_card_collection_type)
        addItemType(ItemTypeEnum.COLUMNCARDLIST_ITEMCOLLECTION.typeId,R.layout.item_column_card_list_type)
        addItemType(ItemTypeEnum.TEXTCARD_TEXTCARDWITHRIGHTANDLEFTTITLE.typeId,R.layout.item_text_card_type_header_seven)
        addItemType(ItemTypeEnum.BANNER_BANNER.typeId,R.layout.item_banner_type)
        addItemType(ItemTypeEnum.VIDEOSMALLCARD_VIDEOBEANFORCLIENT.typeId,R.layout.item_follow_card_type)
        addItemType(ItemTypeEnum.BRIEFCARD_TAGBRIEFCARD.typeId,R.layout.item_brief_card_tag_brief_card_type)
    }

    override fun convert(holder: DiscoverViewHolder, item: Item) {
        HolderConvert.convert(holder, item)
    }

}