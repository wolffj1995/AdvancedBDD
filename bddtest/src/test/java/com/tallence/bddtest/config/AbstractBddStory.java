package com.tallence.bddtest.config;

import com.tallence.bddtest.config.converter.JsonConverter;
import com.tallence.bddtest.config.converter.StoryInteractionObjectConverter;
import com.tallence.bddtest.config.properties.TestProperties;
import de.telekom.test.bddwebapp.steps.Steps;
import de.telekom.test.bddwebapp.stories.AbstractStory;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.failures.BatchFailures;
import org.jbehave.core.reporters.ReportsCount;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractBddStory extends AbstractStory {

    @Override
    public ApplicationContext getApplicationContext() {
        return ApplicationContextProvider.getApplicationContext();
    }

    public static Embedder configureEmbedder(Embedder embedder, ApplicationContext applicationContext) {
        TestProperties testProperties = applicationContext.getBean(TestProperties.class);

        embedder.useMetaFilters(Arrays.asList(testProperties.jBehaveMetaFilter.split(";")));

        embedder.embedderControls().useStoryTimeouts(testProperties.jBehaveStoryTimeout);

        if (!testProperties.jBehaveWriteReports) {
            embedder.embedderControls().doGenerateViewAfterStories(false);
        }

        // only log exceptions in embedder, do not rethrow them
        embedder.useEmbedderFailureStrategy(new Embedder.EmbedderFailureStrategy() {
            @Override
            public void handleFailures(BatchFailures batchFailures) {
                System.err.println("Error in Embedder during batch processing: \n" + batchFailures.toString());
            }

            @Override
            public void handleFailures(ReportsCount reportsCount) {
                System.err.println("Error in Embedder during generating reports! \n" + reportsCount.toString());
            }
        });

        return embedder;
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        List<Object> steps = new ArrayList(this.getApplicationContext().getBeansWithAnnotation(Steps.class).values());
        return new ProxyInstanceStepsFactory(this.configuration(), steps);
    }

    public static Configuration configureConfiguration(Configuration configuration, ApplicationContext applicationContext) {
        // StoryInteractionObjectConverter must be first because it accepts java.lang.Object.
        // Otherwise the other converters will never be used...
        configuration.useParameterConverters(new ParameterConverters()
                .addConverters(applicationContext.getBean(StoryInteractionObjectConverter.class))
                .addConverters(applicationContext.getBean(JsonConverter.class))
        );

        TestProperties testProperties = applicationContext.getBean(TestProperties.class);
        if (!testProperties.jBehaveWriteReports) {
            // clear screenshotreporte from bdd-framework
            configuration.useStoryReporterBuilder(null);
        }

        configuration.useStoryReporterBuilder(  new JBehaveContextStoryReporterBuilder(configuration.storyReporterBuilder()));

        return configuration;
    }

    @Override
    public Configuration configuration() {
        Configuration configuration = super.configuration();
        configuration = configureConfiguration(configuration, getApplicationContext());
        return configuration;
    }

    @Override
    public Embedder configuredEmbedder() {
        Embedder embedder = super.configuredEmbedder();
        embedder = configureEmbedder(embedder, getApplicationContext());
        return embedder;
    }


}

