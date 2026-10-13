package com.priyabajaria.cs501.campuseventexplorer.share

import android.content.Context
import android.content.Intent
import com.priyabajaria.cs501.campuseventexplorer.R
import com.priyabajaria.cs501.campuseventexplorer.data.CampusEvent

/** "Mobile Development Meetup — Tue, Oct 20 · 6:30 PM — CAS 214" */
fun CampusEvent.toShareText(): String = "$title — $time — $location"

/**
 * Opens the system share sheet with an implicit ACTION_SEND intent.
 * No component or package is set, so Android lets the user pick any app
 * that can receive plain text.
 */
fun shareEvent(context: Context, event: CampusEvent) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, event.title)
        putExtra(Intent.EXTRA_TEXT, event.toShareText())
    }
    val chooser = Intent.createChooser(
        sendIntent,
        context.getString(R.string.share_chooser_title)
    )
    context.startActivity(chooser)
}