package com.tallence.bddtest.config;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.steps.AbstractStepsFactory;

import java.util.*;

public class ProxyInstanceStepsFactory extends AbstractStepsFactory {

    private final Map<Class<?>, Object> stepsInstances;


    /**
     * Stepsfactory to use real step class instead of cglib proxy class when using spring aop.
     *
     *
     * @param configuration
     * @param stepsInstances
     */
    public ProxyInstanceStepsFactory(Configuration configuration, List<?> stepsInstances) {
        super(configuration);
        this.stepsInstances = new LinkedHashMap();
        Iterator var3 = stepsInstances.iterator();

        while(var3.hasNext()) {
            Object instance = var3.next();

            // use superclass for all step instances under package com.tallence.advancedBDD . Because we use a spring aop proxy arround them. Otherwise jbehave does not find the step methods via class.getMethods();
            this.stepsInstances.put( instance.getClass().getSuperclass().getPackage().getName().startsWith( "com.tallence.advancedBDD" ) ? instance.getClass().getSuperclass() : instance.getClass(), instance);
        }

    }

    protected List<Class<?>> stepsTypes() {
        return new ArrayList(this.stepsInstances.keySet());
    }

    public Object createInstanceOfType(Class<?> type) {
        Object instance = this.stepsInstances.get(type);
        if (instance == null) {
            throw new StepsInstanceNotFound(type, this);
        } else {
            return instance;
        }
    }

}
