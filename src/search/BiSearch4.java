package search;

import java.util.Scanner;

public class BiSearch4 {

	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		int [] a = {4,5,9,11,16,21};
		int key = in.nextInt();
		System.out.println(search(a,key));
	}

	private static int search(int[] a, int key) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = a.length - 1;
		return biSearch(a,key,left,right);
	}

	private static int biSearch(int[] a, int key, int left, int right) {
		// TODO Auto-generated method stub
		int mid = left + (right - left)/2;
		if(left<right) {
			if(key == a[mid]) {
				return mid+1;
			}else if(key < a[mid]) {
				return biSearch(a,key,left,mid-1);
			}else {
				return biSearch(a,key,mid+1,right);
			}
		}
		return -1;
		
	}
}
