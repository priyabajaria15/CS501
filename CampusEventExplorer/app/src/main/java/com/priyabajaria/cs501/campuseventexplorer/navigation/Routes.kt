package com.priyabajaria.cs501.campuseventexplorer.navigation

import kotlinx.serialization.Serializable

/** Start destination: the searchable event list. */
@Serializable
data object EventList

/** Detail destination. Carries only the event's identity, never the event itself. */
@Serializable
data class EventDetail(
    val eventId: Long
)