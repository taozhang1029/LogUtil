package com.kingsley.log.constants;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Time : 2021/7/30 1:46
 * @Author : Kingsley
 * @Project : color-log
 * @File : ConfigConstants.java
 * @IDE : IntelliJ IDEA
 */
public class ConfigConstants {

    public static final String CONTEXT = System.getProperty("user.dir").substring(System.getProperty("user.dir").lastIndexOf(File.separator) + 1);

    // 文件日志格式
    public static final String FILE_PATTERN = "%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level [%thread] %logger %msg%n";

    // 错误日志文件格式
    public static final String ERROR_LOG_PATTERN = "%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level [%thread] %logger %msg%n";

    // 控制台日志格式
    public static final String CONSOLE_PATTERN = "%d{yyyy-MM-dd HH:mm:ss.SSS} %highlight(%-5level) %boldYellow([%thread]) %cyan(%logger) %msg%n";

    // 文件日志默认输出路径
    public static final String DEFAULT_LOG_DIR = "logs";

    // 默认日志级别
    public static final String DEFAULT_LEVEL = "INFO";

    // 默认不记录到文件
    public static final boolean IS_USE_FILE = false;

    // 默认不单独记录错误
    public static final boolean ALONE_ERROR = false;

    // 日志级别常量
    public static final Set<String> LOG_LEVELS = new HashSet<>(Arrays.asList("DEBUG", "INFO", "WARN", "ERROR"));

    // 获取日志级别
    public static String getLogLevel(String level) {
        if (level == null) {
            return DEFAULT_LEVEL;
        }
        if (LOG_LEVELS.contains(level.toUpperCase())) {
            return level.toUpperCase();
        }
        return DEFAULT_LEVEL;
    }

    // 当前日志文件名称
    public static final String CURR_LOG = CONTEXT + ".log";

    // 当前错误日志文件名称
    public static final String CURR_ERROR_LOG = CONTEXT + "_error.log";

    // 日志文件保留天数
    public static final String REMAIN_DAYS = "30";

    // 归档日志名称（相当于同时设置了按天归档）2021-08-24.log.gz
    public static final String FILE_ZIP = "%d{yyyy-MM,aux}/%d{yyyy-MM-dd}.log.gz";

    // 归档错误日志名称（相当于同时设置了按天归档）2021-08-24.log.gz
    public static final String ERROR_ZIP = "%d{yyyy-MM,aux}/%d{yyyy-MM-dd}.error.gz";

}
