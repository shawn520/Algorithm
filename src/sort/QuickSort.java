/**
 * 
 */
package sort;

/**
 * @author liush
 * 快速排序：
 * 1.找基准点，设值为x
 * 2.基准点左边的数小于x,右边的数大于x
 * 3.递归调用以上过程，直到数组有序。
 * 
 * 时间复杂度：
 * 最好情况：O(nlgn)
 * 最坏情况：O(n2) ， 在数组有序的情况下。
 * 期望：接近最好情况
 * 
 *
 */
public class QuickSort {
	
	//找基准点，使基准点左边的数小于x，右边的数大于x.
	public static int partition(int [] a, int p, int r){
		int x = a[r];	//每次取待排序数组最右边的数为基准点，用x保存该值
		int i = p-1;	//a[p..i]保存小于x的部分，a[i+1..j]保存大于x的部分，a[j+1..r]为未处理部分。
		for(int j=p;j<r-1;j++){	//注意：j从p开始
			if(a[j]<x){			//如果a[j]的值小于基准点的值
				i++;
				swap(a,i,j);
			}
		}
		swap(a,i+1,r);		//将基准点保存到合适的位置
		return i+1;			//返回基准点的位置
	}
	
	//快速排序
	public static void quicksort(int [] a, int p,int r){
		if(p<r){
			int q = partition(a,p,r);	//q为基准点
			quicksort(a,p,q-1);			//递归调用快排使基准点左边的数有序
			quicksort(a,q+1,r);			//使基准点右边有序
			
		}
	}
	
	//接口，便于测试。
	public static void sort(int [] a){
		quicksort(a,0,a.length-1);
	}

	
	
	//交换
	public static void swap(int [] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void print(int [] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {3,5,2,7,9,5,8,4};
		System.out.println("排序前数组：");
		print(array);
		
		sort(array);//排序
		
		System.out.println("排序后数组：");
		print(array);
		

	}
}
