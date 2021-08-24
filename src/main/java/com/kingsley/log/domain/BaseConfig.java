package com.kingsley.log.domain;

import lombok.*;

/**
 * @author: zhangtao552
 * @time: 2021/8/3 9:13
 * @description 基础配置
 */
@Data
public class BaseConfig {

    private String context;
    private String logDir;
    private String remainDays;

    private String consoleLevel;
    private String consolePattern;

    private String useFile;
    private String fileLevel;
    private String filePattern;
    private String currentName;
    private String fileZip;

    private String aloneError;
    private String currentErrorName;
    private String errorPattern;
    private String errorZip;

}
