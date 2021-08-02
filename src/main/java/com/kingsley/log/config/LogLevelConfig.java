package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author kingsley
 */
@Component
public class LogLevelConfig extends PropertyDefinerBase {

    @Autowired
    private ConfigParser configParser;

    private String level;

    @PostConstruct
    public void getLogDir(){
        this.level = configParser.getLevel();
    }

    @Override
    @PostConstruct
    public String getPropertyValue() {
        return ConfigConstants.getLogLevel(level);
    }
}
