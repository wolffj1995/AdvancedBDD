package com.tallence.bddtest;

import com.tallence.bddtest.config.MetaTag;
import com.tallence.bddtest.config.properties.TestProperties;
import org.jbehave.core.embedder.Embedder;

public class RunAllSmokeTests extends RunAllBddStories {

    @Override
    public Embedder configuredEmbedder() {
        // manipulate to run only Scenarios with meta-tag @smokeTest
        getApplicationContext().getBean(TestProperties.class).jBehaveMetaFilter += getApplicationContext().getBean(TestProperties.class).jBehaveMetaFilter + ";+" + MetaTag.SMOKE_TEST + " *";
        return super.configuredEmbedder();
    }
}
