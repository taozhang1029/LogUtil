package com.kingsley.log.parser;

import com.alibaba.fastjson.JSON;
import com.kingsley.log.constants.ConfigConstants;
import com.kingsley.log.domain.BaseConfig;
import com.kingsley.log.domain.YamlConfig;
import org.ho.yaml.Yaml;
import org.ho.yaml.exception.YamlException;
import org.springframework.util.StringUtils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author kingsley
 */
public class ConfigParser {

    public static BaseConfig baseConfig = new BaseConfig();
    private static boolean inited;

    static {
        InputStream is = ConfigParser.class.getClassLoader().getResourceAsStream("log.yml");
        getConfigFromYml(is);
        close(is);

        is = ConfigParser.class.getClassLoader().getResourceAsStream("log.yaml");
        getConfigFromYml(is);
        close(is);

        is = ConfigParser.class.getClassLoader().getResourceAsStream("log.properties");
        getConfigFromProperties(is);
        close(is);

        // 保证配置被初始化
        if (!inited) {
            baseConfig.setContext(ConfigConstants.CONTEXT);
            baseConfig.setLogDir(ConfigConstants.DEFAULT_LOG_DIR);
            baseConfig.setRemainDays(ConfigConstants.REMAIN_DAYS);

            baseConfig.setConsoleLevel(ConfigConstants.DEFAULT_LEVEL);
            baseConfig.setConsolePattern(ConfigConstants.CONSOLE_PATTERN);

            baseConfig.setUseFile(String.valueOf(ConfigConstants.IS_USE_FILE));
            baseConfig.setFileLevel(ConfigConstants.DEFAULT_LEVEL);
            baseConfig.setCurrentErrorName(ConfigConstants.CURR_LOG);
            baseConfig.setFilePattern(ConfigConstants.FILE_PATTERN);
            baseConfig.setFileZip(ConfigConstants.FILE_ZIP);

            baseConfig.setAloneError(String.valueOf(ConfigConstants.ALONE_ERROR));
            baseConfig.setCurrentErrorName(ConfigConstants.CURR_ERROR_LOG);
            baseConfig.setErrorPattern(ConfigConstants.ERROR_LOG_PATTERN);
            baseConfig.setErrorZip(ConfigConstants.ERROR_ZIP);
        }
    }

    private static void getConfigFromProperties(InputStream is) {
        if (is == null) {
            return;
        }
        Properties prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String context = prop.getProperty("log.context");
        if (!StringUtils.isEmpty(context) || StringUtils.isEmpty(baseConfig.getContext())) {
            baseConfig.setContext(choose(context, ConfigConstants.CONTEXT));
        }
        String dir = prop.getProperty("log.dir");
        if (!StringUtils.isEmpty(dir) || StringUtils.isEmpty(baseConfig.getLogDir())) {
            baseConfig.setLogDir(choose(dir, ConfigConstants.DEFAULT_LOG_DIR));
        }
        String remain = prop.getProperty("log.remain");
        if (!StringUtils.isEmpty(remain) || StringUtils.isEmpty(baseConfig.getRemainDays())) {
            baseConfig.setRemainDays(choose(remain, ConfigConstants.REMAIN_DAYS));
        }

        String consoleLevel = prop.getProperty("log.console.level");
        if (!StringUtils.isEmpty(consoleLevel) || StringUtils.isEmpty(baseConfig.getConsoleLevel())) {
            baseConfig.setConsoleLevel(choose(consoleLevel, ConfigConstants.DEFAULT_LEVEL));
        }
        String consolePattern = prop.getProperty("log.console.pattern");
        if (!StringUtils.isEmpty(consolePattern) || StringUtils.isEmpty(baseConfig.getConsolePattern())) {
            baseConfig.setConsolePattern(choose(consolePattern, ConfigConstants.CONSOLE_PATTERN));
        }

        String useFile = prop.getProperty("log.file.use");
        if (!StringUtils.isEmpty(useFile) || StringUtils.isEmpty(baseConfig.getUseFile())) {
            baseConfig.setUseFile(choose(useFile, String.valueOf(ConfigConstants.IS_USE_FILE)));
        }
        String filePattern = prop.getProperty("log.file.pattern");
        if (!StringUtils.isEmpty(filePattern) || StringUtils.isEmpty(baseConfig.getFilePattern())) {
            baseConfig.setFilePattern(choose(filePattern, ConfigConstants.FILE_PATTERN));
        }
        String currName = prop.getProperty("log.file.curr");
        if (!StringUtils.isEmpty(currName) || StringUtils.isEmpty(baseConfig.getCurrentName())) {
            baseConfig.setCurrentName(choose(currName, ConfigConstants.CURR_LOG));
        }
        String fileGz = prop.getProperty("log.file.gz");
        if (!StringUtils.isEmpty(fileGz) || StringUtils.isEmpty(baseConfig.getFileZip())) {
            baseConfig.setFileZip(choose(fileGz, ConfigConstants.FILE_ZIP));
        }
        String fileLevel = prop.getProperty("log.file.level");
        if (!StringUtils.isEmpty(fileLevel) || StringUtils.isEmpty(baseConfig.getFileLevel())) {
            baseConfig.setFileLevel(choose(fileLevel, ConfigConstants.DEFAULT_LEVEL));
        }

        String aloneError = prop.getProperty("log.error.use");
        if (!StringUtils.isEmpty(aloneError) || StringUtils.isEmpty(baseConfig.getAloneError())) {
            baseConfig.setAloneError(choose(aloneError, String.valueOf(ConfigConstants.ALONE_ERROR)));
        }
        String errorName = prop.getProperty("log.error.curr");
        if (!StringUtils.isEmpty(errorName) || StringUtils.isEmpty(baseConfig.getCurrentErrorName())) {
            baseConfig.setCurrentErrorName(choose(errorName, ConfigConstants.CURR_ERROR_LOG));
        }
        String errorPattern = prop.getProperty("log.error.pattern");
        if (!StringUtils.isEmpty(errorPattern) || StringUtils.isEmpty(baseConfig.getErrorPattern())) {
            baseConfig.setErrorPattern(choose(errorPattern, ConfigConstants.ERROR_LOG_PATTERN));
        }
        String errorGz = prop.getProperty("log.error.gz");
        if (!StringUtils.isEmpty(errorGz) || StringUtils.isEmpty(baseConfig.getErrorZip())) {
            baseConfig.setErrorZip(choose(errorGz, ConfigConstants.ERROR_ZIP));
        }
        inited = true;
    }

    private static void getConfigFromYml(InputStream is) {
        if (is == null) {
            return;
        }
        Object obj = null;
        try {
            obj = Yaml.load(is);
        } catch (YamlException e) {
            if (e.getMessage().contains("first document is not a nested list or map")) {
                return;
            }
        }
        if (obj == null) {
            return;
        }
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

            baseConfig.setContext(choose(config.getContext(), ConfigConstants.CONTEXT));
            baseConfig.setLogDir(choose(config.getDir(), ConfigConstants.DEFAULT_LOG_DIR));
            baseConfig.setRemainDays(choose(config.getRemain(), ConfigConstants.REMAIN_DAYS));

            Map<String, String> console = config.getConsole();
            if (console == null) {
                console = new HashMap<>();
            }
            baseConfig.setConsoleLevel(choose(console.get("level"), ConfigConstants.DEFAULT_LEVEL));
            baseConfig.setConsolePattern(choose(console.get("pattern"), ConfigConstants.CONSOLE_PATTERN));

            Map<String, String> file = config.getFile();
            if (file == null) {
                file = new HashMap<>();
            }
            baseConfig.setUseFile(choose(file.get("use"), String.valueOf(ConfigConstants.IS_USE_FILE)));
            baseConfig.setFileLevel(choose(file.get("level"), ConfigConstants.DEFAULT_LEVEL));
            baseConfig.setCurrentErrorName(choose(file.get("curr"), ConfigConstants.CURR_LOG));
            baseConfig.setFilePattern(choose(file.get("pattern"), ConfigConstants.FILE_PATTERN));
            baseConfig.setFileZip(choose(file.get("gz"), ConfigConstants.FILE_ZIP));

            Map<String, String> error = config.getError();
            if (error == null) {
                error = new HashMap<>();
            }
            baseConfig.setAloneError(choose(error.get("use"), String.valueOf(ConfigConstants.ALONE_ERROR)));
            baseConfig.setCurrentErrorName(choose(error.get("curr"), ConfigConstants.CURR_ERROR_LOG));
            baseConfig.setErrorPattern(choose(error.get("pattern"), ConfigConstants.ERROR_LOG_PATTERN));
            baseConfig.setErrorZip(choose(error.get("gz"), ConfigConstants.ERROR_ZIP));
        }
        inited = true;
    }

    private static String choose(String s, String defaultValue) {
        if (s == null || "".equals(s.trim().replace(" ", "").replace("\"", ""))) {
            return defaultValue;
        }
        return s;
    }

    private static <T extends Closeable> void close(T obj) {
        if (obj == null) {
            return;
        }
        try {
            obj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
