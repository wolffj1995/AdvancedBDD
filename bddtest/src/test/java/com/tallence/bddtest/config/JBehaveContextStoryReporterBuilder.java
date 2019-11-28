package com.tallence.bddtest.config;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.reporters.*;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JBehaveContextStoryReporterBuilder extends StoryReporterBuilder {


    private final StoryReporterBuilder storyReporterBuilder;

    public JBehaveContextStoryReporterBuilder(StoryReporterBuilder storyReporterBuilder){
        super();
        this.storyReporterBuilder = storyReporterBuilder;
    }

    @Override
    public StoryReporter build(String storyPath) {
        return  new JBehaveContextStoryReporterDelegate(storyReporterBuilder.build(storyPath));
    }


    public JBehaveContextStoryReporterBuilder() {
      throw new UnsupportedOperationException();
    }

    public JBehaveContextStoryReporterBuilder(Configuration configuration) {
        throw new UnsupportedOperationException();
    }

    @Override
    public File outputDirectory() {
        return storyReporterBuilder.outputDirectory();
    }

    @Override
    public String relativeDirectory() {
        return storyReporterBuilder.relativeDirectory();
    }

    @Override
    public FilePrintStreamFactory.FilePathResolver pathResolver() {
        return storyReporterBuilder.pathResolver();
    }

    @Override
    public URL codeLocation() {
        return storyReporterBuilder.codeLocation();
    }

    @Override
    public List<org.jbehave.core.reporters.Format> formats() {
        return storyReporterBuilder.formats();
    }

    @Override
    public List<String> formatNames(boolean toLowerCase) {
        return storyReporterBuilder.formatNames(toLowerCase);
    }

    @Override
    public Keywords keywords() {
        return storyReporterBuilder.keywords();
    }

    @Override
    public SGRCodes codes() {
        return storyReporterBuilder.codes();
    }

    @Override
    public boolean multiThreading() {
        return storyReporterBuilder.multiThreading();
    }

    @Override
    public boolean reportFailureTrace() {
        return storyReporterBuilder.reportFailureTrace();
    }

    @Override
    public boolean compressFailureTrace() {
        return storyReporterBuilder.compressFailureTrace();
    }

    @Override
    public Properties viewResources() {
        return storyReporterBuilder.viewResources();
    }

    @Override
    public StoryReporterBuilder withRelativeDirectory(String relativeDirectory) {
        return storyReporterBuilder.withRelativeDirectory(relativeDirectory);
    }

    @Override
    public StoryReporterBuilder withPathResolver(FilePrintStreamFactory.FilePathResolver pathResolver) {
        return storyReporterBuilder.withPathResolver(pathResolver);
    }

    @Override
    public StoryReporterBuilder withCodeLocation(URL codeLocation) {
        return storyReporterBuilder.withCodeLocation(codeLocation);
    }

    @Override
    public CrossReference crossReference() {
        return storyReporterBuilder.crossReference();
    }

    @Override
    public boolean hasCrossReference() {
        return storyReporterBuilder.hasCrossReference();
    }

    @Override
    public StoryReporterBuilder withCrossReference(CrossReference crossReference) {
        return storyReporterBuilder.withCrossReference(crossReference);
    }

    @Override
    public SurefireReporter surefireReporter() {
        return storyReporterBuilder.surefireReporter();
    }

    @Override
    public boolean hasSurefireReporter() {
        return storyReporterBuilder.hasSurefireReporter();
    }

    @Override
    public StoryReporterBuilder withSurefireReporter(SurefireReporter surefireReporter) {
        return storyReporterBuilder.withSurefireReporter(surefireReporter);
    }

    @Override
    public StoryReporterBuilder withDefaultFormats() {
        return storyReporterBuilder.withDefaultFormats();
    }

    @Override
    @Deprecated
    public StoryReporterBuilder withFormats(Format... formats) {
        return storyReporterBuilder.withFormats(formats);
    }

    @Override
    public StoryReporterBuilder withFormats(org.jbehave.core.reporters.Format... formats) {
        return storyReporterBuilder.withFormats(formats);
    }

    @Override
    public StoryReporterBuilder withReporters(StoryReporter... reporters) {
        return storyReporterBuilder.withReporters(reporters);
    }

    @Override
    public StoryReporterBuilder withFailureTrace(boolean reportFailureTrace) {
        return storyReporterBuilder.withFailureTrace(reportFailureTrace);
    }

    @Override
    public StoryReporterBuilder withFailureTraceCompression(boolean compressFailureTrace) {
        return storyReporterBuilder.withFailureTraceCompression(compressFailureTrace);
    }

    @Override
    public StoryReporterBuilder withKeywords(Keywords keywords) {
        return storyReporterBuilder.withKeywords(keywords);
    }

    @Override
    public StoryReporterBuilder withCodes(SGRCodes codes) {
        return storyReporterBuilder.withCodes(codes);
    }

    @Override
    public StoryReporterBuilder withMultiThreading(boolean multiThreading) {
        return storyReporterBuilder.withMultiThreading(multiThreading);
    }

    @Override
    public StoryReporterBuilder withViewResources(Properties resources) {
        return storyReporterBuilder.withViewResources(resources);
    }

    @Override
    public Map<String, StoryReporter> build(List<String> storyPaths) {
        return storyReporterBuilder.build(storyPaths);
    }

    @Override
    public StoryReporter reporterFor(String storyPath, Format format) {
        return storyReporterBuilder.reporterFor(storyPath, format);
    }

    @Override
    public StoryReporter reporterFor(String storyPath, org.jbehave.core.reporters.Format format) {
        return storyReporterBuilder.reporterFor(storyPath, format);
    }

    @Override
    public FilePrintStreamFactory filePrintStreamFactory(String storyPath) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FilePrintStreamFactory.FileConfiguration fileConfiguration(String extension) {
        return storyReporterBuilder.fileConfiguration(extension);
    }
}
