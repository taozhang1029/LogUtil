package com.kingsley.log;

import com.kingsley.log.config.ContextNameConfig;
import com.kingsley.log.config.LogDirConfig;
import com.kingsley.log.config.LogLevelConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextNameConfig.class, LogDirConfig.class, LogLevelConfig.class})
public class LogConfiguration {

}
