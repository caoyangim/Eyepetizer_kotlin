package com.cy.eyepetizer.ui.home.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.eyepetizer.R
import com.cy.eyepetizer.ui.home.recycle.HomeAdapter
import com.scwang.smart.refresh.layout.constant.RefreshState
import kotlinx.android.synthetic.main.fragment_home_commend.*
import kotlinx.android.synthetic.main.fragment_home_daily.*
import kotlinx.android.synthetic.main.fragment_home_daily.recyclerView
import kotlinx.android.synthetic.main.fragment_home_daily.refreshLayout

class DailyFragment :BaseFragment(){

    private val viewModel by lazy { ViewModelProvider(this)[DailyViewModel::class.java] }
    private val homeAdapter  by lazy { HomeAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_home_daily,container,false))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        homeAdapter.data = viewModel.dataList
        recyclerView.run {
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            this.adapter = homeAdapter
        }

        refreshLayout.setOnRefreshListener { viewModel.refreshDaily() }
//        refreshLayout.setOnLoadMoreListener { viewModel.onLoadMore() }
        observal()
    }

    override fun loadDataOnce() {
        super.loadDataOnce()
        viewModel.refreshDaily()
        startLoading()
    }

    private fun observal(){
        viewModel.dailyData.observe(viewLifecycleOwner, Observer {response ->
            loadFinished()
            when (refreshLayout.state) {
                RefreshState.None -> {
                    viewModel.dataList.clear()
                    viewModel.dataList.addAll(response.itemList)
                    homeAdapter.notifyDataSetChanged()
                }
                RefreshState.Refreshing -> {
                    refreshLayout.finishRefresh()
                    viewModel.dataList.clear()
                    viewModel.dataList.addAll(response.itemList)
                    homeAdapter.notifyDataSetChanged()
                }
                else -> {
                }
            }

        })
    }

    companion object{
        fun newInstance() = DailyFragment()
    }
}