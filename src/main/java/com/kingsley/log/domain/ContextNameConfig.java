package com.kingsley.log.domain;

import ch.qos.logback.core.PropertyDefinerBase;
import org.springframework.stereotype.Component;

import java.io.File;

import static com.kingsley.log.parser.ConfigParser.contextName;

/**
 * @author kingsley
 */
@Component
public class ContextNameConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        if (contextName != null) {
            return contextName;
        }
        String projectPath = System.getProperty("user.dir");
        return projectPath.substring(projectPath.lastIndexOf(File.separator) + 1);
    }
}
