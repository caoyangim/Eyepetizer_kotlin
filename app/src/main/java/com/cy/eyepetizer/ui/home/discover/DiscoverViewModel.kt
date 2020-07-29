package com.cy.eyepetizer.ui.home.discover

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cy.eyepetizer.logic.model.Discover
import com.cy.eyepetizer.logic.model.Item
import com.cy.eyepetizer.logic.network.EyepetizerNetwork
import com.cy.eyepetizer.logic.network.api.MainPageService
import kotlinx.coroutines.launch

class DiscoverViewModel:ViewModel() {
    var discoverDatas = MutableLiveData<Discover>()

    var dataList = ArrayList<Item>()

    fun refreshDiscover(){
        viewModelScope.launch {
            val discover = EyepetizerNetwork.getInstance().fetchDiscover(MainPageService.DISCOVERY_URL)
            discoverDatas.value = discover
        }
    }
}