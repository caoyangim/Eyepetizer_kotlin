package com.cy.eyepetizer.ui.community.commend

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.applibrary.commonui.ui.recycler.decoration.SpacesItemDecoration
import com.cy.eyepetizer.R
import com.cy.eyepetizer.ui.community.commend.adapter.CommendAdapter
import kotlinx.android.synthetic.main.fragment_community_commend.*

class CommendFragment :BaseFragment(){

    private val viewModel by lazy { ViewModelProvider(this).get(CommendViewModel::class.java) }
    private val adapter:CommendAdapter by lazy { CommendAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_community_commend,container,false))
    }

    companion object{
        fun newInstance() = CommendFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val manager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        manager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        recyclerView.layoutManager = manager
        recyclerView.addItemDecoration(SpacesItemDecoration(8))
        adapter.loadMoreModule.setOnLoadMoreListener {
            viewModel.fetchRecommend()
        }
        recyclerView.adapter = adapter

        observable()
    }

    private fun observable() {
        viewModel.getRecommend().observe(viewLifecycleOwner, Observer {
            loadFinished()
            if (viewModel.getPage() == 1){
                adapter.setList(it.itemList)
            }else{
                adapter.addData(it.itemList)
                adapter.loadMoreModule.loadMoreComplete()
            }


        })
    }

    override fun loadDataOnce() {
        viewModel.fetchRecommend()
    }

}