# Android Support Utils

[![](https://www.jitpack.io/v/RaunySouza/android-support.svg)](https://www.jitpack.io/#RaunySouza/android-support)

Android Support provides utility classes for helping create Android Applications.

This repository is divided in the following modules:

* ui
* ui-databinding

### UI

Provides utility classes for helping create UI Elements, e.g. Dialogs, Activities, Views, etc.

### UI Databinding

Similar to android-support-ui, plus helper classes to Android DataBinding.

Obs.: This library already has dependency of android-support-ui module.

## Including in your project

You need to add JitPack repository into your root project:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://www.jitpack.io' }
    }
}
```

Then add the library(ies) to your project:

```groovy
dependencies {
    compile 'com.github.RaunySouza.android-support:<Module>:<Version>'
}
```

Please, feel free to suggest enhancements or changes. Pull requests are welcome.

That's it! Enjoy!

## License

    The MIT License (MIT)

    Copyright (c) 2016 Rauny Souza

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

