package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.stereotype.Component;

/**
 * @Class ConsolePatternConfig
 * @Time 2021/7/17 上午3:19
 * @Author kingsley
 * @Project log-util
 * @Description 控制台日志格式配置
 */
@Component
public class ConsolePatternConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return ConfigParser.consolePattern == null ? ConfigConstants.CONSOLE_LOG_PATTERN : ConfigParser.consolePattern;
    }
}
