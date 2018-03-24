package introduction.sort;

import java.util.Scanner;

public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();//n表示数字个数
		int k = input.nextInt();//k表示差值
		

	}
	
	public static void remove(int [] a, int k){
		for(int i=k+1;i<a.length;i++){
			a[i-1] = a[i];
		}
	}
	
	public static void solution(int k, int [] a){
		
		//去重
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i] == a[j]){
					remove(a,j);
				}
			}
		}
		
		//用新数组代替就数组
		for(i=0;i<a.length&& a[i] != null;i++){
			
		}
		
	}

}
