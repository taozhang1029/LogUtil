package com.kingsley.log.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LogTest {

    @Test
    public void test() {
        log.info(String.valueOf(123));
    }

}
