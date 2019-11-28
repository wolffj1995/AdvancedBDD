package com.tallence.bddtest.config;

import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;


public class JBehaveContext {

    protected static Scenario currentScenario;

    protected static Story currentStory;

    public static Story getCurrentStory() {
        return currentStory;
    }
    public static Scenario getCurrentScenario() {
        return currentScenario;
    }



}
