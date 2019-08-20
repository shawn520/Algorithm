package leetcode.archived;

import java.util.Scanner;

//二分法查找
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {1,2,3,4,5};
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要查找的数：");
		int key = sc.nextInt();
		int index = search(a,key);
		if(index == -1){
			System.out.println("数组中没有您要找的数"+key);
		}else {
			System.out.println("您要找的数在数组中的索引为"+index);
		}
		
	}
	
	public static int search(int [] array, int key){
		int index = -1;
		
		int left = 0, right = array.length - 1;
		int mid = left + (right - left)/2;//这样不会导致溢出
		while(left<=right){
			mid = (left + right)/2;
			
			if(key == array[mid]){
				index = mid;
				break;
			}else if(key > array[mid]){
				left = mid +1;
			}else{
				right = mid -1;
			}
		}
		return index;
	}

}
