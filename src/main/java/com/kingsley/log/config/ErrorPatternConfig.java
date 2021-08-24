package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.parser.ConfigParser;
import org.springframework.stereotype.Component;

/**
 * @Class FilePatternConfig
 * @Time 2021/7/17 上午3:19
 * @Author kingsley
 * @Project log-util
 * @Description 文件日志格式配置
 */
@Component
public class ErrorPatternConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return ConfigParser.baseConfig.getErrorPattern();
    }
}
