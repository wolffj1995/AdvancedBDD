package de.tallence.bddtest.config;

import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import de.telekom.test.bddwebapp.api.ApiOnly;
import de.telekom.test.bddwebapp.steps.ScannedStepsFactory;
import de.telekom.test.bddwebapp.stories.config.FaultTolerantStoryPathResolver;
import de.telekom.test.bddwebapp.stories.config.ScannedStoryPaths;
import de.telekom.test.bddwebapp.stories.config.ScreenshotStoryReporterBuilder;
import de.telekom.test.bddwebapp.stories.customizing.CurrentStoryEmbedderMonitor;
import de.telekom.test.bddwebapp.stories.customizing.CustomizingStories;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnitReportingRunner.class)
public abstract class RunAllStories extends JUnitStories implements ScannedStepsFactory, ScreenshotStoryReporterBuilder, FaultTolerantStoryPathResolver, ScannedStoryPaths {
    public RunAllStories() {
    }

    public Configuration configuration() {
        Configuration configuration = new MostUsefulConfiguration();
        configuration.useStoryReporterBuilder(this.screenshotStoryReporterBuilder());
        configuration.useStoryPathResolver(this.removeStoryFromClassNameStoryPathResolver());
        return configuration;
    }

    public InjectableStepsFactory stepsFactory() {
        return this.scannedStepsFactory();
    }

    public List<String> storyPaths() {
        return this.scannedStoryPaths();
    }

    public Embedder configuredEmbedder() {
        Embedder embedder = super.configuredEmbedder();
        embedder.useEmbedderMonitor(new CurrentStoryEmbedderMonitor(this.getApplicationContext()));
        return embedder;
    }

    public void run() {
        if (this.apiOnly()) {
            CustomizingStories storyClasses = (CustomizingStories) this.getApplicationContext().getBean(CustomizingStories.class);
            storyClasses.setApiOnlyForAllStories(true);
        }

        super.run();
    }

    public boolean apiOnly() {
        return Arrays.stream(this.getClass().getAnnotations()).anyMatch((annotation) -> {
            return annotation.annotationType().equals(ApiOnly.class);
        });
    }

    public abstract ApplicationContext getApplicationContext();
}

