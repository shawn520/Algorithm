package com.github.demo.basic.java.sort.archived.quick;

//快排的随机划分

import java.util.Arrays;

public class QuickSort4 {

	public static void main(String[] args) {
		int [] a = {9,5,18,29,25,46,35};
		
		sort(a);
		
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int[] a) {
		// TODO Auto-generated method stub
		quicksort(a,0,a.length-1);
	}

	private static void quicksort(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		if(p<r){
			int q = partition(a,p,r);
			quicksort(a,p,q-1);
			quicksort(a,q+1,r);
		}
		
	}

	private static int partition(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		int x = a[r];
		int i = p-1;
		
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
