package com.github.demo.basic.java.util;

import java.util.Random;

/**
 * @author Shawn
 * @date 2020/9/12
 */
public class RandomUtil {

  public static String genRandomNum(int pwd_len) {
    int i; // 生成的随机数
    int count = 1; // 生成的密码的长度
    char[] res=new char[pwd_len];
    char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&', '*', '(', ',', ')', '_', '+', '-', '=','0','1','2','3','4','5','6','7','8','9'};
    Random r = new Random();
    res[0]=str[r.nextInt(26)];
    while (count < pwd_len) {
      // 生成随机数，取绝对值，防止生成负数，
      i = Math.abs(r.nextInt(str.length)); // 生成的数最大为36-1
      if (i >= 0 && i < str.length) {
        res[count++]=str[i];
      }
    }
    res[r.nextInt(res.length-1)+1]='_';
    while (true){
      int n=r.nextInt(res.length-1);
      if(res[n]<='z'&&res[n]>='a'){
        res[n]=Character.toUpperCase(res[n]);
        break;
      }
    }
    return String.valueOf(res);
  }
}
