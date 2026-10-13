package com.priyabajaria.cs501.campuseventexplorer.data

/**
 * A single campus event. [id] is unique and stable: it is the LazyColumn key
 * and the only thing that travels through navigation.
 */
data class CampusEvent(
    val id: Long,
    val title: String,
    val category: String,
    val location: String,
    val time: String,
    val description: String
)