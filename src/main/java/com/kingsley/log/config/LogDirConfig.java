package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.LogDirEnum;

/**
 * 配置日志输出目录
 *
 * @author zhangtao552
 * @date 2021/7/16
 */

public class LogDirConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return ConfigParser.logDir == null ? LogDirEnum.DEFAULT_LOG_DIR.getDir() : ConfigParser.logDir;
    }
}
