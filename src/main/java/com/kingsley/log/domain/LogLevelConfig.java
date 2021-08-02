package com.kingsley.log.domain;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.stereotype.Component;

import static com.kingsley.log.parser.ConfigParser.level;

/**
 * @author kingsley
 */
@Component
public class LogLevelConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return ConfigConstants.getLogLevel(level);
    }
}
