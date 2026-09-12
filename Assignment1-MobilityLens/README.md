# Mobility Lens

Mobility Lens is a single screen Android application that I created using Kotlin and Jetpack Compose. It helps developers think about the differences between designing an application for a mobile device and designing one for a stationary device.

## What the Application Does

The application explains six dimensions of mobile design:

1. Input and Interaction

2. Screen Size, Orientation, and Density

3. Lifecycle and Resource Constraints

4. Context Awareness

5. Usage Patterns

6. Security and Privacy Expectations

The application displays one dimension at a time. Each dimension includes its name, a short explanation of the mobile constraint, and a practical recommendation for a developer.

The Previous and Next buttons allow the user to move through all six dimensions.

The application also includes an outlined text field where the user can enter the name of an application or feature they are designing. When the user selects Apply this lens, the application checks the input.

If the field is blank, an error message is displayed. If the input is valid, the application displays a message that combines the entered application name with the currently selected dimension.

## Project Structure

`MainActivity.kt` starts the application, applies the custom Material theme, and displays the main Compose screen.

The `model` folder contains the data structure used to represent one mobility dimension.

The `data` folder contains the information for all six mobility dimensions.

The `ui/components` folder contains reusable interface elements such as the application header, dimension card, navigation buttons, input section, and feedback card.

The `ui/screens` folder contains the main Mobility Lens screen. Compose state is used here to manage the selected dimension, entered text, validation state, and feedback message.

The `ui/theme` folder contains the custom beige and cream color palette and typography used throughout the application.

The visible application text is stored in `strings.xml`. The application does not use XML layouts, legacy Android Views, or Fragments.

## Package Name

The application uses the following package name:

```text
com.priyabajaria.cs501.mobilitylens
```

## Running the Application

Open the project in Android Studio and wait for Gradle synchronization to finish.

Select an Android emulator and run the `app` configuration. The application was tested using a Pixel 7 emulator.

The project can also be compiled by selecting Assemble Project from the Build menu.

## Testing the Application

After launching the application, confirm that the first dimension is displayed and the Previous button is disabled.

Use Next to move through all six dimensions. On the final dimension, confirm that the Next button is disabled.

Select Apply this lens while the text field is empty to test the validation response.

Enter an application name such as `Campus Dining App` and select Apply this lens again. The successful response should contain both the entered application name and the currently selected dimension.

For the rotation test, navigate away from the first dimension, enter text, and rotate the emulator. The result of this observation is discussed in the accompanying PDF report.

