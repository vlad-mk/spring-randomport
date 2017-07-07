package io.github.vladmk.randomport.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.cthul.matchers.CthulMatchers.matchesPattern;

/**
 * Created by Vlad Mikerin on 7/7/17.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestContextBoot.class})
@SpringBootTest
@Slf4j
public class BootTest {
    @Value("${randomport.xxx}")
    String port;

    @Test
    public void test() {
        log.info("port = {}", port);
        Assert.assertThat(port, matchesPattern("\\d{1,5}"));
    }

}
