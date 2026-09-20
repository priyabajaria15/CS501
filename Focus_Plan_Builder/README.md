# Focus Plan Builder

**Name:** Priya Dilip Bajaria  
**BUID:** U08184333  
**Assignment:** Focus Plan Builder  
**Package:** `com.priyabajaria.cs501.focus_plan_builder`

## Description

Focus Plan Builder is a single-screen Android application that helps students create a focused study plan. The user enters a study subject and the number of available minutes. After validating the input, the application displays the session duration, duration category, recommended break, and a complete summary message.

The application is built using Kotlin, Jetpack Compose, and Material 3.

## Features

- Accepts a study subject and duration
- Validates blank, nonnumeric, and out-of-range input
- Accepts durations from 10 through 180 minutes
- Uses `toIntOrNull()` for safe number conversion
- Automatically enables or disables the Create plan button
- Categorizes the session as Quick review, Focused session, or Extended session
- Recommends a 5, 10, or 15-minute break
- Removes the old result when either input changes
- Preserves both input values after device rotation

## How to Run

1. Clone or download this repository.
2. Open the `Focus_Plan_Builder` folder in Android Studio.
3. Allow Gradle to finish syncing.
4. Start an Android emulator or connect an Android device.
5. Select the `app` run configuration.
6. Click **Run**.

## Screenshots

[Focus Plan Builder application](screenshots/focus_plan_builder.png)

[Completed focus plan](screenshots/FocusPlanBuilder.png)

[Duration out-of-range validation](screenshots/duration_out_of_range_validation.png)

## State and Recomposition

`FocusPlanRoute` owns the application state, including the subject, duration text, and generated plan. It validates the inputs, handles user events, creates a `FocusPlan`, and passes values and callbacks to `FocusPlanScreen`. The screen composable focuses only on displaying the interface.

The text-field values are stored as `String` because text fields receive text while the user is typing. The input may temporarily be empty, incomplete, or nonnumeric, so storing it directly as an `Int` would not work correctly. `toIntOrNull()` safely returns `null` when the duration cannot be converted, while `toInt()` could throw an exception and crash the application.

The Create plan button state is derived from the current subject and duration values. Whenever either value changes, Compose observes the state update, recomposes the affected UI, and recalculates whether the button should be enabled.

`rememberSaveable` preserves the subject and duration text when the Activity is recreated, such as during device rotation. A regular local variable would reset during recomposition or Activity recreation. Changing either input also sets the generated plan to `null`, which removes the previous result card.

## Generative AI Assistance

Generative AI was used for guidance with Compose code organization, UI refinement, debugging, test-case review, and README wording. I reviewed, understood, tested, and adjusted the final code used in this application.