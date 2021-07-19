package com.kingsley.log.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
/**
 * @Class LogTest
 * @Time 2021/7/17 上午12:48
 * @Author kingsley
 * @Project log-util
 * @Description 日志工具测试类
 */
@Slf4j
public class LogTest {

    @Test
    public void test() {
        log.error("测试日志工具类");
        log.info(System.getProperty("os.name"));
        log.info(System.getProperty("os.version"));
        log.info(System.getProperty("os.arch"));
    }

}
