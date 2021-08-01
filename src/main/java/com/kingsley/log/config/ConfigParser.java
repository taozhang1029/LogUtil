package com.kingsley.log.config;

import com.alibaba.fastjson.JSON;
import com.kingsley.log.constants.ConfigConstants;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.ho.yaml.Yaml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author kingsley
 */
@Getter
@Component
@Slf4j
public class ConfigParser {

    @Autowired(required = false)
    private BaseConfig config;

    private String logDir;

    private String contextName;

    private String level;

    private String summaryLogName;

    private String filePattern;

    private String consolePattern;

    private String dayLogFileNamePattern;

    @PostConstruct
    private void getConfig() {
        if (config == null) {
            log.info("从文件中获取日志配置");
            getConfigFromFile();
        } else {
            log.info("从容器中的BaseConfig bean对象获取日志配置");
            this.logDir = config.getLogDir() == null ? ConfigConstants.DEFAULT_LOG_DIR : config.getLogDir();
            this.contextName = config.getContextName() == null ? ConfigConstants.DEFAULT_CONTEXT_NAME : config.getContextName();
            this.level = config.getLevel() == null ? ConfigConstants.DEFAULT_LOG_LEVEL : config.getLevel();
            this.summaryLogName = config.getSummaryLogName() == null ? ConfigConstants.SUMMARY_LOG_DEFAULT_NAME : config.getSummaryLogName();
            this.filePattern = config.getFilePattern()== null ? ConfigConstants.FILE_LOG_PATTERN : config.getFilePattern();
            this.consolePattern = config.getConsolePattern()== null ? ConfigConstants.CONSOLE_LOG_PATTERN : config.getConsolePattern();
            this.dayLogFileNamePattern = config.getDayLogFileNamePattern()== null ? ConfigConstants.DAY_LOG_FILE_NAME_DEFAULT_PATTERN : config.getDayLogFileNamePattern();
        }
    }

    private void getConfigFromFile() {
        InputStream is = ConfigParser.class.getClassLoader().getResourceAsStream("application.properties");
        if (is != null) {
            try {
                Properties pro = new Properties();
                pro.load(is);
                logDir = confirm(pro.getProperty("log.dir"));
                contextName = confirm(pro.getProperty("log.context"));
                level = confirm(pro.getProperty("log.level"));
                filePattern = confirm(pro.getProperty("log.pattern.file"));
                consolePattern = confirm(pro.getProperty("log.pattern.console"));
                dayLogFileNamePattern = confirm(pro.getProperty("log.pattern.day"));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            is = ConfigParser.class.getClassLoader().getResourceAsStream("application.yml");
            if (is == null) {
                is = ConfigParser.class.getClassLoader().getResourceAsStream("application.yaml");
            }
            if (is != null) {
                try {
                    Object obj = Yaml.load(is);
                    String s = JSON.toJSONString(obj);
                    int index = s.indexOf("\"log\":");
                    if (index != -1) {
                        int pos = index + 7;
                        int leftCnt = 1;
                        while (pos < s.length() && leftCnt > 0) {
                            char c = s.charAt(pos);
                            if (c == '{') {
                                leftCnt++;
                            } else if (c == '}') {
                                leftCnt--;
                            }
                            pos++;
                        }
                        s = s.substring(index + 6, pos);
                        ConfigDetail config = JSON.parseObject(s, ConfigDetail.class);
                        contextName = confirm(config.getContext());
                        logDir = confirm(config.getDir());
                        level = confirm(config.getLevel());
                        logDir = confirm(config.getDir());
                        summaryLogName = confirm(config.getSummary());
                        Map<String, String> patterns = config.getPattern();
                        if (patterns != null) {
                            filePattern = confirm(patterns.getOrDefault("file", null));
                            consolePattern = confirm(patterns.getOrDefault("console", null));
                            dayLogFileNamePattern = confirm(patterns.getOrDefault("day", null));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private String confirm(String s) {
        return (s == null || "".equals(s.trim().replace(" ", "").replace("\"", ""))) ? null : s;
    }

}
