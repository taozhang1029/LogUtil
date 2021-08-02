package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Class ConsolePatternConfig
 * @Time 2021/7/17 上午3:19
 * @Author kingsley
 * @Project log-util
 * @Description 控制台日志格式配置
 */
@Component
public class ConsolePatternConfig extends PropertyDefinerBase {

    @Autowired
    private ConfigParser configParser;

    private String consolePattern;

    @PostConstruct
    public void getLogDir(){
        this.consolePattern = configParser.getConsolePattern();
    }

    @Override
    public String getPropertyValue() {
        if (consolePattern != null) {
            return consolePattern;
        }
        return ConfigConstants.CONSOLE_LOG_PATTERN;
    }
}
