package others.online;
import java.util.Scanner;

public class Toutiao1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();//n表示数字个数
		int k = input.nextInt();//k表示差值
		int [] a = new int [n];
		for(int i=0;i<a.length;i++){
			a[i] = input.nextInt();
		}
		int count = solution4(k,a);
		System.out.println(count);

	}
	
//	public static int remove(int [] a, int k){
//		for(int i=k+1;i<a.length;i++){
//			a[i-1] = a[i];
//		}
//	}
	public static void swap(int [] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static int solution4(int k, int [] a){
		
		int count = 0;//统计有多少个差值为2的数字对
		
		int same = 0;
		for(int i=1;i<a.length;i++){
			if(a[0] == a[i])
				same++;
		}
		if(same==a.length - 1)
			return 1;
		
		//去重
		int q=0;//q统计要去掉多少个重复的数
		for(int i=0;i<a.length-1-q;i++){
			for(int j=i+1;j<a.length-1-q;j++){
				if(a[i] == a[j]){
//					remove(a,j);
					swap(a,j,a.length-1-q);
					q++;
				}
			}
		}
		//用新数组代替就数组
		int [] newArray = new int [a.length - q];
		for(int i=0;i<a.length-q;i++){
			newArray[i] = a[i];
		}
		if(newArray.length == 1 && k==0){
			count++;
		}
		
		for(int i=0;i<newArray.length;i++){
			for(int j=i+1;j<newArray.length;j++){
				if(Math.abs(a[i]-a[j]) == 2){
					count++;
				}
					
			}
		}
		return count;
		
	}

}

