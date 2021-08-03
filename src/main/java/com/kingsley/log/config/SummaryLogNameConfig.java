package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import com.kingsley.log.parser.ConfigParser;
import org.springframework.stereotype.Component;

/**
 * @author kingsley
 */
@Component
public class SummaryLogNameConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        String summaryLog = ConfigParser.baseConfig.getSummaryLog();
        return summaryLog != null ? summaryLog : ConfigConstants.SUMMARY_LOG_DEFAULT_NAME;
    }
}
