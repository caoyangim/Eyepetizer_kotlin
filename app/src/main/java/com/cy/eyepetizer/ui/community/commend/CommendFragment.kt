package com.cy.eyepetizer.ui.community.commend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.eyepetizer.R

class CommendFragment :BaseFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_community_commend,container,false))
    }

    companion object{
        fun newInstance() = CommendFragment()
    }
}