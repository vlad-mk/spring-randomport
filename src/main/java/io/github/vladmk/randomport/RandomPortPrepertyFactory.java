package io.github.vladmk.randomport;

import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Vlad Mikerin on 7/7/17.
 */
@Component
public class RandomPortPrepertyFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        return new RandomPortPropertySource(name);
    }
}
