package com.cy.eyepetizer.ui.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.multidex.BuildConfig
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.applibrary.extension.showToast
import com.cy.applibrary.util.GlobalUtil
import com.cy.eyepetizer.R
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment:BaseFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_mine,container,false))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvVersionNumber.text = String.format(GlobalUtil.getString(R.string.version_show), GlobalUtil.eyepetizerVersionName)
        tvVersionNumber.setOnLongClickListener {
            String.format(GlobalUtil.getString(R.string.build_type), BuildConfig.BUILD_TYPE).showToast()
            true
        }
    }

    companion object{
        fun newInstance() = MineFragment()
    }
}