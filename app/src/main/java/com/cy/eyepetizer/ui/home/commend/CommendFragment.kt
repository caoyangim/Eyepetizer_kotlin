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
import kotlinx.android.synthetic.main.fragment_home_commend.*

class CommendFragment :BaseFragment(){

    private val viewModel by lazy { ViewModelProvider(this)[CommendViewModel::class.java] }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_home_commend,container,false))
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
//        recyclerView.adapter = adapter
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

        })
    }

    companion object{
        fun newInstance() = CommendFragment()
    }
}