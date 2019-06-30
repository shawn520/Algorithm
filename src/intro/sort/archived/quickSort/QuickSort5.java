package intro.sort.archived.quickSort;

import java.util.Arrays;

//快排的随机化版本

public class QuickSort5 {

	public static void main(String[] args) {
		int [] a= {4,18,15,34,26,47,36};
		
		sort(a);
		
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int[] a) {
		// TODO Auto-generated method stub
		randomQuickSort(a,0,a.length-1);
	}

	private static void randomQuickSort(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		if(p<r){
			int length = r - p;
			int random = (int) (p + Math.random() * (r - p));
			exchange(a,random,r);
			int q = partition(a,p,r);
			randomQuickSort(a,p,q-1);
			randomQuickSort(a,q+1,r);
		}
		
		
	}

	private static int partition(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		int x = a[r];
		int i = p - 1;
		for(int j = p;j<r;j++){
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
