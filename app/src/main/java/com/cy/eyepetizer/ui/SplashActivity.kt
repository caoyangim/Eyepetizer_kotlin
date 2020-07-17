package com.cy.eyepetizer.ui

import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.cy.applibrary.commonui.ui.BaseActivity
import com.cy.eyepetizer.R
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 闪屏界面，应用程序首入口
 */
class SplashActivity : BaseActivity() {

    private val job by lazy { Job() }

    private val splashDuration = 3 * 1000L

    private val alphaAnimation by lazy {
        AlphaAnimation(0.5f, 1.0f).apply {
            duration = splashDuration
            fillAfter = true
        }
    }

    private val scaleAnimation by lazy {
        ScaleAnimation(1f, 1.05f, 1f, 1.05f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f).apply {
            duration = splashDuration
            fillAfter = true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    override fun setupViews() {
        super.setupViews()
        ivSlogan.startAnimation(alphaAnimation)
        ivSplashPicture.startAnimation(scaleAnimation)
        CoroutineScope(job).launch {
            delay(splashDuration)
            MainActivity.start(this@SplashActivity)
            finish()
        }
    }

    override fun bindLayout(): Int {
        return R.layout.activity_splash
    }
}