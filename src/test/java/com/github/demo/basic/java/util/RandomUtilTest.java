package com.github.demo.basic.java.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shawn
 * @date 2020/9/13
 */
public class RandomUtilTest {

  private static Logger logger = LoggerFactory.getLogger(RandomUtilTest.class);

  @Test
  public void testGenRandomNum() {
    String result = RandomUtil.genRandomNum(8);
    logger.info(result);
  }


}
