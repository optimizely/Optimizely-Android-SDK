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
