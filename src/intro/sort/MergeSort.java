/**
 * 
 */
package intro.sort;

import java.util.Arrays;

/**
 * @author liush
 * 归并排序
 * 算法描述：典型的分治算法
 * 1.二分
 * 2.有序归并
 */
public class MergeSort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {3,5,2,7,9,5,8,4};
		System.out.println("排序前数组：");
		//print(array);
		System.out.println(Arrays.toString(array));
		
		sort(array);//排序
		
		System.out.println("排序后数组：");
		//print(array);
		System.out.println(Arrays.toString(array));
	}
	
	//接口
	public static void sort(int [] a){
		int [] temp = new int [a.length];	//在排序前，建立一个等长的临时数组
		int left = 0;
		int right = a.length-1;
		mergesort(a,left,right,temp);//调用归并算法
	}

	//归并算法
	public static void mergesort(int [] a,int left, int right,int [] temp){
		if(left<right){
			int mid = left + (right-left)/2;	
			mergesort(a,left,mid,temp);			//递归，左边归并排序
			mergesort(a,mid+1,right,temp);		//递归，右边归并排序
			merge(a,left,mid,right,temp);		//将子数组合并
		}
		
	}
	
	public static void merge(int [] a,int left, int mid,int right,int [] temp){
		int i = left;					//i表示左序列的指针
		int j = mid + 1;				//j表示有序列指针
		int t = 0;						//t临时数组指针
		while(i<=mid && j<=right){		//将两个数组中最小的数依次插入临时数组
			if(a[i]<=a[j]){
				temp[t++] = a[i++];
			}else{
				temp[t++] = a[j++];
			}	
		}
		while(i<=mid){					//如果左子序列不为空，则将左子序列直接插入临时数组。
			temp[t++] = a[i++];
		}
		while(j<=right){				//如果右子序列不为空，则将右子序列直接插入临时数组。
			temp[t++] = a[j++];
		}
		
		t=0;
		while(left<=right){				//将临时数组中的数复制到原数组中
			a[left++] = temp[t++];
		}
	}
}
