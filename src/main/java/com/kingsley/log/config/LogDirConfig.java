package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.stereotype.Component;

/**
 * 配置日志输出目录
 *
 * @author zhangtao552
 * @date 2021/7/16
 */
@Component
public class LogDirConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return ConfigParser.logDir == null ? ConfigConstants.DEFAULT_LOG_DIR : ConfigParser.logDir;
    }
}
