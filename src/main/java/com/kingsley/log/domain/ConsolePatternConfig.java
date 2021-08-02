package com.kingsley.log.domain;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.stereotype.Component;

import static com.kingsley.log.parser.ConfigParser.consolePattern;

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
        if (consolePattern != null) {
            return consolePattern;
        }
        return ConfigConstants.CONSOLE_LOG_PATTERN;
    }
}
