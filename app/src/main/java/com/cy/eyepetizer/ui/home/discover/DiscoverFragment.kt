package com.cy.eyepetizer.ui.home.discover

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
import kotlinx.android.synthetic.main.fragment_home_commend.refreshLayout
import kotlinx.android.synthetic.main.fragment_home_divcover.*


class DiscoverFragment :BaseFragment(){
    val viewModel by lazy { ViewModelProvider(this)[DiscoverViewModel::class.java] }

    private lateinit var adapter: HomeAdapter
    private lateinit var footview:View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        footview = inflater.inflate(R.layout.layout_discover_footer, container, false)
        return super.onCreateView(inflater.inflate(R.layout.fragment_home_divcover,container,false))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = HomeAdapter()
        adapter.addFooterView(footview)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        adapter.data = viewModel.dataList
        refreshLayout.setOnRefreshListener { viewModel.refreshDiscover() }
//        refreshLayout.setOnLoadMoreListener { viewModel.onLoadMore() }
        observal()
    }

    override fun loadDataOnce() {
        super.loadDataOnce()
        viewModel.refreshDiscover()
    }

    private fun observal(){
        viewModel.discoverDatas.observe(viewLifecycleOwner, Observer {response ->

            when (refreshLayout.state) {
                RefreshState.None -> {
                    viewModel.dataList.clear()
                    viewModel.dataList.addAll(response.itemList)
                    adapter.notifyDataSetChanged()
                }
                RefreshState.Refreshing -> {
                    refreshLayout.finishRefresh()
                    viewModel.dataList.clear()
                    viewModel.dataList.addAll(response.itemList)
                    adapter.notifyDataSetChanged()
                }
                else -> {
                }
            }


        })
    }

    companion object{
        fun newInstance() = DiscoverFragment()
    }


}