package de.tallence.bddtest.config;

import de.tallence.bddtest.config.properties.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"de.telekom.test.bddwebapp", "de.tallence.bddtest"
})
@EnableAspectJAutoProxy
public class TestConfig {

    @Autowired
    private TestProperties testProperties;
}
