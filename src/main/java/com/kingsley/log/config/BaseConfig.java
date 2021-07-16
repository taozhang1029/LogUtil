package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:application.properties"})
public class BaseConfig extends PropertyDefinerBase {

    @Value("${log.dir:log}")
    protected String logDir;

    @Value("${log.context-name:LogUtil}")
    protected String contextName;

    @Value("${log.level:info}")
    protected String levelDesc;

    @Override
    public String getPropertyValue() {
        return null;
    }
}
