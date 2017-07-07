spring-randomport
======================

Overview
---------

Implements random port  property source in spring, usually for test purposes.
Takes a random available TCP port number an assign it to a corresponding property.

The PropertySource will be loaded automatically by spring-boot, if the library is in a class path.

In plain old spring  a  "io.github.vladmk.randomport" package have to be added
to a @ComponentScan or @PropertySource(..., factory = RandomPortPrepertyFactory.class) can be used instead.

Property file example:
```
my.port=${randomport.my.port}
```


Boot example:
```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Value("${randomport.xxx}")
    String port;

    .................
}

```

Spring example:
```java

@Configuration
@ComponentScan(basePackages = "io.github.vladmk.randomport")
public class MyTestConfig {
}

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MyTestConfig.class})
public class MyTest {
    @Value("${randomport.xxx}")
    String port;

    ............

}

```
or
```java

@Configuration
@PropertySource(value="dummy", factory = RandomPortPrepertyFactory.class,  ignoreResourceNotFound=true)
@ComponentScan
public class MyConfig {

   @Value("${randomport.xxx}")
    String port;

}

```


dependencies
============

```groovy
testCompile group: 'io.github.vlad-mk', name: 'spring-randomport' ,  version: '0.1.4'
```



