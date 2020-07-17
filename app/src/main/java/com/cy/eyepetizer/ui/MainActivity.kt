package com.cy.eyepetizer.ui

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.cy.applibrary.commonui.ui.BaseActivity
import com.cy.applibrary.extension.setOnClickListener
import com.cy.applibrary.extension.showToast
import com.cy.applibrary.util.GlobalUtil
import com.cy.eyepetizer.R
import com.cy.eyepetizer.ui.community.CommunityFragment
import com.cy.eyepetizer.ui.home.HomeFragment
import com.cy.eyepetizer.ui.notification.NotificationFragment
import kotlinx.android.synthetic.main.layout_bottom_navigation_bar.*

class MainActivity :BaseActivity(){
    private var backPressTime = 0L

    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    private var indexTab:MutableLiveData<Int> = MutableLiveData()
    private val homePageFragment: HomeFragment by lazy { HomeFragment.newInstance() }

    private val communityFragment: CommunityFragment by lazy {CommunityFragment.newInstance() }

    private val notificationFragment: NotificationFragment by lazy { NotificationFragment.newInstance() }

    private val fragments = ArrayList<Fragment>().apply {
        add(homePageFragment)
        add(communityFragment)
        add(notificationFragment)
    }

    override fun setupViews() {
        super.setupViews()
        addFragments()
        indexTab.observe(this, Observer {
            setTabSelection(it)
        })
        indexTab.value = 0
        setOnClickListener(btnHomePage,btnCommunity,btnNotification,btnMine){
            when(this){
                btnHomePage -> {
                    indexTab.value = 0
                }
                btnCommunity -> {
                    indexTab.value = 1
                }
                btnNotification -> {
                    indexTab.value = 2
                }
                btnMine -> {

                }
            }
        }
    }


    private fun addFragments() {
        supportFragmentManager.beginTransaction().apply {
            for(fm in fragments)  add(R.id.homeActivityFragContainer,fm)
        }.commit()
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        transaction.apply {
            for (f in fragments) hide(f)
        }
    }

    private fun setTabSelection(index:Int){
        clearAllSelected()
        when(index){
            0 -> {
                ivHomePage.isSelected = true
                tvHomePage.isSelected = true
            }
            1 -> {
                ivCommunity.isSelected = true
                tvCommunity.isSelected = true
            }
            2 -> {
                ivNotification.isSelected = true
                tvNotification.isSelected = true
            }
        }
        supportFragmentManager.beginTransaction().apply {
            hideFragment(this)
            show(fragments[index])
        }.commit()
    }

    private fun clearAllSelected() {
        ivHomePage.isSelected = false
        tvHomePage.isSelected = false
        ivCommunity.isSelected = false
        tvCommunity.isSelected = false
        ivNotification.isSelected = false
        tvNotification.isSelected = false
        ivMine.isSelected = false
        tvMine.isSelected = false
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            processBackPressed()
        }
    }

    private fun processBackPressed() {
        val now = System.currentTimeMillis()
        if (now - backPressTime > 2000) {
            String.format(GlobalUtil.getString(R.string.press_again_to_exit), GlobalUtil.appName).showToast()
            backPressTime = now
        } else {
            super.onBackPressed()
        }
    }

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

}
