package com.cy.eyepetizer.ui.notification.push

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.eyepetizer.R
import kotlinx.android.synthetic.main.fragment_push.*

class PushFragment :BaseFragment(){

    private val viewModel by lazy { ViewModelProvider(this).get(PushViewModel::class.java) }
    private lateinit var adapter:PushAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_push,container,false))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = PushAdapter()
        adapter.loadMoreModule.setOnLoadMoreListener {
            viewModel.fetchPush()
        }
        push_rec.adapter = adapter
        observable()
    }

    private fun observable() {
        viewModel.getPushMessage().observe(viewLifecycleOwner, Observer {
            if (it==null){
                adapter.loadMoreModule.loadMoreEnd()
                return@Observer
            }
            if (viewModel.getPage() == 1){
                adapter.setList(it.messageList.toMutableList())
            }else{
                adapter.addData(it.messageList.toMutableList())
                adapter.loadMoreModule.loadMoreComplete()
            }
        })
    }

    override fun loadDataOnce() {
        viewModel.fetchPush()
    }

    companion object{
        fun newInstance():Fragment{
            return PushFragment()
        }
    }
}