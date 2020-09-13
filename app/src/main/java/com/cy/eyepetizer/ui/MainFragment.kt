package com.cy.eyepetizer.ui

import android.graphics.Color
import android.view.View
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.applibrary.commonui.ui.bottom.BaseBottomFragment
import com.cy.applibrary.commonui.ui.bottom.BottomTabBean
import com.cy.applibrary.commonui.ui.bottom.ItemBuilder
import com.cy.applibrary.extension.showToast
import com.cy.eyepetizer.R
import com.cy.eyepetizer.ui.community.CommunityFragment
import com.cy.eyepetizer.ui.home.HomeFragment
import com.cy.eyepetizer.ui.mine.MineFragment
import com.cy.eyepetizer.ui.notification.NotificationFragment

class MainFragment :BaseBottomFragment(){
    override fun setItems(builder: ItemBuilder): LinkedHashMap<BottomTabBean, BaseFragment?> {
        val items = LinkedHashMap<BottomTabBean,BaseFragment?>()
        items[BottomTabBean(R.drawable.sel_btn_home_page,"首页")] = HomeFragment.newInstance()
        items[BottomTabBean(R.drawable.sel_btn_community,"社区")] = CommunityFragment.newInstance()
        items[BottomTabBean(R.drawable.sel_btn_add,null,listener)] = null
        items[BottomTabBean(R.drawable.sel_btn_notification,"通知")] = NotificationFragment.newInstance()
        items[BottomTabBean(R.drawable.sel_btn_mine,"我的")] = MineFragment.newInstance()
        return builder.addItems(items).build()
    }

    private val listener = View.OnClickListener {
        "这里应跳转登录界面,但是作者很懒不想写了>_<".showToast()
    }

    override fun setIndexFragment(): Int = 0
    override fun setClickedColor(): Int = Color.BLACK

    companion object{
        fun newInstance() = MainFragment()

    }
}