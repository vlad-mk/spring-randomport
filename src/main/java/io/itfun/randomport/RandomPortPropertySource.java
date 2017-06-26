package io.itfun.randomport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.PropertySource;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Vlad Mikerin on 6/26/17.
 */
@Slf4j
public class RandomPortPropertySource extends PropertySource<RandomPortPropertySource.RandomPortPropertySoureHandler> {

    static class RandomPortPropertySoureHandler {

        Map<String, Integer> map = new ConcurrentHashMap<>();

        protected Integer getFreePort(String portName) {
            if(!map.containsKey(portName))
                synchronized (map) {
                    if(!map.containsKey(portName))
                        try (ServerSocket socket = new ServerSocket(0)) {
                            map.put(portName, socket.getLocalPort());
                        } catch (IOException e) {
                            log.error(e.getMessage(), e);
                            return 0;
                        }
                }
            return map.get(portName);
        }
        boolean containsProperty(String name) {
            return map.containsKey(name);
        }
    }

    public static final String SOURCE_NAME = "randomport";
    public static final String SOURCE_PREFIX= SOURCE_NAME + ".";


    public RandomPortPropertySource(String name)  {
        super(name, new RandomPortPropertySoureHandler());
        log.debug("Init property source {}", name);
    }
    public RandomPortPropertySource()  {
        this(SOURCE_NAME);
    }

    @Override
    public String getProperty(String name) {
        if (name == null ||!name.startsWith(SOURCE_PREFIX)) {
            return null;
        }

        log.debug("port property name =  {}", name);
        if (log.isTraceEnabled()) {
            log.trace("Get property for '{}'", name);
        }

        return getSource().getFreePort(name).toString();
    }

    @Override
    public boolean containsProperty(String property) {
        return getSource().containsProperty(property);
    }
}
