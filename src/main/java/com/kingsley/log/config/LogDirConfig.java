package com.kingsley.log.config;

import org.springframework.context.annotation.Configuration;

/**
 * 配置日志输出目录
 *
 * Created by zhangtao552 on 2021/7/16.
 */
@Configuration
public class LogDirConfig extends BaseConfig {

    @Override
    public String getPropertyValue() {
        System.out.println("logDir = " + logDir);
        return logDir == null ? "logs" : logDir;
    }

    public String getLogDir() {
        return logDir;
    }
}
