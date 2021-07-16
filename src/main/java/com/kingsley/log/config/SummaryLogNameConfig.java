package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.SummaryLogNameEnum;
import org.springframework.stereotype.Component;

/**
 * @author kingsley
 */
@Component
public class SummaryLogNameConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        if (ConfigParser.summaryLogName != null) {
            return ConfigParser.summaryLogName;
        }
        return SummaryLogNameEnum.SUMMARY_LOG_DEFAULT_NAME.getFileName();
    }
}
