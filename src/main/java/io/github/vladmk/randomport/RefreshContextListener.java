package io.github.vladmk.randomport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Vlad Mikerin on 7/7/17.
 */
@Component
@Slf4j
public class RefreshContextListener {
    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        log.debug("Refreshing context");
        RandomPortPropertySource.addToEnvironment(event.getApplicationContext().getEnvironment());
    }
}

