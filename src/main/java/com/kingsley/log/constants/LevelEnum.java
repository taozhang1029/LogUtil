package com.kingsley.log.constants;


/**
 * @author kingsley
 */
public enum LevelEnum {

    // 调试
    DEBUG("DEBUG"),
    // 信息
    INFO("INFO"),
    // 警告
    WARN("WARN"),
    // 错误
    ERROR("ERROR");


    private final String level;

    LevelEnum(String level) {
        this.level = level;
    }

    public static String confirm(String level) {
        if (level == null) {
            return INFO.level;
        }

        for (LevelEnum value : LevelEnum.values()) {
            if (level.equalsIgnoreCase(value.level)) {
                return value.level;
            }
        }

        return INFO.level;
    }

    public String getLevel() {
        return level;
    }

}
