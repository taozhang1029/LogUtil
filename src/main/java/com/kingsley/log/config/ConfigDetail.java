package com.kingsley.log.config;

import lombok.Data;

import java.util.Map;

/**
 * @Class domain
 * @Time 2021/7/17 上午2:34
 * @Author kingsley
 * @Project log-util
 * @Description 配置实体类
 */
@Data
public class ConfigDetail {

    private String context;

    private String dir;

    private String level;

    private String summary;

    private Map<String, String> pattern;

}
