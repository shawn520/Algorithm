package introduction.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution3 {

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
		//List<Integer> pardon = new ArrayList<>();
		HashSet map;
		//去重
		for(int i=0;i<a.length;i++){
			map.add(a[i]);
		}
		
		int [] b;
		b.length = map.size();
		int i=0;
		
		
		//用新数组代替就数组
		for(i=0;i<a.length&& a[i] != null;i++){
			
		}
		
	}

}
