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
