package com.kingsley.log.config;

import com.alibaba.fastjson.JSON;
import org.ho.yaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author kingsley
 */
public class ConfigParser {

    public static String logDir;

    public static String contextName;

    public static String level;

    public static String summaryLogName;

    public static String filePattern;

    public static String consolePattern;

    static {
        InputStream is = ConfigParser.class.getClassLoader().getResourceAsStream("application.properties");
        if (is != null) {
            try {
                Properties pro = new Properties();
                pro.load(is);
                logDir = confirm(pro.getProperty("log.dir"));
                contextName = confirm(pro.getProperty("log.context"));
                level = confirm(pro.getProperty("log.level"));
                filePattern = confirm(pro.getProperty("log.pattern.file"));
                consolePattern = confirm(pro.getProperty("log.pattern.console"));
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
                is = ConfigParser.class.getClassLoader().getResourceAsStream("application.yml");
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
                        ConfigDetail config = JSON.parseObject(s, ConfigDetail.class);
                        contextName = confirm(config.getContext());
                        logDir = confirm(config.getDir());
                        level = confirm(config.getLevel());
                        logDir = confirm(config.getDir());
                        summaryLogName = confirm(config.getSummary());
                        Map<String, String> patterns = config.getPattern();
                        if (patterns != null) {
                            filePattern = confirm(patterns.getOrDefault("file", null));
                            consolePattern = confirm(patterns.getOrDefault("console", null));
                        }
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
    }

    private static String confirm(String s) {
        return (s == null || "".equals(s.trim().replace(" ", "").replace("\"", ""))) ? null : s;
    }

}
