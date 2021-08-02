package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * @author kingsley
 */
@Component
public class ContextNameConfig extends PropertyDefinerBase {

    @Autowired
    private ConfigParser configParser;

    private String contextName;

    @PostConstruct
    public void getLogDir(){
        this.contextName = configParser.getContextName();
    }

    @Override
    public String getPropertyValue() {
        if (contextName != null) {
            return contextName;
        }
        String projectPath = System.getProperty("user.dir");
        return projectPath.substring(projectPath.lastIndexOf(File.separator) + 1);
    }
}
