package io.github.vladmk.spring.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by Vlad Mikerin on 7/7/17.
 */
@Component
//@Lazy
public class TestBean {
    @Value("${randomport.xxx}")
    String port;

    public TestBean() {
    }

    public TestBean(String port) {
        this.port = port;
    }

    public String port() {
        return "port: " + port;
    }
}
