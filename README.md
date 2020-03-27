# social
> sever side sdk for social login

[![Build Status](https://travis-ci.org/noob9527/social.svg?branch=master)](https://travis-ci.org/noob9527/social)
[![](https://jitpack.io/v/noob9527/social.svg)](https://jitpack.io/#noob9527/social)

## installation
### step 1: add jitpack repository url if it is absent
#### via gradle
```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' } // add this line
    // ...
}
```
#### via maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

### step 2: 
go to github release page to find out the latest available tag
#### via gradle
```groovy
dependencies {
    // for non spring boot user
    compile("com.github.noob9527:social:${tag}")
    // for spring boot user
    compile("com.github.noob9527.social:social-spring-boot-starter:${tag}")
    // ...
}
```
#### via maven
```xml
<!-- for non spring boot user -->
<dependency>
    <groupId>com.github.noob9527</groupId>
    <artifactId>social</artifactId>
    <version>${tag}</version>
</dependency>
<!-- for spring boot user -->
<dependency>
    <groupId>com.github.noob9527.social</groupId>
    <artifactId>social-spring-boot-starter</artifactId>
    <version>${tag}</version>
</dependency>
```

## configuration
for spring boot user, the following properties key is available 
```properties
social.qq.client-id
social.qq.client-secret
social.wechat.client-id
social.wechat.client-secret
social.weibo.client-id
social.weibo.client-secret
social.github.client-id
social.github.client-secret
social.google.client-id
social.google.client-secret
social.facebook.client-id
social.facebook.client-secret
social.linkedin.client-id
social.linkedin.client-secret
```
for each vendor, if the `client_id` is present, the starter will try create a corresponding service for you.
