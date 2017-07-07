package io.github.vladmk.spring.app;

import io.github.vladmk.randomport.RandomPortPrepertyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Vlad Mikerin on 7/7/17.
 */
@Configuration
@PropertySource(value="dummy", factory = RandomPortPrepertyFactory.class,  ignoreResourceNotFound=true)
@ComponentScan(basePackages = {"io.github.vladmk.spring.app"})
@Slf4j
public class TestApp {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    public static void main(String args[]) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(TestApp.class);

        TestBean testBean = context.getBean(TestBean.class);
        log.info("test port {}", testBean.port());
        context.close();

    }
}
