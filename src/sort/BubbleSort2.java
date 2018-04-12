package sort;

import java.util.Arrays;

public class BubbleSort2 {

	public static void main(String[] args) {
		int [] a = {7,8,6,5,4};
		sort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int[] a) {
		// TODO Auto-generated method stub
		int N = a.length - 1;
//		if(a == null || a.length ==0||a.length ==1){
//			return ;
//		}
		
		for(int i=0;i>=N;i++){
			for(int j=0;j<N-i;j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		
	}
	
}
