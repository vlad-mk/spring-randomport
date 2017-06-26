package io.itfun.randomport;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Vlad Mikerin on 4/5/17.
 */
public class ContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext>{
    @Override
    public void initialize(final ConfigurableApplicationContext applicationContext) {
        new RandomPortAppListener() {
            public void apply() {
                addPropertySources(applicationContext.getEnvironment());
            }
        }.apply();
    }
}
