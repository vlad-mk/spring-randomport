spring-randomport
======================

Overview
---------

Implements randomport  property source in spring, usually for test purposes.
Takes an available TCP port number an assign it to a corresponding property.

Property file example:
```
my.port=${randomport.my.port}
```


Java example:
```java
@Value("${randomport.my.port}")
Integer port;

```

usage
=====

```groovy
testCompile group: 'io.github.vlad-mk', name: 'spring-randomport' ,  version: '0.1.3'
```



