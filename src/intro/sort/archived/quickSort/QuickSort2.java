package intro.sort.archived.quickSort;

import java.util.Arrays;


/**
 * @author liush
 * 快速排序的递归实现：
 * partition的选取方法，随机数方法
 * 选取随机数做partition的方法只需在选取右端点做partition的基础上，做少量的改动就可以了
 */
public class QuickSort2 {

	public static void main(String[] args) {
		int [] a = {8,7,6,3,4,5};
		System.out.println("排序前"+Arrays.toString(a));
		sort(a);
		System.out.println("排序后"+Arrays.toString(a));
	}

	private static void sort(int[] a) {
		// TODO Auto-generated method stub
		quicksort(a,0,a.length-1);
	}

	private static void quicksort(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		//首先要判断p是否小于r,小于才能继续往下执行
		if(p<r){
			int q = partition(a,p,r);
			quicksort(a,p,q-1);
			quicksort(a,q+1,r);
		}
		
		
	}

	private static int partition(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		int index = (int)(p + Math.random() * (r-p));
		exchange(a,index,r);
		int x = a[r];
		int i = p - 1;
		for(int j=p;j<r;j++){
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
