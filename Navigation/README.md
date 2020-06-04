# Navigation

This project contains a sample application using the Navigation component in Android.

## Learning

### Overview

Navigation is defined as the flow that the user may navigate across, into and back from a different place within the application. With Android Jetpack, navigation becomes easier as well as handle much complex paths such as app bars and navigation drawer. 

The navigation component consists of three key parts:
- navigation graph: an xml resources containing all navigation-related information. They contain individual content area within your app called destination, as well as possible paths for a user to take.
- `NavHost`: an empty container that displays destination from your navigation graph.
- `NavController`: an object that manages app navigation within NavHost. Orchestrates the swapping of destination content in the NavHost as users move throughout your app.


### Principle

Principles of Navigation:
- Fixed start destination: This should be the first and last screen that the user should see (going forward and backward)
- State represented as a Stack of destination: Top of the stack is the current screen. The component manages all of your back stack ordering for you, though you can also chose to manage the back stack yourself.
- Up and Back: when one of these are pressed, the current destination is popped off the top of the back stack and you navigate to the previous destination. 
- Up never exits your app
- Deep linking simulates manual navigation: Whether deep linking or manually navigating to a specific destination, you can use the Up button to navigate through destination back to the start destination. 

Navigation Graph:
- destination: anywhere your app can navigate to
- actions: destinations are connected via actions

### Getting started

#### NavHost

The navigation host is a core part of the navigation component. It is a n empty container where destinations are swapped in and out as a user navigates through your app. Note: the navigation component is designed for apps that have one main activity with multiple fragment destinations. In an app with multiple activity destinations, each activity has its own navigation graph.

#### Anatomy of a destination

Attributes for a destination:
- type: indicates whether the destination is implemented as a fragment, activity or custom class in your source code
- label: contains the name of destination's xml layout file
- id: contains the ID of the destination which is used to refer to the destination

```xml
<fragment
        android:id="@+id/blankFragment"
        android:name="com.example.cashdog.cashdog.BlankFragment"
        android:label="fragment_blank"
        tools:layout="@layout/fragment_blank" >
        <action
            android:id="@+id/action_blankFragment_to_blankFragment2"
            app:destination="@id/blankFragment2" />
</fragment>
```

### Navigate

#### Using ID
Takes the resource ID of either an action or a destination. Example:
```Kotlin
viewTransactionsButton.setOnClickListener { view ->
   view.findNavController().navigate(R.id.viewTransactionsAction)
}
```

### Navigation and Back stack

- up: calls NavController.navigateUp()
- back: calls NavController.popBackStack()

The popBackStack returns a boolean indicating whether it succesfully popped back to another destination. The most common case when this returns false is when you manually pop the start destination of your graph.

```Kotlin
if (!navController.popBackStack()) {
    // Call finish() on your Activity
    finish()
}
```


### popUpTo and popUpToInclusive
- To pop destination when navigating from one destination to another, add an `app:popUpTo` attribute to the associated action. The popUpTo tells the Navigation library to pop some destinations off the back stack as part of the call to navigate. The attribute value is the ID of the most recent destination that should remain on the stack.

- You can also include `app:popUpToInclusive="true"` to indicate that the destination specified in `app:popUpTo` should also be removed from the back stack.

### Reference
