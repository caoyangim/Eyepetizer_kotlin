package com.cy.eyepetizer.ui.home.banner

import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.cy.applibrary.R
import com.cy.eyepetizer.logic.model.ItemX
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.utils.BannerUtils
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle

object BannerCreator {

    fun setDefault(
        banner: BannerViewPager<*, *>,
        clickListener: BannerViewPager.OnPageClickListener
    ) {
        banner as BannerViewPager<ItemX, ImageHolder>
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
