package io.itfun.randomport;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.core.env.StandardEnvironment;


/**
 * Created by Vlad Mikerin on 4/3/17.
 */
@Slf4j

public class RandomPortPropertySourceTest {
    private final StandardEnvironment environment = new StandardEnvironment();
    private final SpringApplication application = new SpringApplication();

    private final ConfigFileApplicationListener initializer = new ConfigFileApplicationListener();

    @BeforeClass
    public static void init() {
        log.debug("set secvault env");
    }

    @Test
    public void testSame()  {

        RandomPortPropertySource randomPortPropertySource = new RandomPortPropertySource();

        String port = randomPortPropertySource.getProperty("randomport.xxxxx");

        Assert.assertNotNull(port);

        log.info("first test port = {}", port) ;

        String port2 = randomPortPropertySource.getProperty("randomport.xxxxx");
        Assert.assertEquals("port not the same", port, port2);
    }

    @Test
    public void testPropertySource() throws Exception {

        this.initializer.postProcessEnvironment(this.environment, this.application);
        new RandomPortAppListener().addPropertySources(this.environment);

        String property = this.environment.getProperty("randomport.xxxxx");
        Assert.assertNotNull(property);
        log.info( "second test port =  {}", property );
    }

}
