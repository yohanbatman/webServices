package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.request.Request;

import jakarta.annotation.PostConstruct;

@Configuration
public class DynamicEndpointConfig {

    @Autowired
    @Qualifier("requestMappingHandlerMapping") // Specify the bean to inject
    private RequestMappingHandlerMapping handlerMapping;

    @Autowired
    private Controller userController; // Autowire the controller

    @PostConstruct
    public void init() throws NoSuchMethodException {
        // Register the POST endpoint dynamically
        handlerMapping.registerMapping(
            RequestMappingInfo.paths("/createUser ").methods(RequestMethod.POST).build(),
            userController,
            Controller.class.getMethod("createItem", Request.class) // Ensure the method signature matches
        );
    }
}