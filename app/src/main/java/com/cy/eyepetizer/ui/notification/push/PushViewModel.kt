package com.cy.eyepetizer.ui.notification.push

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cy.eyepetizer.logic.model.PushMessage
import com.cy.eyepetizer.logic.network.EyepetizerNetwork
import com.cy.eyepetizer.logic.network.api.MainPageService
import kotlinx.coroutines.launch

class PushViewModel :ViewModel(){
    private val pushMessage = MutableLiveData<PushMessage>()
    private var nextPageUrl:String? = MainPageService.PUSHMESSAGE_URL
    private var page = 1

    fun getPage():Int{
        return page
    }

    fun getPushMessage():MutableLiveData<PushMessage>{
        return pushMessage
    }

    fun fetchPush(){
        viewModelScope.launch {
            if (nextPageUrl == null){
                pushMessage.value = null
                return@launch
            }
            val data = EyepetizerNetwork.getInstance().fetchPush(nextPageUrl!!)
            page++
            pushMessage.value = data
            nextPageUrl = data.nextPageUrl
        }
    }
}