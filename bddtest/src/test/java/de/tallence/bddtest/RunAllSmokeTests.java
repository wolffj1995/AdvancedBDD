package de.tallence.bddtest;

import de.tallence.bddtest.config.*;
import de.tallence.bddtest.config.properties.TestProperties;
import de.telekom.test.bddwebapp.steps.Steps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class RunAllSmokeTests extends RunAllBddStories {

    @Override
    public Embedder configuredEmbedder() {
        // manipulate to run only Scenarios with meta-tag @smokeTest
        getApplicationContext().getBean(TestProperties.class).jBehaveMetaFilter += getApplicationContext().getBean(TestProperties.class).jBehaveMetaFilter + ";+" + MetaTag.SMOKE_TEST + " *";
        return super.configuredEmbedder();
    }
}
