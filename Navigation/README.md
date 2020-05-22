# Navigation

This project contains a sample application using the Navigation component in Android.

### Learning

The navigation component consists of three key parts:
- navigation graph: an xml resources containing all navigation-related information. They contain individual content area within your app called destination, as well as possible paths for a user to take.
- `NavHost`: an empty container that displays destination from your navigation graph.
- `NavController`: an object that manages app navigation within NavHost. Orchestrates the swapping of destination content in the NavHost as users move throughout your app.

Principles of Navigation:
- Fixed start destination
- State represented as a Stack of destination: Top of the stack is the current screen. The component manages all of your back stack ordering for you, though you can also chose to manage the back stack yourself.

Navigation Graph:
- destination: anywhere your app can navigate to
- actions: destinations are connected via actions

### Reference
