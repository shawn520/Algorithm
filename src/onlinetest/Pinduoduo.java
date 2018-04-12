package onlinetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author liush
 * 题目描述：
 */
public class Pinduoduo {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();	//输入一共有多少组数据，用n表示
		int k = in.nextInt();	//k表示出现的次数最少为多少
		int [] a = new int [n];	//数组a存放低温数据
		int [] b = new int [n];	//高温b存放高温数据
		int [] c = new int [100]; //数组c存放对应的温度出现的次数
		
		for(int i=0;i<n;i++){
			a[i] = in.nextInt();	//收集数据
			b[i] = in.nextInt();
			
			for(int j=a[i];j<=b[i];j++){	//将低温到高温范围内数据出现的次数记录在c中
				c[j+50]++;
			}
		}
		System.out.println(min(c,k)-50);
		System.out.println(max(c,k)-50);
	}
	
	//求满足k的最低温度
	public static int min(int [] c,int k){	
		int Tmin = 0;
		for(int i=0;i<100;i++){
			if(c[i]>=k){
				return i;
			}
		}
		return Tmin;
	}
	
	//求满足k的最高温度
	public static int max(int [] c,int k){
		int Tmax = 0;
		for(int i=99;i>=0;i--){
			if(c[i]>=k){
				return i;
			}
		}
		return Tmax;
	}
}

