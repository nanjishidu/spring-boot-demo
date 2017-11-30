package com.example.controller.common;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@PropertySource(value = {"exception.properties"}, encoding = "UTF-8")
public class ExceptionManager {
    private static final Logger logger = LogManager.getLogger(ExceptionManager.class);
    @Resource
    Environment environment;
    public GloableException create(String code) {
        logger.debug(environment.getProperty(code));
        return new GloableException(code, environment.getProperty(code));
    }

}