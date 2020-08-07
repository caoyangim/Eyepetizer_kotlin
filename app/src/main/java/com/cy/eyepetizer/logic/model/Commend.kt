package com.cy.eyepetizer.logic.model

data class Commend(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: String,
    val total: Int
)



data class Banner(
    val background_image: String,
    val link: String,
    val poster_image: String,
    val tag_name: String,
    val title: String
)



data class Content(
    val adIndex: Int,
    val `data`: DataX,
    val id: Int,
    val tag: Any,
    val type: String
)

data class Detail(
    val actionUrl: String,
    val adTrack: List<Any>,
    val adaptiveImageUrls: String,
    val adaptiveUrls: String,
    val canSkip: Boolean,
    val categoryId: Int,
    val countdown: Boolean,
    val cycleCount: Int,
    val description: String,
    val displayCount: Int,
    val displayTimeDuration: Int,
    val icon: String,
    val id: Int,
    val ifLinkage: Boolean,
    val imageUrl: String,
    val iosActionUrl: String,
    val linkageAdId: Int,
    val loadingMode: Int,
    val openSound: Boolean,
    val position: Int,
    val showActionButton: Boolean,
    val showImage: Boolean,
    val showImageTime: Int,
    val timeBeforeSkip: Int,
    val title: String,
    val url: String,
    val videoAdType: String,
    val videoType: String
)



data class PlayInfoX(
    val height: Int,
    val name: String,
    val type: String,
    val url: String,
    val urlList: List<UrlX>,
    val width: Int
)

data class ProviderX(
    val alias: String,
    val icon: String,
    val name: String
)

data class TagX(
    val actionUrl: String,
    val adTrack: Any,
    val bgPicture: String,
    val childTagIdList: Any,
    val childTagList: Any,
    val communityIndex: Int,
    val desc: String,
    val haveReward: Boolean,
    val headerImage: String,
    val id: Int,
    val ifNewest: Boolean,
    val name: String,
    val newestEndTime: Any,
    val tagRecType: String
)

data class VideoPosterBeanX(
    val fileSizeStr: Any,
    val scale: Any,
    val url: Any
)

data class WebUrlX(
    val forWeibo: String,
    val raw: String
)



data class AuthorX(
    val adTrack: Any,
    val approvedNotReadyVideoCount: Int,
    val description: String,
    val expert: Boolean,
    val follow: FollowX,
    val icon: String,
    val id: Int,
    val ifPgc: Boolean,
    val latestReleaseTime: Long,
    val link: String,
    val name: String,
    val recSort: Int,
    val shield: ShieldX,
    val videoNum: Int
)

data class ConsumptionX(
    val collectionCount: Int,
    val realCollectionCount: Int,
    val replyCount: Int,
    val shareCount: Int
)




data class FollowX(
    val followed: Boolean,
    val itemId: Int,
    val itemType: String
)

data class ShieldX(
    val itemId: Int,
    val itemType: String,
    val shielded: Boolean
)


data class CoverXX(
    val blurred: Any,
    val detail: String,
    val feed: String,
    val homepage: Any,
    val sharing: Any
)

data class UrlX(
    val name: String,
    val size: Int,
    val url: String
)