package com.kingsley.log;

import com.kingsley.log.config.BaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author kingsley
 */
@Configuration
@ComponentScan("com.kingsley.log")
public class LogConfiguration {

    @Bean
    public BaseConfig getBaseConfig(){
        BaseConfig config = new BaseConfig();
        config.setLevel("error");
        config.setLogDir("config-log");
        return config;
    }

}
