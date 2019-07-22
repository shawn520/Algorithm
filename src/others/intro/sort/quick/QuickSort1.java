package others.intro.sort.quick;

import java.util.Arrays;

public class QuickSort1{
	public static void main(String[] args) {
		int [] a = {3,5,8,4,7,6,2};
		
		System.out.println("排序前的数组："+Arrays.toString(a));
		
		sort(a);//排序
		
		System.out.println("排序后的数组："+Arrays.toString(a));
	}

	private static void sort(int[] a) {
		// TODO Auto-generated method stub
		quicksort(a,0,a.length-1);
		
	}

	private static void quicksort(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		if(p>=r)
			return ;
		int q = partition(a,p,r);
		quicksort(a,p,q-1);
		quicksort(a,q+1,r);
	}

	private static int partition(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		int x = a[r];
		int i=p-1;
		int j=p;
		for(j=p;j<r;j++){
			if(a[j]<x){
				i++;
				exchange(a,i,j);
			}
		}
		exchange(a,i+1,r);
		return i+1;
	}

	private static void exchange(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}