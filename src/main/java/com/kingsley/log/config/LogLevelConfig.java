package com.kingsley.log.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.kingsley.log.constants.LevelEnum;

/**
 * @author kingsley
 */
public class LogLevelConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return LevelEnum.confirm(LevelEnum.confirm(ConfigParser.level));
    }
}
