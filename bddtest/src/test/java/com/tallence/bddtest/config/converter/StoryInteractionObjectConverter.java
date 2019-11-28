package com.tallence.bddtest.config.converter;


import de.telekom.test.bddwebapp.interaction.StoryInteraction;
import org.jbehave.core.steps.ParameterConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class StoryInteractionObjectConverter extends ParameterConverters.AbstractParameterConverter<Object> {

    @Autowired
    protected StoryInteraction storyInteraction;

    @Override
    public Object convertValue(String value, Type type) {
        if (!value.startsWith("$")) {
            throw new RuntimeException("unable to convert, its not a storyInteractionContext idenitifer." + value + " must start with a $");
        }

        Object o = storyInteraction.getContext().get(value.substring(1));

        if (o == null) {
            throw new RuntimeException("No value found with key." + value + " in storyInteractionContext.");
        }

        if (((Class<?>) type).isInstance(o)) {
            return o;
        } else {
            throw new RuntimeException("Value of key " + value + " is not of expected type " + ((Class<?>) type).getName());
        }

    }


}
