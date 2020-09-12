package com.github.basic.archived.offer.online.archived.old;

import java.math.BigInteger;
import java.util.Scanner;
/*
 * 2018.4.11华为在线编程第三题，大数相乘，通过率100
 * */
public class Huawei3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		
		String numberA = in.nextLine();
		String numberB = in.nextLine();
		
		BigInteger bignumA = new BigInteger(numberA);
		BigInteger bignumB = new BigInteger(numberB);
		BigInteger product = bignumA.multiply(bignumB);
		
		System.out.println(product);
	}
}
