# Eyepetizer_kotlin


### 简介

这是一个仿照 [开眼APP](https://www.kaiyanapp.com/) 开发的Android客户端。




### 相关截图
| ![首页](https://github.com/caoyangim/Eyepetizer_kotlin/blob/master/screenshots/Screenshot_1.png) | ![推荐](https://github.com/caoyangim/Eyepetizer_kotlin/blob/master/screenshots/Screenshot_2.png) | ![推送](https://github.com/caoyangim/Eyepetizer_kotlin/blob/master/screenshots/Screenshot_6.png) |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![社区](https://github.com/caoyangim/Eyepetizer_kotlin/blob/master/screenshots/Screenshot_4.png) | ![社区](https://github.com/caoyangim/Eyepetizer_kotlin/blob/master/screenshots/Screenshot_5.png) | ![我的](https://github.com/caoyangim/Eyepetizer_kotlin/blob/master/screenshots/Screenshot_7.png) |



### 代码亮点

运用了大量的封装方法，个人感觉还是比较优雅的。

比如底部导航栏封装为BaseBottomFragment基类，在主界面只需使用几行代码即可完成底部导航栏，且可定制性较高。

```kotlin
override fun setItems(builder: ItemBuilder): LinkedHashMap<BottomTabBean, BaseFragment?> {
    val items = LinkedHashMap<BottomTabBean,BaseFragment?>()
    items[BottomTabBean(R.drawable.sel_btn_home_page,"首页")] = HomeFragment.newInstance()
    items[BottomTabBean(R.drawable.sel_btn_community,"社区")] = CommunityFragment.newInstance()
    items[BottomTabBean(R.drawable.sel_btn_add,null,listener)] = null
    items[BottomTabBean(R.drawable.sel_btn_notification,"通知")] = NotificationFragment.newInstance()
    items[BottomTabBean(R.drawable.sel_btn_mine,"我的")] = MineFragment.newInstance()
    return builder.addItems(items).build()
}

private val listener = View.OnClickListener { //TODO }
```

再比如每个导航页下不同tab页面之间的配置，代码如下：

```kotlin
class HomeFragment(
    override val createTitles: ArrayList<CustomTabEntity> = arrayListOf(
        TabEntity("发现"),TabEntity("推荐"),TabEntity("日报")
    ),
    override val createFragments: Array<Fragment> = arrayOf(
        ATabFragment.newInstance(),BTabFragment.newInstance(),CTabFragment.newInstance()
    )
) : BaseViewPagerFragment() { //TODO }
```

大量的封装代码放在了library module下，业务代码放在了app module下，方便二次开发。

本项目为个人学习使用，若有代码问题，欢迎指正。:rofl:



### 相关技术

[Google MVVM 和 部分Jetpack组件](https://developer.android.com/jetpack)

[Kotlin](https://kotlinlang.org/)

网络请求：Retrofit + Kotlin协程 

图片框架：Glide

部分代码参考了[殷志威](https://vipyinzhiwei.com/)的[Eyepetizer项目](https://github.com/caoyangim/Eyepetizer),自主学习使用，在此鸣谢大佬们的开源。
