package intro.biTree.search;

import java.util.Scanner;

/**
 * @author liush
 * 二分查找的非递归实现
 */
public class BiSearch2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int key = in.nextInt();
		int [] a = {1,7,9,11,16,21,25,34};
		System.out.println(search(a,key));;
	}

	private static int search(int[] a, int key) {
		// TODO Auto-generated method stub
		return bisearch(a,key,0,a.length-1);
		
	}

	private static int bisearch(int[] a, int key, int left, int right) {
		// TODO Auto-generated method stub
		int mid;
		while(left<right){
			mid = left + (right-left)/2;
			if(key == a[mid]){
				return mid+1;
			}else if(key < a[mid]){
				right = mid-1;
			}else{
				left = mid+1;
			}
		}
		return -1;
	}
}
