/*
 * Copyright (c) 2020. vipyinzhiwei <vipyinzhiwei@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cy.applibrary.extension

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cy.applibrary.commonui.ui.ShareDialogFragment
import com.cy.applibrary.global.GlobalKeys
import com.cy.applibrary.util.GlobalUtil
import com.cy.applibrary.util.ShareUtil
import com.cy.applibrary.util.storage.MemoryStore

/**
 * 获取SharedPreferences实例。
 */
val sharedPreferences: SharedPreferences = MemoryStore.Instance.getData<Context>(GlobalKeys.APPLICATION_CONTEXT).getSharedPreferences(
    GlobalUtil.appPackage + "_preferences", Context.MODE_PRIVATE)

/**
 * 批量设置控件点击事件。
 *
 * @param v 点击的控件
 * @param block 处理点击事件回调代码块
 */
fun setOnClickListener(vararg v: View?, block: View.() -> Unit) {
    val listener = View.OnClickListener { it.block() }
    v.forEach { it?.setOnClickListener(listener) }
}


/**
 * 批量设置控件点击事件。
 *
 * @param v 点击的控件
 * @param listener 处理点击事件监听器
 */
fun setOnClickListener(vararg v: View?, listener: View.OnClickListener) {
    v.forEach { it?.setOnClickListener(listener) }
}

/**
 * 调用系统原生分享。
 *
 * @param activity 上下文
 * @param shareContent 分享内容
 * @param shareType SHARE_MORE=0，SHARE_QQ=1，SHARE_WECHAT=2，SHARE_WEIBO=3，SHARE_QQZONE=4
 */
fun share(activity: Activity, shareContent: String, shareType: Int) {
    ShareUtil.share(activity, shareContent, shareType)
}

/**
 * 弹出分享对话框。
 *
 * @param activity 上下文
 * @param shareContent 分享内容
 */
fun showDialogShare(activity: Activity, shareContent: String) {
    if (activity is AppCompatActivity) {
        ShareDialogFragment().showDialog(activity, shareContent)
    }
}


