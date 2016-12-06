## TeamCity Swift plugin
This plugin provides Swift support for TeamCity - including:
 - Swift Build
 - SwiftEnv

Plugin is implemented with [JetBrains Kotlin](http://kotlin.jetbrains.org/)

## Features
- Build Runners
 - `Swift Build` builds a Swift project

## License
Apache 2.0

## Supported Versions
Plugin is tested to work with TeamCity 10. It should work with 9.x (and maybe below) - but your milage may vary.

## Building
The following dependencies are needed:
- TeamCity Installation
- TomCat

Once those are sorted - you can then:
- Define the `$TeamCityDistribution$` IntelliJ IDEA Path Variable - set to the path to your TeamCity installation
- Ensure the `Tomcat` path is defined in IntelliJ IDEA settings
- Build & Run
- Navigate to `http://localhost:8111/bs` in a browser

## Installation
* Obtain a copy of the package by either:
  - Downloading a [pre-built package from GitHub](https://github.com/tombuildsstuff/TeamCity.Swift/releases)
  - Building the package via the instructions above
* Put the built plugin `.zip` file into `<TeamCity Data Directory>/plugins` folder
* Restart the TeamCity Server
* Open ```Administration | Plugins``` and check you see the plugin listed

For more details, there is [documentation](https://confluence.jetbrains.net/display/TCD10/Installing+Additional+Plugins)

## Note
This plugin is heavily based on Eugene Petrenko's [TeamCity.Node](https://github.com/jonnyzzz/TeamCity.Node) plugin. Check it out, it's awesome.
