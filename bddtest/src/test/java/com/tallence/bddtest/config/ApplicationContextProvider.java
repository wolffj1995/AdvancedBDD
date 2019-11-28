package com.tallence.bddtest.config;

import com.tallence.bddtest.config.converter.NullableStoryInteractionParameterConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static java.util.stream.Collectors.toList;

public class ApplicationContextProvider {
    private static final ApplicationContext applicationContext = createApplicationContext();

    public final static String TEST_PROPERTIES_NAME = "test";
    public final static String TEST_DATA_PROPERTIES_NAME = "test_data";

    private static AnnotationConfigApplicationContext createApplicationContext() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //active
        String[] activeProfileConfig = applicationContext.getEnvironment().getActiveProfiles();
        if(     activeProfileConfig.length < 1 ||
                !activeProfileConfig[0].startsWith("set") ||
                activeProfileConfig.length > 2){
            throw new RuntimeException("wrong configuration: needs to be of type  -Dspring.profiles.active=set_develop");
        }
        List<String> activeProfiles = Arrays.stream(activeProfileConfig).filter(para -> !para.startsWith("set")).collect(toList());

        // load default properties
        MutablePropertySources sources = applicationContext.getEnvironment().getPropertySources();
        sources = addPropertySource(sources, TEST_PROPERTIES_NAME + ".properties");
        sources = addPropertySource(sources, TEST_DATA_PROPERTIES_NAME+"_"+activeProfileConfig[0] + ".properties");

        // load profile specific properties to overwrite enviroment specific stuff
        // active profiles are set via enviromentSytemproperty "-Dspring.profiles.active=set1,toon2"
        // because of only 2 current possible allowed configurations, I kept it simple
        // "-Dspring.profiles.active=set1,toon2"
        // "-Dspring.profiles.active=set1"
        //
        for (String activeProfile : activeProfiles) {
            sources = addPropertySource(sources, TEST_PROPERTIES_NAME +  "-" + activeProfile +".properties");
            sources = addPropertySource(sources, TEST_DATA_PROPERTIES_NAME +  "-" + activeProfile +".properties");
        }

        // add configuration (annotated with componentscan)
        applicationContext.register(TestConfig.class);

        applicationContext.refresh();

        // remove BDD StoryInteractionParameterConverter  -> It is replaced by own NullableStoryInteractionParameterConverter
        applicationContext.removeBeanDefinition("storyInteractionParameterConverter");
        // add own extented storyInteractionParameterConverter with same bean name, because there is a unused dependency in BDD class SeleniumSteps.class
        applicationContext.registerBean("storyInteractionParameterConverter" , NullableStoryInteractionParameterConverter.class);

        return applicationContext;
    }



    private static MutablePropertySources addPropertySource(MutablePropertySources mutablePropertySources, String propertySourceName) {
        Properties properties = new Properties();
        try {
            properties.load(ApplicationContextProvider.class.getClassLoader().getResourceAsStream(propertySourceName));
            // load property files with charset utf-8 , Intellij must be configured to save them in utf-8 as well
//          properties.load( new InputStreamReader( ApplicationContextProvider.class.getClassLoader().getResourceAsStream(propertySourceName ) , "UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mutablePropertySources.addFirst(new PropertiesPropertySource(propertySourceName, properties));
        return mutablePropertySources;
    }


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}