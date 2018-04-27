package sort;

import java.util.Arrays;

public class ShellSort2 {

	public static void main(String[] args) {
		Comparable [] a = {34,8,64,51,32,21};
		long startTime = System.nanoTime();
		shellSort(a);
		
		System.out.println(Arrays.toString(a));
		long endTime = System.nanoTime();
		System.out.println("程序运行时间："+ (endTime-startTime) + "ns");
	}

	private static void shellSort(Comparable[] a) {
		// TODO Auto-generated method stub
		
		for(int gap=a.length/2;gap>0;gap/=2){
			for(int i=gap; i<a.length;i++){
				Comparable temp = a[i];
				int j = i;
				
				for(;j>=gap&&temp.compareTo(a[j-gap])<0;j-=gap){
					a[j] = a[j-gap];
				}
				a[j] = temp;
			}
		}
		
	}
}
