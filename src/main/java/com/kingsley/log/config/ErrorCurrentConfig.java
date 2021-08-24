package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.parser.ConfigParser;
import org.springframework.stereotype.Component;

/**
 * @author kingsley
 */
@Component
public class ErrorCurrentConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return ConfigParser.baseConfig.getCurrentErrorName();
    }
}
