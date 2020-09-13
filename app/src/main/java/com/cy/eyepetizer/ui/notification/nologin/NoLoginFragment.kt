package com.cy.eyepetizer.ui.notification.nologin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.eyepetizer.R

class NoLoginFragment :BaseFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_nologin,container,false))
    }

    companion object{
        fun newInstance() = NoLoginFragment()
    }
}