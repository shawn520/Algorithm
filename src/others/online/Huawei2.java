package others.online;
//2018.4.10华为在线编程第二题，通过率100，主要考察贪心算法。
import java.util.Scanner;

public class Huawei2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//输入有多少个数
		int n = in.nextInt();
		
		//定义一个长度为n的数组array
		int [] array = new int[n];
		
		//输入，给数组a赋值
		for (int i = 0; i < n; i++) {
			
			array[i] = in.nextInt();
		}

		int index = 0;	//记录吓一跳需要跳的距离
		int result;
		int maxStepLength;	//每次能最远跳多远
		
		int number = 0;	//统计一共需要跳多少次
		
		int j = 1;
		int max = -1;	//每次最优怎么跳
		
		boolean flag = false;
		
		for (int i = 0; i < n;) {
			
			//取数组中第i个数
			maxStepLength = array[i];	//每一跳最多跳多少步
			
			//测试看条多少步
			for (int k = 0; k < maxStepLength; k++) {
				
				
				if (j <= maxStepLength) {
					
					if (i + j >= n - 1) {
						
						//如果大于n-1则到达
						flag = true;
						break;
					}

					result = array[i + j] + j;
					
					if (result > max) {	//如果结果比max更优，则替换
						
						max = result;
						index = j;
					}

				}
				j++;

			}
			
			number++;//跳的次数自增
			//System.out.println(array[i]);
			
			i = i + index;		//跳到下一跳
			max = -1;		//
			j = 1;
			
			if (flag)	//如果到达，则退出最外层for循环
				break;
		}
		System.out.println(number);
	}
}

