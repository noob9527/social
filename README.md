# social
> sever side sdk for social login

[![Build Status](https://travis-ci.org/noob9527/social.svg?branch=master)](https://travis-ci.org/noob9527/social)
[![](https://jitpack.io/v/noob9527/social.svg)](https://jitpack.io/#noob9527/social)

### installation
#### kotlin/java lib
##### via gradle
```groovy
// step 1: add repository
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' } // add this line
    ...
}

// step 2: add dependency
dependencies {
    compile("com.github.noob9527:social:master-SNAPSHOT")
    // ...
}
```
##### via maven
```xml
<!-- step 1: add repository -->
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<!-- step 2: add dependency -->
<dependency>
    <groupId>com.github.noob9527</groupId>
    <artifactId>social</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```

### getting started
if you are using spring boot, related service are auto configured, otherwise you have to create them on your own

### configuration
| key | required | default |
| - | - | - |
| social.qq.app-id                    | true ||
| social.qq.app-secret                | true ||
| social.wechat.app-id                | true ||
| social.wechat.app-secret            | true ||
| social.weibo.app-id                 | true ||
| social.weibo.app-secret             | true ||
