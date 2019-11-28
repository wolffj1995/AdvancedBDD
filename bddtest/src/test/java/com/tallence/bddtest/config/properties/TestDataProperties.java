package com.tallence.bddtest.config.properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Component
public class TestDataProperties {

    @Value("${name1}")
    private String name1;

    @Value("${name2}")
    private String name2;

    public String getValueOfKey(String key) throws IllegalAccessException {
        Set<Field> fieldsWithValueAnnotation = findFieldsWithAnnotation();
        for (Field field : fieldsWithValueAnnotation) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            String valueKey = valueAnnotation.value();
            String valueKeyWithoutPlaceholder = valueKey.substring(2, valueKey.length() - 1);
            if (valueKey.equals(key) || field.getName().equals(key) || valueKeyWithoutPlaceholder.equals(key)) {
                field.setAccessible(true);
                return String.valueOf(field.get(this));
            }
        }
        throw new RuntimeException("No Test Data found for Property: " + key);
    }

    private Set<Field> findFieldsWithAnnotation() {
        Set<Field> set = new HashSet<>();
        Class<?> c = this.getClass();
        while (c != null) {
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(Value.class)) {
                    set.add(field);
                }
            }
            c = c.getSuperclass();
        }
        return set;
    }

}
