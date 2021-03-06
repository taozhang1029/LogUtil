package com.kingsley.log.test;

import com.kingsley.log.LogConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Class LogTest
 * @Time 2021/7/17 上午12:48
 * @Author kingsley
 * @Project log-util
 * @Description 日志工具测试类
 */
@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = LogConfiguration.class)
public class LogTest {

    @Test
    public void test() {
        log.debug("测试日志工具类");
        log.info(System.getProperty("os.name"));
        log.warn(System.getProperty("os.version"));
        log.error(System.getProperty("os.arch"));
    }

}
