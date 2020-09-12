package com.github.basic.java.sort.insert;

import java.util.Arrays;

public class InsertionSort2 {

	public static void main(String[] args) {
		
		Comparable [] a = {34,8,64,51,32,21};
		
		long startTime = System.nanoTime();
		insertionSort(a);
		System.out.println(Arrays.toString(a));
		long endTime = System.nanoTime();
		System.out.println("程序运行时间："+ (endTime-startTime) + "ns");
		
	}

	private static void insertionSort(Comparable[] a) {
		// TODO Auto-generated method stub
		
		int j;
		for(int p=1;p<a.length;p++){
			Comparable temp = a[p];
			
			for(j=p;j>0&&temp.compareTo(a[j-1])<0;j--){
				
				//如果a[j]小于a[j-1],将a[j-1]后移
				a[j] = a[j-1];
			}
			
			a[j] = temp;
		}
	}
}
