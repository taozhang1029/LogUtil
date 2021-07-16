package com.kingsley.log.constants;

/**
 * @author kingsley
 * @description 日志输出路径枚举
 * @file LogDirEnum.java
 * @time 2021/7/17 上午3:22
 * @project log-util
 * @ide Intellij IDEA
 */
public enum LogDirEnum {

    // 默认日志路径
    DEFAULT_LOG_DIR("默认文件日志输出路径", "log");

    private final String desc;

    private final String dir;

    LogDirEnum(String desc, String dir) {
        this.desc = desc;
        this.dir = dir;
    }

    public String getDesc() {
        return desc;
    }

    public String getDir() {
        return dir;
    }
}
