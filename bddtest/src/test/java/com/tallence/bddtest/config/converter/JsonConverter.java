package com.tallence.bddtest.config.converter;

import de.telekom.test.bddwebapp.interaction.StoryInteraction;
import org.jbehave.core.annotations.AsJson;
import org.jbehave.core.steps.ParameterConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class JsonConverter extends ParameterConverters.JsonConverter {


    @Autowired
    protected StoryInteraction storyInteraction;

    private Pattern findVariablesPattern = Pattern.compile("(\\$.*?\\$)");

    @Override
    public Object convertValue(String value, Type type) {
        StringBuffer convertedValueBuffer = new StringBuffer();
        Matcher matcher = findVariablesPattern.matcher(value);
        while ( matcher.find() ){
            String key = matcher.group(1).substring(1 ,matcher.group(1).length() - 1 ).trim();
            String replacement = storyInteraction.recall(key);
            if (replacement == null){
                throw new RuntimeException("Unable to find scenario context variable for key: " + key  + "\n"
                                        +"available keys are:" + storyInteraction.getContext().keySet().toString());
            }
            matcher.appendReplacement( convertedValueBuffer,  replacement  );
        }
        matcher.appendTail( convertedValueBuffer );

        return super.convertValue(convertedValueBuffer.toString(), type);
    }


    /**
     * Just an annotated {@link java.util.Map} to achieve the using of JBehave {@link ParameterConverters.JsonConverter} when used as parameter type in step implementation.
     *
     * @param <K>
     * @param <V>
     */
    @AsJson
    public static class JsonMap<K, V> extends HashMap<K, V> {

    }


    /**
     * Just an annotated {@link java.util.Map} to achieve the using of JBehave {@link ParameterConverters.JsonConverter} when used as parameter type in step implementation.
     *
     * @param <E>*
     */
    @AsJson
    public static class JsonList<E> extends ArrayList<E> {

    }
}
