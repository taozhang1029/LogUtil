package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.parser.ConfigParser;
import org.springframework.stereotype.Component;

import java.io.File;


/**
 * @author kingsley
 */
@Component
public class ContextConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        String contextName = ConfigParser.baseConfig.getContext();
        if (contextName != null) {
            return contextName;
        }
        String projectPath = System.getProperty("user.dir");
        return projectPath.substring(projectPath.lastIndexOf(File.separator) + 1);
    }
}
