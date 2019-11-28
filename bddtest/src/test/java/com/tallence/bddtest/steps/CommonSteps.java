package com.tallence.bddtest.steps;

import com.tallence.bddtest.config.ApplicationContextProvider;
import com.tallence.bddtest.config.converter.JsonConverter;
import de.telekom.test.bddwebapp.frontend.page.Page;
import de.telekom.test.bddwebapp.frontend.steps.SeleniumSteps;
import de.telekom.test.bddwebapp.interaction.StoryInteraction;
import de.telekom.test.bddwebapp.steps.Steps;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

@Steps
public class CommonSteps extends SeleniumSteps {

    @Autowired
    private StoryInteraction storyInteraction;

    @BeforeStory
    public void beforeStory() {

        String[] activeProfileConfig = ApplicationContextProvider.getApplicationContext().getEnvironment().getActiveProfiles();
        List<String> activeProfiles = Arrays.stream(activeProfileConfig).filter(para -> !para.startsWith("set")).collect(toList());

        // copy spring enviroment properties in storyInteraction parameter to be accessible there
        copyPropertySource("test.properties", ApplicationContextProvider.TEST_PROPERTIES_NAME + ".properties");
        copyPropertySource("test_data.properties", ApplicationContextProvider.TEST_DATA_PROPERTIES_NAME + "_" + activeProfileConfig[0] + ".properties");
        for (String activeProfile : activeProfiles) {
            copyPropertySource("test.properties", ApplicationContextProvider.TEST_PROPERTIES_NAME + "-" + activeProfile + ".properties");
        }
    }

    @BeforeScenario
    public void beforeScenario() {
        webDriverWrapper.getDriver().manage().deleteAllCookies();
        webDriverWrapper.getDriver().manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
    }

    private void copyPropertySource(String prefix, String propertySourceName) {
        PropertiesPropertySource propertySource = (PropertiesPropertySource) ((ConfigurableEnvironment) ApplicationContextProvider.getApplicationContext().getEnvironment()).getPropertySources().get(propertySourceName);
        storyInteraction.remember(prefix, propertySource.getSource());
    }

    @Then("the $pageClassName is shown")
    @Alias("the $pageClassName is shown again")
    public void waitUntilPageIsShown(String pageClassName) {
        try {
            createExpectedPage((Class<? extends Page>) this.getClass().forName("com.tallence.bddtest.pages." + pageClassName));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("A Page class with the given Name does not exist.", e);
        }
    }

    @Given("the cache filled with $map")
    public void cacheFilled(JsonConverter.JsonMap jsonMap) {
        jsonMap.keySet().forEach(key -> {
            storyInteraction.remember((String) key, jsonMap.get(key));
        });
    }
}
