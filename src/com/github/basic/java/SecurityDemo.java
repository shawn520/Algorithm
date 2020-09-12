package com.github.basic.java;

/**
 * @author Shawn
 * @date 2019/8/10
 */
class rityDemo {

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
