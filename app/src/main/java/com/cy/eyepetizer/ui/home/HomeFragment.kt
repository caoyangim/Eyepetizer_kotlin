package com.cy.eyepetizer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cy.applibrary.commonui.ui.BaseViewPagerFragment
import com.cy.applibrary.util.GlobalUtil
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.TabEntity
import com.cy.eyepetizer.ui.home.commend.CommendFragment
import com.cy.eyepetizer.ui.home.daily.DailyFragment
import com.flyco.tablayout.listener.CustomTabEntity

class HomeFragment : BaseViewPagerFragment() {
    override val createTitles = ArrayList<CustomTabEntity>().apply {
        add(TabEntity(GlobalUtil.getString(R.string.discovery)))
        add(TabEntity(GlobalUtil.getString(R.string.commend)))
        add(TabEntity(GlobalUtil.getString(R.string.daily)))
    }
    override val createFragments: Array<Fragment>
        get() = arrayOf(CommendFragment.newInstance(),CommendFragment.newInstance(), DailyFragment.newInstance())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_home,container,false))
    }



    companion object{
        fun newInstance() = HomeFragment()
    }
}