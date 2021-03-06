package com.cy.eyepetizer.logic.model

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.cy.eyepetizer.ui.home.recycle.ItemTypeEnum

data class Discover(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: Any,
    val total: Int
)

data class Item(
    val adIndex: Int,
    val `data`: Data,
    val id: Int,
    val tag: Any,
    val type: String
):MultiItemEntity{
    override val itemType: Int
        get() = ItemTypeEnum.findType(this)
}

data class Data(
    val actionUrl: String,
    val ad: Boolean,
    val adTrack: Any,
    val author: Author,
    val autoPlay: Boolean,
    val backgroundImage: String,
    val bannerList: List<Banner>,
    val brandWebsiteInfo: Any,
    val campaign: Any,
    val category: String,
    val collected: Boolean,
    val consumption: Consumption,
    val content: Content,
    val count: Int,
    val cover: Cover,
    val dataType: String,
    val date: Long,
    val description: String,
    val detail: Detail,
    val descriptionEditor: String,
    val descriptionPgc: Any,
    val duration: Int,
    val expert: Boolean,
    val favoriteAdTrack: Any,
    val follow: Any,
    val footer: Any,
    val haveReward: Boolean,
    val header: Header,
    val icon: String,
    val iconType: String,
    val id: Int,
    val idx: Int,
    val ifLimitVideo: Boolean,
    val ifNewest: Boolean,
    val ifPgc: Boolean,
    val ifShowNotificationIcon: Boolean,
    val image: String,
    val itemList: List<ItemX>,
    val label: Any,
    val labelList: Any,
    val lastViewTime: Any,
    val library: String,
    val medalIcon: Boolean,
    val newestEndTime: Any,
    val playInfo: List<PlayInfo>,
    val playUrl: String,
    val played: Boolean,
    val playlists: Any,
    val promotion: Any,
    val provider: Provider,
    val reallyCollected: Boolean,
    val recallSource: String,
    val refreshUrl: String,
    val releaseTime: Long,
    val remark: Any,
    val resourceType: String,
    val rightText: String,
    val searchWeight: Int,
    val shade: Boolean,
    val shareAdTrack: Any,
    val showHotSign: Boolean,
    val showImmediately: Boolean,
    val slogan: Any,
    val src: Int,
    val startTime: Long,
    val subTitle: Any,
    val subtitles: List<Any>,
    val switchStatus: Boolean,
    val tags: List<Tag>,
    val text: String,
    val thumbPlayUrl: Any,
    val title: String,
    val titleList: List<String>,
    val titlePgc: Any,
    val topicTitle: String,
    val type: String,
    val uid: Int,
    val videoPosterBean: VideoPosterBean,
    val waterMarks: Any,
    val webAdTrack: Any,
    val webUrl: WebUrl
)

data class Author(
    val adTrack: Any,
    val approvedNotReadyVideoCount: Int,
    val description: String,
    val expert: Boolean,
    val follow: Follow,
    val icon: String,
    val id: Int,
    val ifPgc: Boolean,
    val latestReleaseTime: Long,
    val link: String,
    val name: String,
    val recSort: Int,
    val shield: Shield,
    val videoNum: Int
)

data class Consumption(
    val collectionCount: Int,
    val realCollectionCount: Int,
    val replyCount: Int,
    val shareCount: Int
)

data class Cover(
    val blurred: String,
    val detail: String,
    val feed: String,
    val homepage: String,
    val sharing: Any
)

data class Header(
    val actionUrl: String,
    val cover: Any,
    val description: String,
    val font: Any,
    val icon: String,
    val iconType: String,
    val id: Int,
    val label: Any,
    val labelList: Any,
    val rightText: String,
    val showHateVideo: Boolean,
    val subTitle: Any,
    val subTitleFont: Any,
    val textAlign: String,
    val time: Long,
    val title: String
)

data class ItemX(
    val adIndex: Int,
    val `data`: DataX,
    val id: Int,
    val tag: Any,
    val type: String
)

data class PlayInfo(
    val height: Int,
    val name: String,
    val type: String,
    val url: String,
    val urlList: List<Url>,
    val width: Int
)

data class Provider(
    val alias: String,
    val icon: String,
    val name: String
)

data class Tag(
    val actionUrl: String,
    val adTrack: Any,
    val bgPicture: String,
    val childTagIdList: Any,
    val childTagList: Any,
    val communityIndex: Int,
    val desc: Any,
    val haveReward: Boolean,
    val headerImage: String,
    val id: Int,
    val ifNewest: Boolean,
    val name: String,
    val newestEndTime: Any,
    val tagRecType: String
)

data class VideoPosterBean(
    val fileSizeStr: Any,
    val scale: Any,
    val url: Any
)

data class WebUrl(
    val forWeibo: String,
    val raw: String
)

data class Follow(
    val followed: Boolean,
    val itemId: Int,
    val itemType: String
)

data class Shield(
    val itemId: Int,
    val itemType: String,
    val shielded: Boolean
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
    val title: String,
    val duration :Int,
    val cover: CoverXX,
    val dailyResource: Boolean,
    val nickname: String,
    val resourceType: String,
    val url: String,
    val urls: List<String>,
    val userCover: String
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

data class Url(
    val name: String,
    val size: Int,
    val url: String
)

