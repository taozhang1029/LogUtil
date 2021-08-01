package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description
 * @Time : 2021/7/30 2:12
 * @Author : Kingsley
 * @Project : color-log-util
 * @File : DayLogFileNameConfig.java
 * @IDE : IntelliJ IDEA
 */
@Component
public class DayLogFileNameConfig extends PropertyDefinerBase {

    @Autowired
    private ConfigParser configParser;

    private String dayLogFileNamePattern;

    @PostConstruct
    public void getLogDir(){
        this.dayLogFileNamePattern = configParser.getDayLogFileNamePattern();
    }

    @Override
    @PostConstruct
    public String getPropertyValue() {
        return dayLogFileNamePattern != null ? dayLogFileNamePattern : ConfigConstants.DAY_LOG_FILE_NAME_DEFAULT_PATTERN;
    }
}
