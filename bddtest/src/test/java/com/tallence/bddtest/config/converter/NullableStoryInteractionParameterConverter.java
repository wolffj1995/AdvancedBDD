package com.tallence.bddtest.config.converter;

import de.telekom.test.bddwebapp.interaction.StoryInteraction;
import de.telekom.test.bddwebapp.steps.StoryInteractionParameterConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.util.Optional;


public class NullableStoryInteractionParameterConverter extends StoryInteractionParameterConverter {


    private StoryInteraction storyInteraction;


    @Autowired
    public NullableStoryInteractionParameterConverter(@NonNull StoryInteraction storyInteraction) {
        this.storyInteraction = storyInteraction;
    }


    /**
     * Overwrite function to achieve that it is possible to handle nullable parameter in steps
     *
     * @param key
     * @return
     */
    @Override
    protected String getStoryInteractionValue(String key) {
        String value;
        // if parameter key is $?xxx than it is expected as nullable key
        if (key.startsWith("?")) {
            value = Optional.ofNullable(this.storyInteraction.recall(key.substring(1))).map(Object::toString).orElse("");
        } else {
            value = this.storyInteraction.recall(key) != null ? this.storyInteraction.recallNotNull(key).toString() : "";
        }

        if (value.startsWith("[") && value.endsWith("]")) {
            value = value.substring(1, value.length() - 1);
        }

        return value;
    }

}
