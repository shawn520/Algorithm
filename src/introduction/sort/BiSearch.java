/**
 * 
 */
package introduction.sort;

import java.util.Scanner;

/**
 * @author liush
 * 二分查找：
 * 将要查找的数每次与中间数比较，
 * 如果大于，则递归查找右边
 * 如果小于，则递归查找左边
 */
public class BiSearch {

	/**
	 * @param args
	 * @param key 需要查找的关键字
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int key = in.nextInt();
		int [] a = {1,7,9,11,16,21,25,34};
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
		if(left<right){
			int mid = left + (right - left)/2;
			if(key == a[mid]){
				return mid;
			}else if(key < a[mid]){
				return bisearch(a,key,left,mid-1);
			}else{
				return bisearch(a,key,mid+1,right);
			}
		}		
		return -1;
	}

}
