package com.github.basic.archived.offer.intro.biTree.search;

import java.util.Scanner;

public class Bisearch6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int key = in.nextInt();
		
		int [] a = {4,6,8,10,14};
		
		int ans = search(a,key);
		System.out.println(ans);
	}

	private static int search(int[] a, int key) {
		// TODO Auto-generated method stub
		
		return bisearch(a,key,0,a.length-1);
	}

	private static int bisearch(int[] a, int key, int left, int right) {
		// TODO Auto-generated method stub
		while(left<right){
			int mid = left+ (right-left)/2;
			if(key == a[mid]){
				return mid+1;
			}else if(key <a[mid]){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return -1;
	}
}
