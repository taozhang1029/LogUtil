package com.kingsley.log.domain;

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
public class YamlConfig {

    private String context;
    private String dir;
    private String remain;

    private Map<String, String> console;
    private Map<String, String> file;
    private Map<String, String> error;

}
