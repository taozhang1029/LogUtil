package com.kingsley.log.constants;

/**
 * @author kingsley
 * @description 合并日志文件名称枚举
 * @file SummaryLogNameEnum.java
 * @time 2021/7/17 上午3:43
 * @project log-util
 * @ide Intellij IDEA
 */
public enum SummaryLogNameEnum {

    // 合并日志文件默认名称
    SUMMARY_LOG_DEFAULT_NAME("合并日志文件默认名称", "summary");

    private final String desc;

    private final String fileName;

    SummaryLogNameEnum(String desc, String fileName) {
        this.desc = desc;
        this.fileName = fileName;
    }

    public String getDesc() {
        return desc;
    }

    public String getFileName() {
        return fileName;
    }
}
