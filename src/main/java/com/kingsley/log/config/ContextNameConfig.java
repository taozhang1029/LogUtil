package com.kingsley.log.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ContextNameConfig extends BaseConfig{

    @Override
    public String getPropertyValue() {
        System.out.println("contextName = " + contextName);
        return contextName == null ? "LogUtil" : contextName;
    }

    public String getContextName() {
        return contextName;
    }
}
