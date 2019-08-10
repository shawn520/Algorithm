package others.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SecurityUtil {
    private static final String KEY_ALGORITHM = "AES";
    // 默认的加密算法
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static String KEY = getKey();

    /**
     * 加密
     *
     * @param content 待加密内容
     * @return 返回aes加密和异或操作之后的加密数据
     */
    public static String encrypt(String content){
        // logger.info("获取的key为:" + KEY);
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
     * @param content 待加SecureRandom 密内容
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
            // 实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            // 使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
            // 执行解密操作
            byte [] result = cipher.doFinal(Base64.getDecoder().decode(content));
            return new String(result, "utf-8");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }

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

            // AES 要求密钥长度为 128
            keyGenerator.init(128, secureRandom);

            // 生成一个秘钥
            SecretKey secretKey = keyGenerator.generateKey();

            // 转换为AES专用秘钥
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);

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

        // 通过Base64转码返回
        return Base64.getEncoder().encodeToString(encryptBytes);
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
