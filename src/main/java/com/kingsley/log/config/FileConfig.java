package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.parser.ConfigParser;
import org.springframework.stereotype.Component;

/**
 * @author: zhangtao552
 * @time: 2021/8/20 14:59
 * @description
 */
@Component
public class FileConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return ConfigParser.baseConfig.getUseFile();
    }

}
