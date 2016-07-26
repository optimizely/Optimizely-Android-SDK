# Optimizely Android SDK Changelog

### 1.6.1, 1.5.1
July 22, 2016

*Bug Fixes*
* Fixes bug that caused user ID to be reset on every cold start of app under some circumstances.  Users manually setting a PPID were not affected.  This only affects unique vistor counts in your results.  Winning and losing variations are still valid.

### 1.6.0
July 12, 2016

*New Features:*

*  *Optimizely Service:* Optimizely SDK now has an internal Android Service that is used for I/O such as saving and sending events. This will ensure that events created by users when there is no internet connectivity will get sent to us eventually even if the the user never opens the app again. Currently, the service will flush events once per day. In the future this may be configurable.

*Bug Fixes*

*  *Optimizely Attributes:* We added additional logging to help you properly use Optimizely Attribute APIs before starting Optimizely.
*  *Portrait Lock:* We have removed portrait lock with users building for Android TV. 

### 1.5.0
May 24, 2016

*Improved Preview:*

We have added an exciting feature to allow developers/testers to set different variations from the app itself.
You can also see the events that will be sent to the Optimizely backend. Changing variations while in preview mode is now instantaneous. 

*Optimizely Attributes:* 

You can now create Optimizely Attributes for Android in the project dashboard. These attributes can be used to 
segment results on the results page and for audience targeting. There are new APIs to get and set the value for attributes.

* You can set an attribute’s value by using either `Optimizely.setValueForAttributeId(String, String, Context)` or `Optimizely.setValueForAttributeApiName(String, String, Context)` before starting Optimizely. Use `Optimizely.setValueForAttributeId(String, String)` or `Optimizely.setValueForAttributeApiName(String, String)` after starting Optimizely.
* You can get an attribute’s current value by using either `Optimizely.getAttributeValueForAttributeId(String, Context)` or `Optimizely.getAttrtibuteValueForAttributeApiName(String, Context)` before starting Optimizely. Use `Optimizely.getAttributeValueForAttributeId(String)` or `Optimizely.getAttrtibuteValueForAttributeApiName(String, String)` after starting Optimizely.
* You can get a copy of all attributes by calling `Optimizely.getAttributes()`. This replaces the previous `Optimizely.getDimensions()` call.
    
* *New Classes:*
  
* `OptimizelyAttribute.java` - Represents an Optimizely Attribute.
    
* *registerPlugin* is not deprecated anymore. Due to a compiler change in Android Studio 2.0 we cannot find arbitrary classes that implement OptimizelyPlugin in an app’s Dex file at runtime.  Plugins in development will need to use Optimizely#registerPlugin(OptimizelyPlugin) to add the plugin to the Optimizely Plugin Manager.

*Bug Fixes:*

* Session per visitor per week are not calculated correctly.
* Integrations such as Localytics and Mixpanel will continue to work with Android Studio 2.0 and the new Jack compiler.

*Breaking Changes*

* We are enabling registerPlugin Api so that you can register plugins directly
* In Android 2.0, in edit mode, Live Variables and Code Blocks are only registered when you navigate to the view that uses them. In the previous versions, Live Variables and Code Blocks were registered on app start
  * If this is inconvenient, Optimizely.registerClassWithOptlyFields(Class…) can be used to register classes with Live Variables and Code Blocks at any point during the app’s execution.
      
*Deprecated Methods*

* `Optimizely.getDimensions()` is now deprecated.  Please use `Optimizely.getAttributes()` instead.
* `OptimizelyDimension.java` is now deprecated.  Please use the `OptimizelyAttribute.java` class instead.
    
*Developer documentation*

In order to enable preview, you can add `Optimizely.enablePreview()` in your code similar to `Optimizely.enableEditor()`. You can only use one of these API calls at a time.

### 1.4.2
March 8, 2016

*Bug Fixes:*

*  Adjusts bundled Proguard rules so that they only keep the minimum required by Optimizely and work with our new modules.
*  Fixes issue where SDK would not start up while starting asynchronously due to thread pool starvation.

### 1.4.1
February 29, 2016

*Bug Fixes:*

* Gives visibility back to public API method `Optimizely.trackViewGoal(String)` which is used to track view goals when using Fragments.

### 1.4.0
February 25, 2016

*New Features:*

* *Developer Improvements:* We want to enable customers to use the [offline conversions](https://help.optimizely.com/hc/en-us/articles/200040195-Tracking-offline-conversion-events-with-Optimizely) API to its full potential, so we've exposed essential parameters needed to send offline conversion events.
	* `Optimizely.getDimensions()` - get an ArrayList of all OptimizelyDimensions in the SDK.
	* `Optimizely.getUniversalUserId(Context)` & `Optimizely.setUniversalUserId(Context, String)` - your custom Universal User Id for the end user. Set the universalUserId to identify the end user across devices. More info can be found [here](https://help.optimizely.com/hc/en-us/articles/203626830-Universal-User-ID-Beta)
	* `Optimizely.optimizelyEndUserId(Context)` - read only property to get the Optimizely End User Id created by the Optimizely SDK.
* *New Classes:*
	* OptimizelyDimension.Java - A representation of the data in an individual Optimizely Dimension. Read more about Dimensions [here](https://help.optimizely.com/hc/en-us/articles/200040865-Dimensions-Capture-visitor-data-through-the-API).
* *Performance Improvements:*
	* Added a way to selectively include Optimizely SDK code to reduce method counts against DEX issues.
	* Improved performance for SDK startup
	* Upgraded to OKHTTP version 3

*Bug Fixes:*

* Fixed an issue with tracking revenue goals with an empty string description.

*Deprecated Methods:*

* `Optimizely.getUserId(Context)` & `Optimizely.setUserId(Context, String)` are now deprecated. Please use either `universalUserId` or `optimizelyEndUserId` instead.

### 1.3.7
January 5, 2016

*Bug Fixes:*
* Fix Audience evaluator bug.

### 1.3.6
December 21, 2015

*Bug Fixes:*
- Fixes internal task queueing error

### 1.3.5
December 14, 2015

*Bug Fixes:*
- Fixes crash when handling GSON failure during SDK disabling.  This only selects a few specific devices

### 1.3.4
December 7, 2015

*Bug Fixes:*
- Handles GSON crash when it creating GSON adapter.  GSON crashes will cause the SDK to disable itself and not crash the host app

### 1.3.3
November 30, 2015

*Bug Fixes:*
- Fixes incompatibility with edit or preview mode on older Android devices (API 17 and below)

### 1.3.2
November 25, 2015

*Bug Fixes:*
- Optimizely will no longer completely disable itself if there are no running esperiments, which prevented users from starting the editor


### 1.3.1
November 12, 2015

*Bug Fixes:*
- Optimizely will not disable itself if it crashes on the main thread for debug builds, only for release builds
- Adjusted OkHttp dependency for increased stability


### 1.3.0
November 6, 2015

*Announcements:*
*Twitter Fabric Integration.* We're excited to announce our partnership with Fabric, Twitter's modular mobile platform that makes it easy for developers to install and maintain SDKs within their apps. Find out more [here](https://blog.optimizely.com/2015/10/21/optimizely-twitter-fabric/)

*New Features:*
- *Developer Improvements.* We've added a litany of testing methods to our SDK to help you debug your experiments much more quickly and easily
	- isUserInAudience - Check if the user is in a particular audience
	- getExperimentDataById - Get an experiment's metadata with that experiment's ID
	- resetUserBucketing - Remove a user's bucketing information for all experiments
	- forceVariationOfExperiment - Force a user into a certain experiment variation
Read more in-depth descriptions [here](/android/reference/index.html#debugging-your-experiments)
- *Manual activation.* You can now manually specify, in code, when you want your experiments to activate (by default, all active experiments are activated when start Optimizely is called). Some important use cases include setting additional targeting metadata before activating an experiment and only bucketing users who visit a certain activity in your app
Read more in-depth descriptions [here](/android/reference/index.html#experiment-activation-modes)
- *Code Block Callbacks in Edit Mode.* Please note that code block callbacks will only work in edit mode
- *Automatic Crash Disabling.* Our Android SDK is now more stable than ever!
	- Optimizely-related crashes in the main thread will cause Optimizely SDK disable itself on that device until an Optimizely SDK version change or an app version change
	- Optimizely-related crashes in background threads will cause the thread to quietly shut down
	- Optimizely SDK automatically disables itself for that session if no running experiments are detected on app start

*Bug Fixes:*
- Improved preview mode access from URL scheme consistency 
- Improved visual editor button resizing consistency 
- Fixed counting bug affecting custom events when used with UUID

### 1.2.4
October 16, 2015

*Code Deprecation*

    Optimizely.startOptimizely(String, Application)

is deprecated in favor of:

    Optimizely.startOptimizelyWithAPIToken(String, Application)

*Bug Fixes*
- Added Fabric properties to core as well as bundle

### 1.2.3
October 15, 2015

*Bug Fixes*
- Added Fabric properties

### 1.2.2
October 14, 2015

*New Features* 
- Proguard configuration for SDK is now bundled with the SDK

*Bug Fixes*
- Fixes conflict between Proguard and Gson
- Removes unecessary elements from the library's Manifest

### 1.2.1
October 6, 2015

*Bug Fixes*
- Remove backup settings from AndroidManifest.xml

### 1.2.0
October 5, 2015

*New Features*
- *Audience targeting.* Improve your app’s retention by creating audiences of similar users and targeting them with relevant content.
- *Connection-free changes.* Make changes to Live Variables and Code Blocks without connecting your device to Optimizely.
- *Streamlined goal setting.* Save time during instrumentation with a faster and more accurate goal selection experience.
- *Multi-target goals.* Accurately test entirely different variations by connecting multiple view or tap events to a single goal.
- *Advanced preview and QA modes.* Release new features confidently with a rebuilt preview mode that allows you to simulate a live user experience in real time.
- *Analytics integrations.* See your Android experiment results in your Google Analytics, Mixpanel, Localytics, or Amplitude dashboard.
