# ultimate-logger-android
[![](https://jitpack.io/v/ArturBorowy/ultimate-logger-android.svg)](https://jitpack.io/#ArturBorowy/ultimate-logger-android)

**UltimateLogger** is a library with many useful and customizable logging options.

This is **Android** version of UltimateLogger. **JVM version**, which you can use e.g. in desktop Java or Kotlin applications, is available [here](https://github.com/ArturBorowy/ultimate-logger-jvm).

**Feel free to add your suggestions, issues and pull requests!**

## Quick start guide:

0. Add UltimateLogger dependencies to your **build.gradle**:
```groovy
dependencies {
    implementation 'com.github.ArturBorowy:ultimate-logger-android:0.1.0'
}
```

Unless you already have, add **JitPack** repository to your project level **build.gradle**:

```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

1. Init library (you probably want to do this in `onCreate()` method of yours `Application` class):

```kotlin
val shouldLog = true
val defaultTagSettings = TagSettings(
        shouldLogFileNameAndLineNum = true,
        shouldLogClassName = true,
        shouldLogMethodName = true)
        
ALogInitializer.init(shouldLog, defaultTagSettings)
```

2. Log:
```kotlin
ALog.d("Your message to log on debug level.")
ALog.e(Exception("Your exception to log on error level."))
```
**Result:**
![Basic logging result example](https://i.imgur.com/bWgqjhf.png)

3. Stop library (you probably want to do this in `onDestroy()` method of yours `Application` class)::
```kotlin
ALogInitializer.destroy()
```

## Some advanced features:
1. **Fully customizable tag**:
As I have shown before: `ALogInitializer.init(...)` method takes TagSettings object as argument:

![TagSettings data structure](https://i.imgur.com/oARBKaw.png)

If you set `shouldLogClassName` of `tagSettings` flag to `true`, you will see class name before message in every line logged. `shouldLogFileNameAndLineNum` is a cool feature too. If you set this flag to `true`, you will see in Logcat a hyperlink to the line of code, where you have used ALog (see in example of **Quick start quide#2**).

Optionally you can override default tag settings (you have set in ALogInitializer.init(...)) **in every specific usage of `ALog`**

```kotlin
ALog.d("This usage overrides tagSettings for own purpose.", true)
```
Above usage will log line number and file name **even if default global settings are different.**

2. **Null safety extensions with logging**

No more boilerplate like this:
```kotlin
myObject?.let {it.doSomething()} ?: Log.w(TAG, "object is null")

// Now you can just write
myObject.tw { it.doSomething() }
```

3. **Logging `Any?` type**

No more `.toString()` calls on objects you want to log. UltimateLogger **can log everything**:

```kotlin
ALog.d(1)
ALog.e(2f)
ALog.v(Date())
ALog.wtf((null as String?)) // Objects of nullable types are safe to log!
ALog.e() // Empty message? No problem.
```
**Result:**
![Logging Any? result](https://i.imgur.com/xpnUtFX.png)

## License

**[MIT](LICENSE)**
  
## Authors
  
###### Writer: [Artur Borowy](https://github.com/ArturBorowy)
###### Editor: [Jakub Brzozowski](https://github.com/KubaB)
