package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 配置日志输出目录
 *
 * @author zhangtao552
 * @date 2021/7/16
 */
@Component
public class LogDirConfig extends PropertyDefinerBase {

    @Autowired
    private ConfigParser configParser;

    private String logDir;

    @PostConstruct
    public void getLogDir(){
        this.logDir = configParser.getLogDir();
    }

    @Override
    public String getPropertyValue() {
        System.out.println(logDir);
        return logDir == null ? ConfigConstants.DEFAULT_LOG_DIR : logDir;
    }
}
