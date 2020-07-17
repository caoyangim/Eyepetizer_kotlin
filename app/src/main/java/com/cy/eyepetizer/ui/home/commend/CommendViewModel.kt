package com.cy.eyepetizer.ui.home.commend

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cy.eyepetizer.logic.model.HomePageRecommend
import com.cy.eyepetizer.logic.model.Item
import com.cy.eyepetizer.logic.network.EyepetizerNetwork
import com.cy.eyepetizer.logic.network.api.MainPageService
import kotlinx.coroutines.launch

class CommendViewModel :ViewModel(){

    var dataList = ArrayList<Item>()

    var homePageRecommend:MutableLiveData<HomePageRecommend> = MutableLiveData()

    fun refreshCommend(){
        viewModelScope.launch {
            val recommend = EyepetizerNetwork.getInstance().fetchHomePageRecommend(MainPageService.HOMEPAGE_RECOMMEND_URL)
            homePageRecommend.value = recommend
        }
    }

}