package com.cy.applibrary.commonui.ui.banner

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.cy.applibrary.R
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.utils.BannerUtils
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle

object BannerCreator {

    fun setDefault(
        context: Context,
        banner: BannerViewPager<*, *>,
        clickListener: BannerViewPager.OnPageClickListener
    ) {
        banner as BannerViewPager<String, ImageHolder>
        banner.apply {
            setAutoPlay(true)
            adapter = ImageAdapter()
            setIndicatorStyle(IndicatorStyle.ROUND_RECT)
            setIndicatorSliderGap(4)
            setIndicatorMargin(0, 0, 0, 0)
            setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
            setIndicatorSliderRadius(3, 5)
            setIndicatorSliderColor(
                ContextCompat.getColor(context, R.color.white),
                ContextCompat.getColor(context, R.color.red)
            )
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    BannerUtils.log("position:$position")
                }
            })
            setOnPageClickListener(clickListener)
        }.create()
    }
}
