package com.cy.eyepetizer.ui.community.follow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.applibrary.commonui.view.NoStatusFooter
import com.cy.eyepetizer.R
import com.scwang.smart.refresh.layout.constant.SpinnerStyle
import kotlinx.android.synthetic.main.fragment_community_follow.*

class FollowFragment :BaseFragment(){

    private val viewModel by lazy { ViewModelProvider(this).get(FollowViewModel::class.java) }
    private lateinit var adapter:FollowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_community_follow,container,false))
    }

    companion object{
        fun newInstance() = FollowFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = FollowAdapter(this.context!!)
        follow_Rc.layoutManager = LinearLayoutManager(this.context!!, RecyclerView.VERTICAL,false)
        follow_Rc.adapter = adapter
        refresh.setOnLoadMoreListener {
            viewModel.fetchFollow()
        }
        observable()
    }

    override fun loadDataOnce() {
        viewModel.fetchFollow()
    }

    private fun observable() {
        viewModel.getFollow().observe(viewLifecycleOwner, Observer {
            if (it == null){
                refresh.finishLoadMoreWithNoMoreData()
                return@Observer
            }
            if (viewModel.getPage() == 1){
                adapter.submitList(it.itemList)
            }else if (viewModel.getPage()>1){
                refresh.finishLoadMore()
                adapter.addItem(it.itemList)
            }

        })
    }

}