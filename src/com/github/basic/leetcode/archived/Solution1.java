package com.github.basic.leetcode.archived;

public class Solution1 {
/*	题目描述
	在一个二维数组中，每一行都按照从左到右递增的顺序排序，
	每一列都按照从上到下递增的顺序排序。
	请完成一个函数，
	输入这样的一个二维数组和一个整数，
	判断数组中是否含有该整数。*/

	//思路：从左下角开始比对，如果target小，则往上，如果target大，则往右。
	
	public boolean findKey(int key, int [][] array){
		boolean find = false;
		int row = array.length;		//获取数组的行数
		int col = array[0].length;	//获取数组的列数
		for(int i = row-1, j = 0; i>=0 && j < col; ){
			if(array[i][j] < key){
				j++;
			}else if(array[i][j] == key){
				find = true;
				break;
			}else {
				i--;
			}
		}
		return find;
	}
}
