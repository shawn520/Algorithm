package sort;

import java.util.Arrays;

public class InsertionSort2 {

	public static void main(String[] args) {
		
		Comparable [] a = {34,8,64,51,32,21};
		
		insertionSort(a);
		
		System.out.println(Arrays.toString(a));
	}

	private static void insertionSort(Comparable[] a) {
		// TODO Auto-generated method stub
		
		int j;
		for(int p=1;p<a.length;p++){
			Comparable temp = a[p];
			
			for(j=p;j>0&&temp.compareTo(a[j-1])<0;j--){
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
}
