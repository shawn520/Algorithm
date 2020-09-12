package com.github.demo.basic.java.sort.bubble;


public class BubbleSort1 {
	
	/*	冒泡法排序的思路：
	第一步：从第一位开始，把相邻两位进行比较
	如果发现前面的比后面的大，就把大的数据交换在后面，循环比较完毕后，最后一位就是最大的
	第二步： 再来一次，只不过不用比较最后一位 */
	public static void main(String[] args) {
		
		int a [] = {18, 62, 68, 82, 65, 9};
		
		//排序前数组
		System.out.println("排序前数组:");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		
		//冒泡法排序
		for(int i=a.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		
		//打印冒泡后数组
		System.out.println();
		System.out.println("冒泡排序后的数组:");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}

