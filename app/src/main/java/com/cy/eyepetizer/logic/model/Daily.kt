package com.cy.eyepetizer.logic.model

data class Daily(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: String,
    val total: Int
)