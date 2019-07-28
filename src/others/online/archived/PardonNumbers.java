package others.online.archived;

//题目描述

/*在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。
请找出数组中任意一个重复的数字。
例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，
那么对应的输出是第一个重复的数字 2。*/

public class PardonNumbers {

	public static void pardonNum(int [] a){
		int n = a.length;
		label:
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(a[i] == a[j]){
					System.out.println(a[i]);
					break label;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		int [] array = {2,3,1,0,2,5,3};
		pardonNum(array);
	}
}
