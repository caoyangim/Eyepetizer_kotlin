package com.cy.eyepetizer.ui.notification.push

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cy.applibrary.extension.load
import com.cy.applibrary.util.DateUtil
import com.cy.eyepetizer.R
import com.cy.eyepetizer.logic.model.PushMessage
import de.hdodenhof.circleimageview.CircleImageView

class PushAdapter :BaseQuickAdapter<PushMessage.Message,BaseViewHolder>(R.layout.item_notification_push),LoadMoreModule{
    override fun convert(holder: BaseViewHolder, item: PushMessage.Message) {
        holder.apply {
            setText(R.id.tvTitle,item.title)
            setText(R.id.tvTime,DateUtil.getConvertedDate(item.date))
            setText(R.id.tvContent,item.content)
        }
    }

}