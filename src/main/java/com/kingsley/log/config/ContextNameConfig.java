package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author kingsley
 */
@Component
public class ContextNameConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        if (ConfigParser.contextName != null) {
            return ConfigParser.contextName;
        }
        String projectPath = System.getProperty("user.dir");
        return projectPath.substring(projectPath.lastIndexOf(File.separator) + 1);
    }
}
