# 1.6.0 (Beta, contact us for access)
June 29, 2016

* Service Architecture:*

Optimizely SDK now has an internal Android Service that is used for I/O such as saving and sending events.  This will ensure that events created by users when there is no internet connectivity will get sent to us eventually even if the the user *never* opens the app again.  Currently, the service will flush events once per day.  In the future this may be configurable.

# 1.5.0
May 24, 2016

*Improved Preview:*

We have added an exciting feature to allow developers/testers to set different variations from the app itself.
You can also see the the events that will be sent to the Optimizely backend. Changing variations while in preview mode is now instantaneous.

*Optimizely Attributes:*

You can now create Optimizely Attributes for Android in the project dashboard. These attributes can be used to
segment results on the results page and for audience targeting. There are new APIs to get and set the value for attributes.

* You can set an attribute’s value by using either `Optimizely.setValueForAttributeId(String, String, Context)` or `Optimizely.setValueForAttributeApiName(String, String, Context)` before starting Optimizely. Use `Optimizely.setValueForAttributeId(String, String)` or `Optimizely.setValueForAttributeApiName(String, String)` after starting Optimizely.
* You can get an attribute’s current value by using either `Optimizely.getAttributeValueForAttributeId(String, Context)` or `Optimizely.getAttrtibuteValueForAttributeApiName(String, Context)` before starting Optimizely. Use `Optimizely.getAttributeValueForAttributeId(String)` or `Optimizely.getAttrtibuteValueForAttributeApiName(String, String)` after starting Optimizely.
* You can get a copy of all attributes by calling `Optimizely.getAttributes()`. This replaces the previous `Optimizely.getDimensions()` call.

* *New Classes:*

* `OptimizelyAttribute.java` - A representation of the data in an individual Optimizely Attribute.

* *registerPlugin* is not deprecated anymore. Due to a compiler change in Android Studio 2.0 we cannot find arbitrary classes that implement OptimizelyPlugin in an app’s Dex file at runtime.  Plugins in development will need to use Optimizely#registerPlugin(OptimizelyPlugin) to add the plugin to the Optimizely Plugin Manager.

*Bug Fixes:*

* Session per visitor per week are not calculated correctly.
* Integrations such as Localytics and Mixpanel will continue to work with Android Studio 2.0 and the new Jack compiler.

*Breaking Changes*

* We are enabling registerPlugin Api so that you can register plugins directly
* In Android 2.0, in edit mode, Live variables and code blocks are only registered when you navigate to the view that uses them. In the previous versions, live variables and code blocks were registered on app start
  * If this is inconvenient, Optimizely.registerClassWithOptlyFields(Class…) can be used to register classes with Live Variables and Code Blocks at any point during the app’s execution.

*Deprecated Methods*

* `Optimizely.getDimensions()` is now deprecated.  Please use `Optimizely.getAttributes()` instead.
* `OptimizelyDimension.java` is now deprecated.  Please use the `OptimizelyAttribute.java` class instead.

*Developer documentation*

In order to enable preview, you can add `Optimizely.enablePreview()` in your code similar to `Optimizely.enableEditor()`. You can only use one of them at a time.

# 1.4.2
March 8, 2016
* Fixes issue with thread pool becoming starved
* Constrains bundled Proguard rules to the bare minimum required for SDK to run
# 1.4.1
* Updates Proguard rules for new modules
# 1.4.0
* Breaks core sdk up into modules that can be selectively compiled: core, editor, view, and shared
* Faster cold start time
* Allows for 3rd party audience integrations

# 1.3.5
December 14, 2015
## Bugfixes
Fixes issue in 1.3.4 where SDK would crash attempting to disable itself due to a GSON failure on some devices.

# 1.3.4
December 7, 2015
## Bugfixes
 * Fixes crash when enabling GSON.  SDK will catch exceptions and disable itself for that device if GSON initialization fails.
## Upgrades
 * Upgrades GSON and OkHTTP to the latest versions

# 1.3.3
November 30, 2015
## Bugfixes
 * Fixes crash in preview edit mode when creating experiments on older Android devices (< API 17)

# 1.3.2
November 24, 2015
*Tweaks:*
- Optimizely will not completely disable itself if there are no running esperiments.  This was preventing users from starting the editor.

# 1.3.1
November 12, 2015
*Tweaks:*
- Optimizely will no longer disable itself if it crashes on the main thread for debug builds, only for release builds
- Rolled back to OkHttp 2.3.0 due to instability with 2.5.0

# 1.3.0
November 6, 2015

*Announcements:*
*Twitter Fabric Integration.* We're excited to announce our partnership with Fabric, Twitter's modular mobile platform that makes it easy for developers to install and maintain SDKs within their apps. Find out more [here](https://blog.optimizely.com/2015/10/21/optimizely-twitter-fabric/)

*New Features:*
- *Developer Improvements.* We've added a litany of testing methods to our SDK to help you debug your experiments much more quickly and easily
isUserInAudience - Check if the user is in a particular audience
getExperimentDataById - Get an experiment's metadata with that experiment's ID
resetUserBucketing - Remove a user's bucketing information for all experiments
forceVariationOfExperiment - Force a user into a certain experiment variation
Read more in-depth descriptions [here](/android/reference/index.html#debugging-your-experiments)
- *Manual activation.* You can now manually specify, in code, when you want your experiments to activate (by default, all active experiments are activated when start Optimizely is called). Some important use cases include setting additional targeting metadata before activating an experiment and only bucketing users who visit a certain activity in your app
Read more in-depth descriptions [here](/android/reference/index.html#experiment-activation-modes)
- *Code Block Callbacks in Edit Mode.* Please note that code block callbacks will only work in edit mode
- *Automatic Crash Disabling.* Our Android SDK is now more stable than ever!
Optimizely-related crashes in the main thread will cause Optimizely SDK disable itself on that device until an Optimizely SDK version change or an app version change
Optimizely-related crashes in background threads will cause the thread to quietly shut down
Optimizely SDK automatically disables itself for that session if no running experiments are detected on app start

*Bug Fixes:*
- Improved preview mode access from URL scheme consistency 
- Improved visual editor button resizing consistency 

#1.2.4 (Oct 16, 2015)
## Bugfixes
 * Added Fabric properties to core as well as bundle

## Breaking changes
 * `Optimizely.startOptimizely(String, Application)` is deprecated in favor of `Optimizely.startOptimizelyWithAPIToken(String, Application)`
 
#1.2.3 (Oct 15, 2015)
## Bugfixes
 * Added Fabric properties
 
#1.2.2 (Oct 14, 2015)
## New Features
 * Proguard configuration for SDK is now bundled with the SDK
 
## Bugfixes
 * Fixes conflict between Proguard and Gson
 * Removes unecessary elements from the library's Manifest

#1.2.1 (Oct 6, 2015)
## Bugfixes
 * Remove backup settings from AndroidManifest.xml

#1.2.0 (Oct 5, 2015)
## New Features
 * View/Tap goals can now be triggered by multiple views
 * Adds support for Fragment View Goals
 * Adds callbacks for code block change

## Bugfixes
 * Fix setting width/height in preview mode
 * Fixes a crash when launching into preview mode

#1.1.3 (Sep 14, 2015)
## Breaking Changes
 * New Proguard rules required

```
-dontwarn com.optimizely.integrations.**
-dontwarn com.mixpanel.android.mpmetrics.MixpanelApiRetriever*
-dontwarn com.amplitude.api.OptimizelyAmplitudeBridge

```

## New Features
 * Localytics Integration
 * Improves visual editor performance during RecyclerView Scrolling

## Bugfixes
 * Fixes a bug when loading audiences
 * You can now register plugins before the call to startOptimizely
 * Fixes enum incompatibility with Proguard

#1.1.0 - General Availability (Aug 17, 2015)
## New Features:
 * Audiences: now you can better target experiences
 * New goals dialog: better view and tap goals, detection of custom goals 
 * New Preview feature for better QA
 * New Analytics integrations:
   * Google Analytics
   * Mixpanel
   * Amplitude
 * Increased performance when adding views after activity launch
 * Short links for launching into Edit or Preview mode without the gesture
 * Default implementation of Optimizely event listener interface

## Bug Fixes:
 * Fixes issues around asset caching
 * Fixes concurrent database start issue
 * Various JSON messaging changes
 * URL changes for endpoints

## Breaking Changes:
 * Minimum supported Android SDK is now 8

# 1.0.4 - General Availability (Aug 3, 2015)
## Bugfixes
 * Fixes 2 crashes related to font handling

# 1.0.1 - General Availability (May 4, 2015)
## Bugfixes
 * Fixed an IllegalArgumentException related to tag handling

# 1.0.0 - General Availability (April 21, 2015)
## Bugfixes
 * Fixed a NPE during screenshot creation in edit mode
 * Fixed the version number displayed when downloading data files
 * Fixed an NPE when calling `Optimizely.setOptimizelyId(String, View)` before Optimizely has started
 * Fixed several synchronization issues in Edit Mode
 * Fix for several strict mode violations
 * `Optimizely.getAllExperiments()` now returns inactive experiments
 * Fix for NPE when calling `Optimizely.trackEvent(String)` before Optimizely has started
 * Fix experiment support in Preview mode
 * Fix for Edit mode socket disconnects
 * Fix for Color Live Variables in visual editor
 * Fixed landscape editing in visual editor

## Features
 * Image/Asset Swapping through the visual editor
 * Setting an Optimizely ID on a ViewGroup now allows the children to be referenced individually
 * Better debugging of conversion events
 * Better handling of duplicate touch events
 * Limited background data file downloads

## Breaking Changes
 * `CodeBlock`s have been renamed to `CodeBranch`
 * `DefaultCodeBlock` has been renamed to `DefaultCodeBranch`

# 0.3.14 - Public Beta (Mar 20, 2015)
## Bugfixes
 * Fixed bug which did not record visitors for baseline variations
 * Fixed bug which allowed code blocks which shared names to be executed incorrectly
 * Fixed a JSON decoding exception on startup
 * Fixed a NPE when activating experiments
 * Fixed an API access for < API 15
 * Fixed a refresh bug in edit mode where old edits would not be reset after reconnecting to the editor
 * Fixed NPE when sending a screenshot in edit mode
 * Fixed a code blocks bug in edit mode where the code block would not reset properly
 * Edit gesture disabled in production
 * Fixed an API access for < API 17
 * Fixed the `Optimizely.sendEvents()` API
 * Fixed stacking of touch event listeners
 * Fixed visitor counting (previously visitor counts only occured during a conversion event)

## Features
 * Added API to expose the Optimizely SDK version
 * New Listener Events for:
   * Experiment Visited
   * Goal Triggered
   * Data file loaded
 * New API to get all experiments that have been visited by the user: `Optimizely.getVisitedExperiments()`
 * New API to get all experiments, active or not: `Optimizely.getAllExperiments()`
 * New APIs to check targeting conditions, current state, and conflicts of running experiments in `OptimizelyExperimentState`
 * Upgraded to OkHTTP
   * New API to inject OkHTTP client for testing/debugging: `Optimizely.setHttpClient()`
 * New API `setOptimizelyId(String, View)` to uniquely identify views in AdapterViews or group similar Views
 * Better memory performance in edit mode
 * Better kill switch behavior
 * Allow setting visibility of elements to GONE as well as VISIBLE or INVISIBLE
 * Allow removing an image from an ImageView from the web editor


## Breaking Changes
 * The OptimizelyEventListener Interface has new methods which will need to be added
 * The OptimizelyExperimentState has changed significantly
   * OptimizelyExperimentState has been renamed to OptimizelyExperimentData
   * Contains fields for determining whether the experiment has been visited ever, is currently active, has passed targeting, etc.
 * `Optimizely.getActiveExperiments()` API is now deprecated. Use `Optimizely.getAllExperiments()` or `Optimizely.getVisitedExperiments()`

# 0.3.2 - Public Beta (Feb 20, 2015)
## Bugfixes
 * Fixed a socket reconnection bug that would try and reconnect the websocket every 1 millisecond
 * Fixed view identification on older APIs (16 and below) when experiment is created using a newer device
 * Fixed an edit mode bug on API 14 and 15

## Features
 * Added error messaging when the SDK references an archived project.
 * Greatly improved performance and memory overhead in Edit Mode
 * New Asynchronous Start API
 * Improved network and logging performance
 * Better error messaging

## Breaking Changes
 * New method: onEditorEnabled for the OptimizelyEventListener interface. This listener method is notified whenever the app is placed into edit mode.

# 0.3.1 - Public Beta (Feb 12, 2015)
## Bugfixes
 * Fixed a bug around when a visitor is counted by an experiment

## Features
 * Added error messaging when the SDK references an archived project.

# 0.3.0 - Public Beta (Feb 4, 2015)
## Bugfixes
 * Fixed a bug that prevented changes being applied to fragments
 * Preview Mode notification no longer says "edit mode"

## Features
 * Performance improvements

## Breaking Changes
 * New API name for disabling visual experiments

# 0.2.8 - Developer Preview (Feb 3, 2015)

## Bugfixes
 * Network timeout now strictly enforced
 * Startup will no longer be blocked by other AsyncTasks running in the app

## Features
 * New API for disabling event logging
 * New API for disabling visual experiments
 * Much much faster visual editing
 * Large performance improvements

# 0.2.6 - Developer Preview (Jan 26, 2015)

## Bugfixes
 * SDK is now a no-op for versions of Android < 4.0 (API level 14)
 * Setting/Getting User ID crash fixed
 * Network crash fixed

## Features
 * Better (and more stable) view targeting
 * Notification when in Edit Mode
 * Better screen shot resolution
 * Remote kill switch
 * Experiment activation on app reload
 * Manual experiment activation
 * Asset swap support

## Breaking Changes
 * New syntax for CodeBlocks

# 0.2.1 - Developer Preview (Dec 19, 2014)

## Bugfixes
 * Graceful shutdown when Optimizely cannot activate due to network conditions
 * Better error messaging in edit mode
 * Fix for NoClassDefFound Error

# 0.2.0 - Developer Preview (Dec 12, 2014)

## Features
 * Support for LiveVariables and CodeBlocks defined in code
 * Traffic Allocation
 * Variation Bucketing
 * Faster and Smaller JSON Parser!

## Known Issues
 * View events for items "below the fold" do not fire
 * Tap/View goal setup is difficult and annoying
 * No Asset/Font Support (Coming soon)

# 0.1.2 - Developer Preview (Dec 2, 2014)

## Features
 * Support for Revenue Goals
 * Support for Retention Goals
 * Support for Universal User ID
 * Support for View events

## Bugfixes
 * CodeBlocks no longer throw exceptions when a branch handler is re-registered.
 * Fixed empty Views showing up in the editor
 * Fix for HTTP Connection leak
 * AndroidManifest no longer causes build conflicts
 * Fixed parsing of Gzipped JSON
 * Fixed retrieval of text from EditText widgets

## Known Issues
 * View events for items "below the fold" do not fire
 * Tap/View goal setup is difficult and annoying
 * No Asset/Font Support (Coming soon)

# 0.1.0 - Developer Preview (Nov 20, 2014)

Initial Release, Developer Preview only

Known Issues:
 * No Asset Support
 * No Font Support
