package com.cy.eyepetizer.ui.home.commend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.eyepetizer.R
import com.cy.eyepetizer.ui.home.commend.adapter.CommendAdapter
import com.scwang.smart.refresh.layout.constant.RefreshState
import kotlinx.android.synthetic.main.fragment_home_commend.*

class CommendFragment :BaseFragment(){

    private val viewModel by lazy { ViewModelProvider(this)[CommendViewModel::class.java] }
    private lateinit var adapter: CommendAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_home_commend,container,false))
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = CommendAdapter(this, viewModel.dataList)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        refreshLayout.setOnRefreshListener { viewModel.refreshCommend() }
//        refreshLayout.setOnLoadMoreListener { viewModel.onLoadMore() }
        observal()
    }

    override fun loadDataOnce() {
        super.loadDataOnce()
        viewModel.refreshCommend()
        startLoading()
    }

    private fun observal() {
        viewModel.homePageRecommend.observe(viewLifecycleOwner, Observer { response ->

            loadFinished()

            if (response.itemList.isNullOrEmpty() && viewModel.dataList.isEmpty()) {
                refreshLayout.closeHeaderOrFooter()
                return@Observer
            }
            if (response.itemList.isNullOrEmpty() && viewModel.dataList.isNotEmpty()) {
                refreshLayout.finishLoadMoreWithNoMoreData()
                return@Observer
            }
            when (refreshLayout.state) {
                RefreshState.None, RefreshState.Refreshing -> {
                    viewModel.dataList.clear()
                    viewModel.dataList.addAll(response.itemList)
                    adapter.notifyDataSetChanged()
                }
                RefreshState.Loading -> {
                    val itemCount = viewModel.dataList.size
                    viewModel.dataList.addAll(response.itemList)
                    adapter.notifyItemRangeInserted(itemCount, response.itemList.size)
                }
                else -> {
                }
            }
            if (response.nextPageUrl.isNullOrEmpty()) {
                    refreshLayout.finishLoadMoreWithNoMoreData()
            } else {
                refreshLayout.closeHeaderOrFooter()
                refreshLayout.finishRefresh()
            }
        })
    }

    companion object{
        fun newInstance() = CommendFragment()
    }
}