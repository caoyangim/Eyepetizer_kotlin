package com.cy.eyepetizer.ui.home.recycle

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.Item
import com.cy.eyepetizer.ui.home.discover.DiscoverViewHolder

class HomeAdapter :BaseMultiItemQuickAdapter<Item, DiscoverViewHolder>(){

    init {
        addItemType(ItemTypeEnum.UNKNOWN.typeId,R.layout.item_unknow)

        /*---Discover Fragment----*/
        addItemType(ItemTypeEnum.TEXTCARD_HEADER4.typeId,R.layout.item_text_card_type_header_four)
        addItemType(ItemTypeEnum.HORIZONTALSCROLLCARD_HORIZONTALSCROLLCARD.typeId,R.layout.item_horizontal_scroll_card_type)
        addItemType(ItemTypeEnum.SPECIALSQUARECARDCOLLECTION_ITEMCOLLECTION.typeId,R.layout.item_special_square_card_collection_type)
        addItemType(ItemTypeEnum.COLUMNCARDLIST_ITEMCOLLECTION.typeId,R.layout.item_column_card_list_type)
        addItemType(ItemTypeEnum.TEXTCARD_TEXTCARDWITHRIGHTANDLEFTTITLE.typeId,R.layout.item_text_card_type_header_seven)
        addItemType(ItemTypeEnum.BANNER_BANNER.typeId,R.layout.item_banner_type)
        addItemType(ItemTypeEnum.VIDEOSMALLCARD_VIDEOBEANFORCLIENT.typeId,R.layout.item_video_small_card_type)
        addItemType(ItemTypeEnum.BRIEFCARD_TAGBRIEFCARD.typeId,R.layout.item_brief_card_tag_brief_card_type)

        /*--推荐--*/
        addItemType(ItemTypeEnum.TEXTCARD_TEXTCARD.typeId,R.layout.item_text_card_type_header_five)
        addItemType(ItemTypeEnum.TEXTCARD_TEXTCARDWITHTAGID.typeId,R.layout.item_text_card_type_footer_three)
        addItemType(ItemTypeEnum.FOLLOWCARD_FOLLOWCARD.typeId,R.layout.item_follow_card_type)
        addItemType(ItemTypeEnum.INFORMATIONCARD_INFORMATIONCARD.typeId,R.layout.item_information_card_type)
        addItemType(ItemTypeEnum.UGCSELECTEDCARDCOLLECTION_ITEMCOLLECTION.typeId,R.layout.item_ugc_selected_card_collection_type)
        addItemType(ItemTypeEnum.BRIEFCARD_TOPICBRIEFCARD.typeId,R.layout.item_brief_card_topic_brief_card_type)
    }

    override fun convert(holder: DiscoverViewHolder, item: Item) {
        HolderConvert.convert(holder, item)
    }


}