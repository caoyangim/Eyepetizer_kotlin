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
import kotlinx.android.synthetic.main.fragment_home_commend.refreshLayout
import kotlinx.android.synthetic.main.fragment_home_divcover.*

class DiscoverFragment :BaseFragment(){
    val viewModel by lazy { ViewModelProvider(this)[DiscoverViewModel::class.java] }

    private lateinit var adapter:DiscoverAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_home_divcover,container,false))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = DiscoverAdapter()
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
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
            loadFinished()
            adapter.addData(response.itemList)
        })
    }

    companion object{
        fun newInstance() = DiscoverFragment()
    }


}