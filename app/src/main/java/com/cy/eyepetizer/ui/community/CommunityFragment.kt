package com.cy.eyepetizer.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cy.applibrary.commonui.ui.BaseViewPagerFragment
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.TabEntity
import com.cy.eyepetizer.ui.community.commend.CommendFragment
import com.cy.eyepetizer.ui.community.follow.FollowFragment
import com.flyco.tablayout.listener.CustomTabEntity

class CommunityFragment :BaseViewPagerFragment(){
    override val createTitles: ArrayList<CustomTabEntity>
        get() = ArrayList<CustomTabEntity>().apply {
            add(TabEntity("推荐"))
            add(TabEntity("关注"))
        }
    override val createFragments: Array<Fragment>
        get() = arrayOf(CommendFragment.newInstance(),FollowFragment.newInstance())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_community,container,false))
    }

    companion object{
        fun newInstance() = CommunityFragment()
    }
}