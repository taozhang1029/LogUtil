package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.stereotype.Component;

/**
 * @author kingsley
 */
@Component
public class LogLevelConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return ConfigConstants.getLogLevel(ConfigParser.level);
    }
}
