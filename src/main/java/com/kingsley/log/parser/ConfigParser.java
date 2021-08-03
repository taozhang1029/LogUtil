package com.kingsley.log.parser;

import com.alibaba.fastjson.JSON;
import com.kingsley.log.domain.BaseConfig;
import com.kingsley.log.domain.YamlConfig;
import org.ho.yaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author kingsley
 */
public class ConfigParser {

    public static BaseConfig baseConfig;

    static {
        InputStream is = ConfigParser.class.getClassLoader().getResourceAsStream("application.properties");
        BaseConfig.BaseConfigBuilder builder = BaseConfig.builder();
        if (is != null) {
            try {
                Properties pro = new Properties();
                pro.load(is);
                builder.logDir(confirm(pro.getProperty("log.dir")))
                    .context(confirm(pro.getProperty("log.context")))
                    .level(confirm(pro.getProperty("log.level")))
                    .filePattern(confirm(pro.getProperty("log.pattern.file")))
                    .consolePattern(confirm(pro.getProperty("log.pattern.console")))
                    .dayLogPattern(confirm(pro.getProperty("log.pattern.day")));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            is = ConfigParser.class.getClassLoader().getResourceAsStream("application.yml");
            if (is == null) {
                is = ConfigParser.class.getClassLoader().getResourceAsStream("application.yaml");
            }
            if (is != null) {
                try {
                    Object obj = Yaml.load(is);
                    String s = JSON.toJSONString(obj);
                    int index = s.indexOf("\"log\":");
                    if (index != -1) {
                        int pos = index + 7;
                        int leftCnt = 1;
                        while (pos < s.length() && leftCnt > 0) {
                            char c = s.charAt(pos);
                            if (c == '{') {
                                leftCnt++;
                            } else if (c == '}') {
                                leftCnt--;
                            }
                            pos++;
                        }
                        s = s.substring(index + 6, pos);
                        YamlConfig config = JSON.parseObject(s, YamlConfig.class);
                        builder.context(confirm(config.getContext()))
                            .logDir(confirm(config.getDir()))
                            .level(confirm(config.getLevel()))
                            .summaryLog(confirm(config.getSummary()))
                            .filePattern(confirm(config.getPattern().getOrDefault("file", null)))
                            .consolePattern(confirm(config.getPattern().getOrDefault("console", null)))
                            .dayLogPattern(confirm(config.getPattern().getOrDefault("day", null)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        baseConfig = builder.build();
    }

    private static String confirm(String s) {
        return (s == null || "".equals(s.trim().replace(" ", "").replace("\"", ""))) ? null : s;
    }

}
