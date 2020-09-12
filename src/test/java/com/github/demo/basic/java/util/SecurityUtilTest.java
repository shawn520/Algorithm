package com.github.demo.basic.java.util;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shawn
 * @date 2020/9/12
 */
public class SecurityUtilTest {
  private static Logger logger = LoggerFactory.getLogger(SecurityUtilTest.class);

  public static final String PASSWORD = "123456";


  @Test
  public void testEncrypt(){
    String password = "123456";
    logger.info("加密前: {}", password);
    String afterEncrypt = SecurityUtil.encrypt(password);
    logger.info("加密后: {}", afterEncrypt);
    //Lj8HWTw4PQc0WCpWKz4ZOjU8NioJElFR
    Assert.assertEquals("加密不正确", "Lj8HWTw4PQc0WCpWKz4ZOjU8NioJElFR", afterEncrypt);
  }

  @Test
  public void testDecrypt(){
    String beforeDecrypt = "Lj8HWTw4PQc0WCpWKz4ZOjU8NioJElFR";
    logger.info("解密前: {}", beforeDecrypt);
    String afterDecrypt = SecurityUtil.decrypt(beforeDecrypt);
    logger.info("解密后: {}", afterDecrypt);
    // 123456
    Assert.assertEquals("解密不正确", PASSWORD, afterDecrypt);
  }
}
