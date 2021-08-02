package com.kingsley.log.domain;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.kingsley.log.parser.ConfigParser.filePattern;

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
        return filePattern == null ? ConfigConstants.FILE_LOG_PATTERN : filePattern;
    }
}
