# SelfDependLayout
A custom ViewGroup to simplify layout by ratio.

![demo.png](./demo.png)

# Import
```groovy
repositories {
    ...
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    ...
    compile 'com.github.hackware1993:SelfDependLayout:1.0.0'
}
```

# Usage
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@android:color/white"
    android:orientation="vertical"
    tools:context="net.lucode.hackware.demo.selfdependlayout.MainActivity">

    <net.lucode.hackware.selfdependlayout.SelfDependLayout
        android:layout_width="wrap_content" // ignore what ever you set
        android:layout_height="0dp"
        android:layout_weight="1"
        app:dependWidth="false" // layout_width depend on layout_height
        app:dependencyRatio="0.25"> // layout_width = layout_height / 4

        <TextView
            android:layout_width="match_parent" // must be "match_parent"
            android:layout_height="match_parent"    // must be "match_parent"
            android:background="#f00"
            android:gravity="center"
            android:text="1 x 4"
            android:textColor="#ffffff"
            android:textSize="24dp" />

    </net.lucode.hackware.selfdependlayout.SelfDependLayout>

    <View
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:background="#0f0" />

</LinearLayout>

```

# License
```
MIT License

Copyright (c) 2016 hackware1993

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