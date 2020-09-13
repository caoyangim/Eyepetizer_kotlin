package com.cy.eyepetizer.ui.community.commend

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cy.eyepetizer.logic.model.Commend
import com.cy.eyepetizer.logic.model.CommunityRecommend
import com.cy.eyepetizer.logic.network.EyepetizerNetwork
import com.cy.eyepetizer.logic.network.api.MainPageService
import kotlinx.coroutines.launch

class CommendViewModel :ViewModel(){
    private val recommend = MutableLiveData<CommunityRecommend>()
    private var nextPageUrl:String = MainPageService.COMMUNITY_RECOMMEND_URL

    fun getRecommend():MutableLiveData<CommunityRecommend>{
        return recommend
    }

    fun getPage():Int{
        return nextPageUrl.last().toInt() -1
    }

    fun fetchRecommend(){
        viewModelScope.launch {
            val data = EyepetizerNetwork.getInstance().fetchCommunityCommend(nextPageUrl)
            recommend.value = data
            nextPageUrl = data.nextPageUrl
        }
    }
}