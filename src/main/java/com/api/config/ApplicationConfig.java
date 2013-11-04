package com.api.config;

import com.api.services.EventsRestService;

import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        //noinspection unchecked
        return new HashSet<Class<?>>(Arrays.asList(
                EventsRestService.class
        ));
    }
}