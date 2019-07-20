package others.intro.biTree.search;

import java.util.Scanner;


/**
 * @author liush
 * 二分查找的非递归实现
 */
public class biSearch3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int key = in.nextInt();
		int [] a = {1,9,11,15,18,24,26,30};
		
		System.out.println(search(a,key));;
	}

	private static int search(int[] a, int key) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = a.length - 1;
		return bisearch(a,key,left,right);
	}

	private static int bisearch(int[] a, int key, int left, int right) {
		// TODO Auto-generated method stub
		
		while(left<right){
			int mid = left + (right - left)/ 2;
			if(key == a[mid]){
				return mid + 1;
			}else if(key < a[mid]){
				right = mid - 1;
			}else{
				left = mid + 1;
			}	
		}
		return -1;
	}
}
