package com.kingsley.log.domain;

import lombok.*;

/**
 * @author: zhangtao552
 * @time: 2021/8/3 9:13
 * @description 基础配置
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseConfig {

    private String logDir;

    private String context;

    private String level;

    private String summaryLog;

    private String filePattern;

    private String consolePattern;

    private String dayLogPattern;

}
