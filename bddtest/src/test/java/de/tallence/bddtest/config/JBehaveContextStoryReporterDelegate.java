package de.tallence.bddtest.config;

import org.jbehave.core.model.*;
import org.jbehave.core.reporters.StoryReporter;

import java.util.List;
import java.util.Map;

public class JBehaveContextStoryReporterDelegate implements StoryReporter {

    private StoryReporter delegate;

    public JBehaveContextStoryReporterDelegate(StoryReporter storyReporter) {
        super();
        this.delegate = storyReporter;
    }

    @Override
    public void beforeScenario(Scenario scenario) {
        JBehaveContext.currentScenario = scenario;
        delegate.beforeScenario(scenario);
    }

    @Override
    public void beforeStory(Story story, boolean b) {
        JBehaveContext.currentStory = story;
        delegate.beforeStory(story, b);
    }



    // just delegate methods

    @Override
    public void storyNotAllowed(Story story, String s) {
        delegate.storyNotAllowed(story, s);
    }

    @Override
    public void storyCancelled(Story story, StoryDuration storyDuration) {
        delegate.storyCancelled(story, storyDuration);
    }



    @Override
    public void afterStory(boolean b) {
        delegate.afterStory(b);
    }

    @Override
    public void narrative(Narrative narrative) {
        delegate.narrative(narrative);
    }

    @Override
    public void lifecyle(Lifecycle lifecycle) {
        delegate.lifecyle(lifecycle);
    }

    @Override
    public void scenarioNotAllowed(Scenario scenario, String s) {
        delegate.scenarioNotAllowed(scenario, s);
    }


    @Override
    @Deprecated
    public void beforeScenario(String s) {
        delegate.beforeScenario(s);
    }

    @Override
    @Deprecated
    public void scenarioMeta(Meta meta) {
        delegate.scenarioMeta(meta);
    }

    @Override
    public void afterScenario() {
        delegate.afterScenario();
    }

    @Override
    public void beforeGivenStories() {
        delegate.beforeGivenStories();
    }

    @Override
    public void givenStories(GivenStories givenStories) {
        delegate.givenStories(givenStories);
    }

    @Override
    public void givenStories(List<String> list) {
        delegate.givenStories(list);
    }

    @Override
    public void afterGivenStories() {
        delegate.afterGivenStories();
    }

    @Override
    public void beforeExamples(List<String> list, ExamplesTable examplesTable) {
        delegate.beforeExamples(list, examplesTable);
    }

    @Override
    @Deprecated
    public void example(Map<String, String> map) {
        delegate.example(map);
    }

    @Override
    public void example(Map<String, String> map, int i) {
        delegate.example(map, i);
    }

    @Override
    public void afterExamples() {
        delegate.afterExamples();
    }

    @Override
    public void beforeStep(String s) {
        delegate.beforeStep(s);
    }

    @Override
    public void successful(String s) {
        delegate.successful(s);
    }

    @Override
    public void ignorable(String s) {
        delegate.ignorable(s);
    }

    @Override
    public void comment(String s) {
        delegate.comment(s);
    }

    @Override
    public void pending(String s) {
        delegate.pending(s);
    }

    @Override
    public void notPerformed(String s) {
        delegate.notPerformed(s);
    }

    @Override
    public void failed(String s, Throwable throwable) {
        delegate.failed(s, throwable);
    }

    @Override
    public void failedOutcomes(String s, OutcomesTable outcomesTable) {
        delegate.failedOutcomes(s, outcomesTable);
    }

    @Override
    public void restarted(String s, Throwable throwable) {
        delegate.restarted(s, throwable);
    }

    @Override
    public void restartedStory(Story story, Throwable throwable) {
        delegate.restartedStory(story, throwable);
    }

    @Override
    public void dryRun() {
        delegate.dryRun();
    }

    @Override
    public void pendingMethods(List<String> list) {
        delegate.pendingMethods(list);
    }

}
