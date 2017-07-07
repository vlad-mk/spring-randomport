package io.github.vladmk.randomport.boot;

import io.github.vladmk.randomport.RandomPortPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by Vlad Mikerin on 6/26/17.
 */
@Slf4j
//@Component
public class AppEnvPreparedListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        RandomPortPropertySource.addToEnvironment(event.getEnvironment());
    }
}
