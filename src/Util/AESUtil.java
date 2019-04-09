package Util;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AESUtil {
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param key 加密密钥
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String key) {
        try{
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM); //创建密码器
            byte [] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key)); //初始化为加密模式的密码器
            byte [] result = cipher.doFinal(byteContent);   //加密
            return Base64.encode(result);//通过Base64转码返回
        }catch (Exception e) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    public static SecretKeySpec getSecretKey(final String key) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator keyGenerator = null;

        try{
            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);

            //AES 要求密钥长度为 128
            keyGenerator.init(128, new SecureRandom((key.getBytes())));

            //生成一个秘钥
            SecretKey secretKey = keyGenerator.generateKey();

            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM); //转换为AES专用秘钥

        }catch (NoSuchAlgorithmException e) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param key
     * @return
     */
    public static String decrypt(String content, String key) {

        try{
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);//实例化

            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));//使用密钥初始化，设置为解密模式

            //执行解密操作
            byte [] result = cipher.doFinal(Base64.decode(content));
            return new String(result, "utf-8");

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
