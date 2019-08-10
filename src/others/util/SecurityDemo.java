package others.util;

/**
 * @author Shawn
 * @date 2019/8/10
 */
public class SecurityDemo {

    public static void main(String[] args) {
        String plain = "aaa";
        String ciper = SecurityUtil.encrypt(plain);
        System.out.println("after encrypt: " + ciper);

        String decrypt = SecurityUtil.decrypt(ciper);
        System.out.println("after decrypt: " + decrypt);

        if(plain.equals(decrypt)) {
            System.out.println(true);
        }

    }
}
