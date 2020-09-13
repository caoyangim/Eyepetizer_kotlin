package com.cy.eyepetizer.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cy.applibrary.commonui.ui.BaseViewPagerFragment
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.TabEntity
import com.cy.eyepetizer.ui.notification.nologin.NoLoginFragment
import com.cy.eyepetizer.ui.notification.push.PushFragment
import com.flyco.tablayout.listener.CustomTabEntity

class NotificationFragment(
    override val createTitles: ArrayList<CustomTabEntity> = arrayListOf(
        TabEntity("推送"),TabEntity("互动"),TabEntity("私信")
    ),
    override val createFragments: Array<Fragment> = arrayOf(
        PushFragment.newInstance(),NoLoginFragment.newInstance(),NoLoginFragment.newInstance()
    )
) : BaseViewPagerFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_notification,container,false))
    }

    companion object{
        fun newInstance() = NotificationFragment()
    }
}