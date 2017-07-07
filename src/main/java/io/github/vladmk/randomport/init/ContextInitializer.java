package io.github.vladmk.randomport.init;

import io.github.vladmk.randomport.RandomPortPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Vlad Mikerin on 4/5/17.
 */
@Slf4j
//@Component
public class ContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext>{
    @Override
    public void initialize(final ConfigurableApplicationContext applicationContext) {
        log.debug("initialize context");
        RandomPortPropertySource.addToEnvironment(applicationContext.getEnvironment());

    }
}
