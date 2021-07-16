package com.kingsley.log.level;

public enum LogLevelEnum {

    DEBUG("DEBUG","debug"),
    INFO("INFO","info"),
    WARN("WARN","warn"),
    ERROR("ERROR","error");

    private String level;

    private String levelDesc;

    LogLevelEnum(String level, String levelDesc) {
        this.level = level;
        this.levelDesc = levelDesc;
    }

    public String getLevel() {
        return level;
    }

    public String getLevelDesc() {
        return levelDesc;
    }

    public static LogLevelEnum getLevelFromDesc(String levelDesc){
        if (levelDesc == null) {
            return null;
        }

        for (LogLevelEnum value : LogLevelEnum.values()) {
            if (levelDesc.equalsIgnoreCase(value.levelDesc)){
                return value;
            }
        }

        return null;
    }

}
