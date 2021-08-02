package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.ConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author kingsley
 */
@Component
public class SummaryLogNameConfig extends PropertyDefinerBase {

    @Autowired
    private ConfigParser configParser;

    private String summaryLogName;

    @PostConstruct
    public void getLogDir(){
        this.summaryLogName = configParser.getSummaryLogName();
    }

    @Override
    @PostConstruct
    public String getPropertyValue() {
        return summaryLogName != null ? summaryLogName : ConfigConstants.SUMMARY_LOG_DEFAULT_NAME;
    }
}
