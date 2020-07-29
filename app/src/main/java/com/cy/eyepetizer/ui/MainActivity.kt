package com.cy.eyepetizer.ui

import android.content.Context
import android.content.Intent
import com.cy.applibrary.commonui.ui.BaseActivity
import com.cy.applibrary.extension.showToast
import com.cy.applibrary.util.GlobalUtil
import com.cy.eyepetizer.R

class MainActivity :BaseActivity(){
    private var backPressTime = 0L

    override fun bindLayout(): Int {
        return R.layout.activity_main
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
