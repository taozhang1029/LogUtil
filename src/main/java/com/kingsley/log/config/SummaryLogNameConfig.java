package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.stereotype.Component;

/**
 * @author kingsley
 */
@Component
public class SummaryLogNameConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return ConfigParser.summaryLogName != null ? ConfigParser.summaryLogName : ConfigConstants.SUMMARY_LOG_DEFAULT_NAME;
    }
}
