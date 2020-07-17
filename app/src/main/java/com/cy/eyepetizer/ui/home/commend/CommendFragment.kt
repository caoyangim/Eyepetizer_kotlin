package com.cy.eyepetizer.ui.home.commend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.applibrary.extension.logI
import com.cy.eyepetizer.R
import com.cy.eyepetizer.ui.home.commend.adapter.CommendAdapter
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
//        refreshLayout.setOnRefreshListener { viewModel.onRefresh() }
//        refreshLayout.setOnLoadMoreListener { viewModel.onLoadMore() }
        observal()
    }

    override fun loadDataOnce() {
        super.loadDataOnce()
        startLoading()
    }

    override fun startLoading() {
        super.startLoading()
        viewModel.refreshCommend()
    }

    private fun observal() {
        viewModel.homePageRecommend.observe(viewLifecycleOwner, Observer { response ->
            loadFinished()
            logI(">>>",response.itemList.toString())
        })
    }

    companion object{
        fun newInstance() = CommendFragment()
    }
}