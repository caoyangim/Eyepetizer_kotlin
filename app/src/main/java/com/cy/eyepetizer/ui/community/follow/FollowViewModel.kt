package com.cy.eyepetizer.ui.community.follow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cy.eyepetizer.logic.model.CommunityFollow
import com.cy.eyepetizer.logic.model.Follow
import com.cy.eyepetizer.logic.network.EyepetizerNetwork
import com.cy.eyepetizer.logic.network.api.MainPageService
import kotlinx.coroutines.launch

class FollowViewModel :ViewModel(){

    private var follow:MutableLiveData<CommunityFollow> = MutableLiveData()
    var nextPageUrl:String? = MainPageService.FOLLOW_URL
    private var page = 0

    fun getPage():Int{
        return page
    }

    fun getFollow():MutableLiveData<CommunityFollow>{
        return follow
    }

    fun fetchFollow(){
        viewModelScope.launch {
            if (nextPageUrl.isNullOrEmpty()){
                //没有下一页
                follow.value = null
                return@launch
            }
            val data = EyepetizerNetwork.getInstance().fetchFollow(nextPageUrl!!)
            page++
            follow.value = data
            nextPageUrl = data.nextPageUrl
        }
    }
}