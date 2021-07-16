package com.kingsley.log.constants;

/**
 * @Class PatternEnum
 * @Time 2021/7/17 上午2:03
 * @Author kingsley
 * @Project log-util
 * @Description
 */
public enum PatternEnum {

    // 文件日志默认输出格式
    FILE_PATTERN("文件日志", "%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level [%thread] %logger - %msg%n"),

    // 控制台日志默认输出格式
    CONSOLE_PATTERN("控制台高亮日志", "%d{yyyy-MM-dd HH:mm:ss.SSS} %highlight(%-5level) %boldYellow([%thread]) %cyan(%logger) %msg%n");

    private final String desc;

    private final String pattern;

    PatternEnum(String desc, String pattern) {
        this.desc = desc;
        this.pattern = pattern;
    }

    public String getDesc() {
        return desc;
    }

    public String getPattern() {
        return pattern;
    }
}
