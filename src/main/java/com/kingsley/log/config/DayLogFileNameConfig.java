package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.stereotype.Component;

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

    @Override
    public String getPropertyValue() {
        return ConfigParser.dayLogFileNamePattern != null ? ConfigParser.dayLogFileNamePattern : ConfigConstants.DAY_LOG_FILE_NAME_DEFAULT_PATTERN;
    }
}
