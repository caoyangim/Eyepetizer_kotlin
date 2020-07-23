package com.cy.eyepetizer.ui.home.daily

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cy.eyepetizer.logic.model.Daily
import com.cy.eyepetizer.logic.model.Item
import com.cy.eyepetizer.logic.network.EyepetizerNetwork
import com.cy.eyepetizer.logic.network.api.MainPageService
import kotlinx.coroutines.launch

class DailyViewModel:ViewModel(){
    var dataList = ArrayList<Item>()

    var dailyData = MutableLiveData<Daily>()

    fun refreshDaily(){
        viewModelScope.launch {
            val daily = EyepetizerNetwork.getInstance().fetchDaily(MainPageService.DAILY_URL)
            dailyData.value = daily
        }
    }
}