package com.kingsley.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import static com.kingsley.log.parser.ConfigParser.baseConfig;

/**
 * @author kingsley
 */
@Slf4j
@Component
@Configuration
@ContextConfiguration
@ComponentScan("com.kingsley.log.config")
public class LogConfiguration implements ApplicationContextAware {

    public LogConfiguration() {
        this.showConfig();
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.showConfig();
    }

    public void showConfig() {
        log.info("日志上下文：{}", baseConfig.getContext());
        log.info("日志保存路径：{}", baseConfig.getLogDir());
        log.info("日志保留天数：{}", baseConfig.getRemainDays());

        log.info("控制台日志级别：{}", baseConfig.getConsoleLevel());
        log.info("控制台日志格式：{}", baseConfig.getConsolePattern());

        String useFile = baseConfig.getUseFile();
        log.info("记录日志文件：{}", useFile);
        if (Boolean.parseBoolean(useFile)) {
            log.info("文件日志名称：{}", baseConfig.getCurrentName());
            log.info("文件日志级别：{}", baseConfig.getFileLevel());
            log.info("文件日志格式：{}", baseConfig.getFilePattern());
            log.info("文件日志归档：{}", baseConfig.getFileZip());
        }

        String aloneError = baseConfig.getAloneError();
        log.info("记录错误日志：{}", aloneError);
        if (Boolean.parseBoolean(aloneError)) {
            log.info("错误日志名称：{}", baseConfig.getCurrentErrorName());
            log.info("错误日志格式：{}", baseConfig.getErrorPattern());
            log.info("错误日志归档：{}", baseConfig.getErrorZip());
        }
    }
}
