package com.tallence.bddtest.config.properties;

import de.telekom.test.bddwebapp.interaction.StoryInteraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DefaultContext {

    @Autowired
    protected StoryInteraction storyInteraction;

    @Autowired
    protected TestProperties testProperties;
}

