package com.cy.eyepetizer.ui.community.follow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cy.applibrary.commonui.view.AutoPlayerVideoPlayer
import com.cy.applibrary.commonui.view.TypefaceTextView
import com.cy.applibrary.extension.load
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.CommunityFollow
import de.hdodenhof.circleimageview.CircleImageView

class FollowAdapter(val context:Context):ListAdapter<CommunityFollow.Item, FollowAdapter.FollowViewHolder>(DIFFCALLBACK) {

    companion object{
        val DIFFCALLBACK = object : DiffUtil.ItemCallback<CommunityFollow.Item>(){
            override fun areItemsTheSame(
                oldItem: CommunityFollow.Item,
                newItem: CommunityFollow.Item
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CommunityFollow.Item,
                newItem: CommunityFollow.Item
            ): Boolean {
                return oldItem.data == newItem.data
            }
        }
    }

    class FollowViewHolder(val v:View):RecyclerView.ViewHolder(v){
        fun bind(item:CommunityFollow.Item){
            v.findViewById<CircleImageView>(R.id.ivAvatar).load(item.data.header.icon)
            v.findViewById<TypefaceTextView>(R.id.tvNickname).text = item.data.header.issuerName
            v.findViewById<TypefaceTextView>(R.id.tvContent).text = item.data.content.data.description
            v.findViewById<TypefaceTextView>(R.id.tvCollectionCount).text = item.data.content.data.consumption.collectionCount.toString()
            v.findViewById<TypefaceTextView>(R.id.tvReplyCount).text = item.data.content.data.consumption.replyCount.toString()
            val video = v.findViewById<AutoPlayerVideoPlayer>(R.id.videoPlayer)
            video.setUp(item.data.content.data.playUrl,false,item.data.content.data.title)
            video.loadCoverImage(item.data.content.data.cover.feed,R.drawable.video_error_normal)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_community_auto_play_follow_card_follow_card_type,parent,false)
        return FollowViewHolder(view)
    }

    override fun onBindViewHolder(holder: FollowViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun addItem(item:List<CommunityFollow.Item>){
        val list = currentList.toMutableList()
        list.addAll(item)
        submitList(list)
    }

}