![alt text](/images/library_banner.png)

# SSComposeShowCaseView

[![Compose Version](https://img.shields.io/badge/Jetpack%20Compose-1.2.0--beta03-brightgreen)](https://developer.android.com/jetpack/compose)
[![Kotlin Version](https://img.shields.io/badge/Kotlin-v1.6.21-blue.svg)](https://kotlinlang.org)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg?style=flat)](https://www.android.com/)

## Introduction

SSComposeShowCaseView is a customizable show case view library which allows to showcase/highlight
the particular features of the application with an engaging overlay. It also provides automatic
showcase view feature with customised delay and opacity attributes.

## Features

* Simple rounded showcase view
* Simple rectangle showcase view
* Animated rounded showcase view
* Animated rectangle showcase view
* Automatic showcase view
* Customise delay between showcase, background opacity

# 🎬 Preview

| Simple Rounded  | Animated Rounded |
|--|--|
| <img src="/images/Simple_Rounded_Showcase_View.gif" height="500px"/> | <img src="/images/Animated_Rounded_Showcase_View.gif" height="500px"/> |

| Simple Rectangle | Animated Rectangle |
|--|--|
| <img src="/images/Simple_Rectangle_Showcase_View.gif" height="500px"/> | <img src="/images/Animated_Rectangle_Showcase_View.gif" height="500px"/> |

### Gradle Dependency

* Add it in your root build.gradle at the end of repositories:

    - For Gradle version 5.x.x or less
      ```
      allprojects {
          repositories {
          ...
          maven { url 'https://jitpack.io' }
          }
      }
      ```
    - For Gradle version 6.x.x and above, in settings.gradle file inside `pluginManagement` block
      ```
        pluginManagement {
          repositories {
          ...
          maven { url 'https://jitpack.io' }
          }
      }
      ```

* Add the dependency in your app's build.gradle file

  ```
  dependencies {
      implementation 'com.github.simformsolutions:SSComposeShowCaseView:1.0'
  }
  ```
  
## 🤔 How to use it

* Composable function which is used to start showcase view
  ```kotlin
     fun ShowCaseTarget(
       targets: SnapshotStateMap<String, ShowcaseProperty>,
       isEnableAutoShowCase: Boolean = false,
       showcaseDelay: Long = 2000,
       key: String,
       onShowCaseCompleted: () -> Unit
     )
  ```

* Customise your showcase view using this data class
  ```kotlin
     data class ShowcaseProperty(
       val index: Int,
       val coordinates: LayoutCoordinates,
       val title: String,
       val titleColor: Color = Color.White,
       val subTitle: String,
       val subTitleColor: Color = Color.White,
       val showCaseType: ShowcaseType = ShowcaseType.SIMPLE_ROUNDED,
       val blurOpacity: Float = 0.8f
     )
  ```

* To start showcase view call composable function `ShowCaseTarget` like below
  ```kotlin
     val targets = remember { mutableStateMapOf<String, ShowcaseProperty>() }
     ShowCaseTarget(targets = targets, isEnableAutoShowCase = true, key = "Dashboard") {
        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(context, "Thank you! Intro Completed", Toast.LENGTH_SHORT).show()
        }
     }
  ```

* On which ever component you need to showcase, take coordinates of that component using
  Modifier.onGloballyPositioned and use ShowcaseProperty like shown below
  ```kotlin
       Image(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More icon",
            modifier = Modifier
                .padding(10.dp)
                .onGloballyPositioned {
                    target["more"] = ShowcaseProperty(
                        index = 1,
                        coordinates = it,
                        title = "More options",
                        subTitle = "Click here to see options",
                        showCaseType = ShowcaseType.ANIMATED_RECTANGLE
                    )
                }
        )
  ```

### All Attributes
------------------------

| Attribute | Description | Default |
| --- | --- | --- |
| `index` | Set index to show showcase one by one | None |
| `coordinates` | Componants coordinates for showcase | None |
| `title` | Showcase title | None |
| `titleColor` | Color for title | `White` |
| `subTitle` | Showcase subtitle | None |
| `subTitleColor` | Color for subtitle | `White` |
| `showCaseType` | Pass type of showcase (SIMPLE_ROUNDED,SIMPLE_RECTANGLE, ANIMATED_ROUNDED, ANIMATED_RECTANGLE) | `SIMPLE_ROUNDED` |
| `blurOpacity` | Pass opacity to blur background | `0.08f` |
| `isEnableAutoShowCase` | To manage showcase automatically | `false` |
| `showcaseDelay` | Delay in-between showcase for automatic showcase view | `2000` |
| `key` | To manage if showcase already shown or not | None |

## Inspired by

- [canopas/Intro-showcase-view](https://github.com/canopas/Intro-showcase-view)

## Our Libraries in JetPackCompose

- [SSJetPackComposeProgressButton](https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton) :
  SSJetPackComposeProgressButton is an elegant button with a different loading animations which
  makes your app attractive.
- [SSJetpackComposeSwipeableView](https://github.com/SimformSolutionsPvtLtd/SSJetpackComposeSwipeableView) :
  SSJetpackComposeSwipeableView is a small library which provides support for the swipeable views.
  You can use this in your lazyColumns or can add a simple view which contains swipe to edit/delete
  functionality.
- [SSComposeOTPPinView](https://github.com/SimformSolutionsPvtLtd/SSComposeOTPPinView) : A custom
  OTP view to enter a code usually used in authentication. It includes different types of OTPViews
  which is easy to use and configure your own view and character of OTP using all the attributes.

## Official Documentations

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Jetpack Compose Pathways](https://developer.android.com/courses/pathways/compose)
- [Jetpack Compose Samples](https://github.com/android/compose-samples)

## Find this library useful? ❤️

Support it by
joining __[stargazers](https://github.com/SimformSolutionsPvtLtd/SSComposeShowCaseView/stargazers)__
for this repository.⭐

## How to Contribute🤝

Whether you're helping us fix bugs, improve the docs, or a feature request, we'd love to have you!
💪 Check out
our __[Contributing Guide](https://github.com/SimformSolutionsPvtLtd/SSComposeShowCaseView/blob/develop/CONTRIBUTING.md)__
for ideas on contributing.

## 🐛 Bugs and Feedback

For bugs, feature requests, and discussion please
use [GitHub Issues](https://github.com/SimformSolutionsPvtLtd/SSComposeShowCaseView/issues).

## Our Flutter Showcase View Library

- Check out our Flutter
  library [Flutter ShowCaseView](https://github.com/SimformSolutionsPvtLtd/flutter_showcaseview)

## Awesome Mobile Libraries

- Check out our other
  available [awesome mobile libraries](https://github.com/SimformSolutionsPvtLtd/Awesome-Mobile-Libraries)

## License

```
MIT License

Copyright (c) 2022 Simform Solutions

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```