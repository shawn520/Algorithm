package com.github.demo.basic.java.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SecurityUtil {
    private static Logger logger = LoggerFactory.getLogger(SecurityUtil.class);
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法
    private static String KEY = getKey();

    /**
     * 加密
     *
     * @param content 待加密内容
     * @return 返回aes加密和异或操作之后的加密数据
     */
    public static String encrypt(String content){
        //logger.info("获取的key为:" + KEY);
        String encrypt = aesEncrypt(content,KEY);
        return XOREncrypt(encrypt,KEY);
    }

    /**
     * 解密
     *
     * @param content the String to decrypt
     * @return the String after xor & decrypt.
     */
    public static String decrypt(String content){
        String afterXOR = XORDecrypt(content,KEY);
        return aesDecrypt(afterXOR,KEY);
    }

    /**
     * AES 加密
     *
     * @param content 待加密内容
     * @param key 加密密钥
     * @return 返回Base64转码后的加密数据
     */
    private static String aesEncrypt(String content, String key) {
        try{
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM); //创建密码器
            byte [] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key)); //初始化为加密模式的密码器
            byte [] result = cipher.doFinal(byteContent);   //加密
            return Base64.getEncoder().encodeToString(result);  //通过Base64转码返回
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content the String to decrypt
     * @param key the key to decrypt the content.
     * @return the String after decrypt.
     */
     private static String aesDecrypt(String content, String key) {

        try{
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);//实例化
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));//使用密钥初始化，设置为解密模式
            byte [] result = cipher.doFinal(Base64.getDecoder().decode(content));   //执行解密操作
            return new String(result, "utf-8");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return a generated secret key.
     */
    private static SecretKeySpec getSecretKey(final String key) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator keyGenerator;

        try{
            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);

            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(key.getBytes());

            //AES 要求密钥长度为 128
            keyGenerator.init(128, secureRandom);

            //生成一个秘钥
            SecretKey secretKey = keyGenerator.generateKey();

            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM); //转换为AES专用秘钥

        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异或操作
     *
     * @param content the String needs to execute Xor operation
     * @param key another param
     * @return String after xor
     */
    private static String XOREncrypt(String content, String key){

        byte [] contentBytes = new byte[0];
        byte [] keyBytes = new byte[0];
        try {
            contentBytes = content.getBytes("utf-8");
            keyBytes = key.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte [] encryptBytes = new byte[contentBytes.length];
        for(int i=0;i<contentBytes.length;i++) {
            encryptBytes[i] = (byte)(contentBytes[i] ^ keyBytes[i%keyBytes.length]);
        }

        return Base64.getEncoder().encodeToString(encryptBytes);  //通过Base64转码返回
    }

    private static String XORDecrypt(String content, String key){

        byte [] contentBytes = Base64.getDecoder().decode(content);
        byte [] keyBytes = new byte[0];
        try {
            keyBytes = key.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte [] encryptBytes = new byte[contentBytes.length];
        for(int i=0;i<contentBytes.length;i++) {
            encryptBytes[i] = (byte)(contentBytes[i] ^ keyBytes[i%keyBytes.length]);
        }
        try{
            return new String(encryptBytes,"utf-8");

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @description 从密钥管理系统获取key
     * @return key
     */
    private static String getKey(){
        return "hello";
    }
}
