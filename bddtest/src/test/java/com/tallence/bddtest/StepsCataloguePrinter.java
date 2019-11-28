package com.tallence.bddtest;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StepsCataloguePrinter {


    private Reflections reflections;

    @Before
    public void setUp() {
        reflections = new Reflections("com.tallence.bddtest.steps", new MethodAnnotationsScanner(), new TypeAnnotationsScanner(), new SubTypesScanner());
    }

    @Test
    public void printSteps() {
        final StringBuilder builder = new StringBuilder();

        appendSteps(builder, "Given steps", Given.class);
        appendSteps(builder, "When steps", When.class);
        appendSteps(builder, "Then steps", Then.class);

        System.out.println(builder.toString());
    }

    private void appendSteps(final StringBuilder builder, final String headline, final Class<? extends Annotation> annotation)  {
        try {
            builder.append("\n");
            builder.append(headline);
            builder.append("\n------------------------------------------\n");
            final Set<Method> givenMethods = reflections.getMethodsAnnotatedWith(annotation);

            final Set<String> givenMethodTexts = new TreeSet();
            for (Method method : givenMethods) {
                final Annotation methodAnnotation = method.getAnnotation(annotation);
                final Object value = methodAnnotation.getClass().getMethod("value").invoke(methodAnnotation);
                givenMethodTexts.add(String.valueOf(value));
            }

            final String givenTexts = givenMethodTexts.stream().collect(Collectors.joining("\n"));
            builder.append(givenTexts);
            builder.append("\n");
        } catch(IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
