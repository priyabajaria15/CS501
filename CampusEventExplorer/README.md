# Campus Event Explorer

A Jetpack Compose app for browsing campus events, filtering them by title or
category, viewing details, and sharing an event through the Android share sheet.

## Screenshots

[Event list](screenshots/list.png)

[Event list (scrolled)](screenshots/list2.png)

[Event detail](screenshots/detail.png)

## Questions

**1. Why does the route contain an event ID instead of the complete event object?**
Routes are saved into the back stack's saved state, so they must be small and
serializable. An ID is stable and lightweight, and the repository stays the
single source of truth, so the detail screen always shows current data instead
of a stale copy.

**2. Which composable owns the search state?**
`EventListRoute`. It holds the query and derives the filtered list from it.
`EventListScreen` is stateless: it only receives the query and callbacks.

**3. Why does the search value use `rememberSaveable`?**
Plain `remember` is lost when the Activity is recreated on rotation.
`rememberSaveable` stores the query in the list entry's saved state, so it
survives rotation and the trip to the detail screen and back.

**4. What happens to the back stack when an event is selected?**
`navigate(EventDetail(id))` pushes a detail entry on top of `EventList`, so the
stack becomes `[EventList, EventDetail(id)]`. Back or Up pops it, and the list
returns with its saved search text.

**5. How does the UI request navigation without directly accessing the NavController?**
Screens expose lambdas such as `onEventSelected` and `onBack`. Only `AppNavHost`
holds the `NavController`, and it supplies those lambdas.

**6. What makes the Share action an implicit intent?**
It names an action (`ACTION_SEND`) and a MIME type (`text/plain`) but no target
app or component. Android finds every app that can handle it, and
`Intent.createChooser()` lets the user pick one.

## AI / collaboration disclosure
Generative AI was used for guidance with Compose code organization, UI refinement, debugging, test-case review, and README wording. I reviewed, understood, tested, and adjusted the final code used in this application.
