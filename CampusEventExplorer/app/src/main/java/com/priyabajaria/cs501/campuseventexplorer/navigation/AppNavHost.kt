package com.priyabajaria.cs501.campuseventexplorer.navigation

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

/**
 * The only place that touches the NavController. Screens receive plain
 * lambdas (onEventSelected, onBack) and never see navigation APIs.
 */
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = EventList,
        modifier = modifier,
        enterTransition = { slideIntoContainer(SlideDirection.Start, tween(300)) + fadeIn(tween(300)) },
        exitTransition = { fadeOut(tween(200)) },
        popEnterTransition = { fadeIn(tween(300)) },
        popExitTransition = { slideOutOfContainer(SlideDirection.End, tween(300)) + fadeOut(tween(300)) }
    ) {
        composable<EventList> { entry ->
            EventListRoute(
                onEventSelected = { id ->
                    // Push EventDetail(id) on top of EventList. Only the ID
                    // travels; the guard ignores double taps mid-transition.
                    if (entry.isResumed()) {
                        navController.navigate(EventDetail(eventId = id))
                    }
                }
            )
        }

        composable<EventDetail> { entry ->
            val route = entry.toRoute<EventDetail>()
            EventDetailRoute(
                eventId = route.eventId,
                onBack = {
                    // Up button and "Return to events" both pop back to the list,
                    // the same result as the system Back button.
                    if (entry.isResumed()) {
                        navController.popBackStack(EventList, inclusive = false)
                    }
                }
            )
        }
    }
}

private fun NavBackStackEntry.isResumed() =
    lifecycle.currentState == Lifecycle.State.RESUMED