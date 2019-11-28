package com.tallence.bddtest.config.properties;


import com.tallence.bddtest.config.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestProperties {

    @Value("${jbehave.writeReports}")
    public boolean jBehaveWriteReports = false;

    @Value("${jbehave.metaFilter}")
    public String jBehaveMetaFilter;

    @Value("${jbehave.storyTimeout}")
    public String jBehaveStoryTimeout;

    @Value("${time2sleepInSeconds.becauseOfAsyncClocks}")
    public Long timeToSleepBecauseOfAsyncClock;

    @Value("${presentationMode}")
    public boolean presentationMode;

    @Value("${jbehave.reuseCreatedAccounts}")
    public boolean jBehaveReuseCreatedAccounts = false;

    @Value("${screenshot.onsuccess}")
    public boolean screenshotOnSuccess = false;

    @Value("${browser.movePostionX}")
    public int browserMovePostionX = 0;

    @Value("${browser.movePostionY}")
    public int browserMovePostionY = 0;

    @Value("${app.hostIncludingPort}")
    public String appHostIncludingPort;
    @Value("${app.contextPath}")
    public String appContextPath = "";


    public static TestProperties getInstance() {
        return ApplicationContextProvider.getApplicationContext().getBean(TestProperties.class);
    }

}
