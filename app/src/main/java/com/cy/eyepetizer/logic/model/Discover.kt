package com.cy.eyepetizer.logic.model

data class Discover(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: Any,
    val total: Int
){
    data class Item(
        val adIndex: Int,
        val `data`: Data,
        val id: Int,
        val tag: Any,
        val type: String
    )

    data class Data(
        val actionUrl: Any,
        val adTrack: Any,
        val count: Int,
        val dataType: String,
        val description: String,
        val expert: Boolean,
        val follow: Any,
        val footer: Any,
        val haveReward: Boolean,
        val header: Header,
        val icon: String,
        val iconType: String,
        val id: Int,
        val ifNewest: Boolean,
        val ifPgc: Boolean,
        val ifShowNotificationIcon: Boolean,
        val itemList: List<ItemX>,
        val medalIcon: Boolean,
        val newestEndTime: Any,
        val rightText: String,
        val subTitle: Any,
        val switchStatus: Boolean,
        val text: String,
        val title: String,
        val type: String,
        val uid: Int
    )

    data class Header(
        val actionUrl: Any,
        val cover: Any,
        val font: String,
        val id: Int,
        val label: Any,
        val labelList: Any,
        val rightText: Any,
        val subTitle: Any,
        val subTitleFont: Any,
        val textAlign: String,
        val title: String
    )

    data class ItemX(
        val adIndex: Int,
        val `data`: DataX,
        val id: Int,
        val tag: Any,
        val type: String
    )

    data class DataX(
        val actionUrl: String,
        val adTrack: List<Any>,
        val autoPlay: Boolean,
        val dataType: String,
        val description: String,
        val header: HeaderX,
        val id: Int,
        val image: String,
        val label: Label,
        val labelList: List<Any>,
        val shade: Boolean,
        val title: String
    )

    data class HeaderX(
        val actionUrl: Any,
        val cover: Any,
        val description: Any,
        val font: Any,
        val icon: Any,
        val id: Int,
        val label: Any,
        val labelList: Any,
        val rightText: Any,
        val subTitle: Any,
        val subTitleFont: Any,
        val textAlign: String,
        val title: Any
    )

    data class Label(
        val card: String,
        val detail: Any,
        val text: String
    )
}

