package com.priyabajaria.cs501.campuseventexplorer.ui

/** Semantic tags shared by the UI and the instrumented tests. */
object TestTags {
    const val SEARCH_FIELD = "search_field"
    const val EVENT_LIST = "event_list"
    const val DETAIL_TITLE = "detail_title"
    const val SHARE_BUTTON = "share_button"
    const val UNAVAILABLE = "event_unavailable"

    fun eventCard(id: Long) = "event_card_$id"
}