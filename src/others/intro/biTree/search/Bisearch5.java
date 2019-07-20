package others.intro.biTree.search;

import java.util.Scanner;

//二分查找的非递归实现
public class Bisearch5 {

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
		if(left<right){
			int mid = left + (right - left)/2;
			if(a[mid] == key){
				return mid+1;
			}else if(key < a[mid]){
				return bisearch(a,key,left,mid-1);
			}else{
				return bisearch(a,key,mid+1,right);
			}
		}
		return -1;
	}
}
