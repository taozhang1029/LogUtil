package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.stereotype.Component;

/**
 * @Class FilePatternConfig
 * @Time 2021/7/17 上午3:19
 * @Author kingsley
 * @Project log-util
 * @Description 文件日志格式配置
 */
@Component
public class FilePatternConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return ConfigParser.filePattern == null ? ConfigConstants.FILE_LOG_PATTERN : ConfigParser.filePattern;
    }
}
