package com.cy.eyepetizer.logic.model

data class PushMessage(
    val messageList: List<Message>,
    val nextPageUrl: String?,
    val updateTime: Long
) {
    data class Message(
        val actionUrl: String,
        val content: String,
        val date: Long,
        val icon: String,
        val id: Int,
        val ifPush: Boolean,
        val pushStatus: Int,
        val title: String,
        val uid: Any,
        val viewed: Boolean
    )
}