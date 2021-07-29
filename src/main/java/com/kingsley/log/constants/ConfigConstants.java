package com.kingsley.log.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Time : 2021/7/30 1:46
 * @Author : Kingsley
 * @Project : color-log-util
 * @File : ConfigConstants.java
 * @IDE : IntelliJ IDEA
 */
public class ConfigConstants {

    // 文件日志格式
    public static final String FILE_LOG_PATTERN = "%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level [%thread] %logger - %msg%n";

    // 控制台日志格式
    public static final String CONSOLE_LOG_PATTERN = "%d{yyyy-MM-dd HH:mm:ss.SSS} %highlight(%-5level) %boldYellow([%thread]) %cyan(%logger) %msg%n";

    // 文件日志默认输出路径
    public static final String DEFAULT_LOG_DIR = "log";

    // 默认日志级别
    public static final String DEFAULT_LOG_LEVEL = "INFO";

    // 日志级别常量
    public static final Set<String> LOG_LEVELS = new HashSet<>(Arrays.asList("VERBOSE", "DEBUG", "INFO", "WARN", "ERROR"));

    // 获取日志级别
    public static String getLogLevel(String level) {
        if (level == null) {
            return DEFAULT_LOG_LEVEL;
        }

        if (LOG_LEVELS.contains(level.toUpperCase())) {
            return level.toUpperCase();
        }

        return DEFAULT_LOG_LEVEL;
    }

    // 合并日志文件默认名称
    public static final String SUMMARY_LOG_DEFAULT_NAME = "summary";

    // 每日日志文件名称的默认格式
    public static final String DAY_LOG_FILE_NAME_DEFAULT_PATTERN = "%d{yyyy-MM-dd}";

}
