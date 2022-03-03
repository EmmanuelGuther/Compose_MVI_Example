# Android Compose MVI example
#### _An implementation of how to use jetpack compose with MVI._
#
#
#
#
#
### General view:
We will need to declare in the viewmodel:

- STATE
Imagine that we have a screen that has a list of images and in the toolbar we show any other data, for example the user and the nickname,
This State data class will store these elements (it could also be a sealed class, if we had a more complicated screen)
We make two requests for data, and updateState is called on each response.
It will be heard on the screen to paint the data.

- EFFECT
It will be used to perform operations that do not intervene in the state of the screen, for example, show an error toast, change the screen, show a dialog.

- EVENT: 
The events will be used to speak from the screen to the viewmodel and act accordingly, in the sealed class the events are defined and we will be forced to implement fun handleEvent(event: Event) so, we will handle all the events.
