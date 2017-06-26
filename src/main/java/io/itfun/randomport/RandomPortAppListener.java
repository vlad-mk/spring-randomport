package io.itfun.randomport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

/**
 * Created by Vlad Mikerin on 6/26/17.
 */
@Slf4j
@Component
public class RandomPortAppListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        onApplicationEnvironmentPreparedEvent(event);
    }


    private void onApplicationEnvironmentPreparedEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment env = event.getEnvironment();
        addPropertySources(env);
    }


    void addPropertySources(ConfigurableEnvironment env){
        MutablePropertySources sources = env.getPropertySources();
        if(!sources.contains(RandomPortPropertySource.SOURCE_NAME))
            log.info("Adding RandomPort Properties");
            RandomPortPropertySource propertySource = new RandomPortPropertySource();
            sources.addLast(propertySource);
    }


}
