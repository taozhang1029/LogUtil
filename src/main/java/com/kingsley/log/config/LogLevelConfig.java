package com.kingsley.log.config;

import com.kingsley.log.level.LogLevelEnum;
import org.springframework.stereotype.Component;

@Component
public class LogLevelConfig extends BaseConfig {

    @Override
    public String getPropertyValue() {
        LogLevelEnum level;
        if (levelDesc == null || (level = LogLevelEnum.getLevelFromDesc(this.levelDesc)) == null) {
            return LogLevelEnum.INFO.getLevel();
        }
        return level.getLevel();
    }
}
