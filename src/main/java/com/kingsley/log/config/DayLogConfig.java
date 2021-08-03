package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import com.kingsley.log.parser.ConfigParser;
import org.springframework.stereotype.Component;
/**
 * @Description
 * @Time : 2021/7/30 2:12
 * @Author : Kingsley
 * @Project : color-log
 * @File : DayLogFileNameConfig.java
 * @IDE : IntelliJ IDEA
 */
@Component
public class DayLogConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        String dayLogPattern = ConfigParser.baseConfig.getDayLogPattern();
        return dayLogPattern != null ? dayLogPattern : ConfigConstants.DAY_LOG_FILE_NAME_DEFAULT_PATTERN;
    }
}
