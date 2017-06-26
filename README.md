spring-randomport
======================

Overview
---------

Implements randomport  property source in spring, usually for test purposes.

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
    testCompile:    gourp 'io.itfun', name: 'spring-randomport' ,  version: '0.1.0'
```



