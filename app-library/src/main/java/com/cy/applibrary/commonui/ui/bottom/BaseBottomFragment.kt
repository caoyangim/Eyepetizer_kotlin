package com.cy.applibrary.commonui.ui.bottom

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.FragmentTransaction
import com.cy.applibrary.R
import com.cy.applibrary.commonui.ui.BaseFragment
import com.cy.applibrary.extension.dp2px


abstract class BaseBottomFragment:BaseFragment(),View.OnClickListener {
    private val mTabBean = ArrayList<BottomTabBean>()
    private val mBaseFragment = ArrayList<BaseFragment?>()
    private val mItems = LinkedHashMap<BottomTabBean,BaseFragment?>()

    private var mCurrentFragment = 0
    private var mIndexFragment = 0

    private var mClickColor = Color.RED

    private lateinit var mBottomBar:LinearLayoutCompat

    abstract fun setItems(builder: ItemBuilder):LinkedHashMap<BottomTabBean,BaseFragment?>

    abstract fun setIndexFragment():Int

    @ColorInt
    abstract fun setClickedColor():Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mIndexFragment = setIndexFragment()
        if (setClickedColor()!=0) mClickColor = setClickedColor()
        val builder = ItemBuilder.builder()
        val items = setItems(builder)
        mItems.putAll(items)
        for ((k,v) in mItems){
            mTabBean.add(k)
            mBaseFragment.add(v)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_bottom,container,false))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBottomBar = rootView?.findViewById(R.id.bottom_bar)!!
        val size = mTabBean.size
        for (i in 0 until size){
            LayoutInflater.from(this.context).inflate(R.layout.bottom_item,mBottomBar)
            val item = mBottomBar.getChildAt(i) as LinearLayout
            val icon = item.getChildAt(0) as ImageView
            val text = item.getChildAt(1) as TextView
            item.apply {
                if (mTabBean[i].clickListener!=null){
                    setOnClickListener(mTabBean[i].clickListener)
                }else{
                    tag = i
                    setOnClickListener(this@BaseBottomFragment)
                }
            }
            icon.setImageResource(mTabBean[i].icon)
            if (mTabBean[i].title.isNullOrEmpty()){
                text.visibility = View.GONE
                val param = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp2px(50f))
                icon.layoutParams = param
            }else{
                text.text = mTabBean[i].title
            }

            if (i == mIndexFragment){
//                icon.setBackgroundColor(mClickColor)
                icon.isSelected = true
                text.setTextColor(mClickColor)
            }
        }
        parentFragmentManager.beginTransaction().apply {
            mBaseFragment[mIndexFragment]?.let { add(R.id.bottom_bar_fragment_container, it) }
            commit()
        }

    }

    override fun onClick(v: View) {
        val tabIndex = v.tag as Int
        changeColor(tabIndex)
        if (mBaseFragment[tabIndex] == null){

        }else{
            switchFragment(tabIndex)
        }

    }

    private fun resetColor(){
        val size = mTabBean.size
        for (i in 0 until size){
            val item = mBottomBar.getChildAt(i) as LinearLayout
            val icon = item.getChildAt(0) as ImageView
            val text = item.getChildAt(1) as TextView
            icon.setBackgroundColor(Color.TRANSPARENT)
            icon.isSelected = false
            text.setTextColor(Color.GRAY)
        }
    }

    private fun changeColor(tabIndex:Int){
        resetColor()
        val item = mBottomBar.getChildAt(tabIndex) as LinearLayout
        val icon = item.getChildAt(0) as ImageView
        val text = item.getChildAt(1) as TextView
//        icon.setBackgroundColor(mClickColor)
        icon.isSelected = true
        text.setTextColor(mClickColor)
    }

    //正确的做法
    private fun switchFragment(tabIndex:Int) {
        val targetFragment = mBaseFragment[tabIndex]
        val currentFragment = mBaseFragment[mCurrentFragment]
        val transaction: FragmentTransaction = parentFragmentManager
            .beginTransaction()
        if (targetFragment==null) return
        if (!targetFragment.isAdded) {
            transaction
                .hide(currentFragment!!)
                .add(R.id.bottom_bar_fragment_container, targetFragment)
                .commit()
            println("还没添加呢")
        } else {
            transaction
                .hide(currentFragment!!)
                .show(targetFragment)
                .commit()
            println("添加了( ⊙o⊙ )哇")
        }
        mCurrentFragment = tabIndex
    }

}