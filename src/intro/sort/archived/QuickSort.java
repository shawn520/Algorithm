/**
 * 
 */
package intro.sort.archived;

/**
 * @author liush
 * @version 2.0
 * @2018/3/19
 * 快速排序的随机化版本：
 * 随机化版本对于快排的1.0版本改动非常小
 * 快排中用到的思想：分治法。
 * 1.从数组中选取随机数作为基准点，设值为x
 * 2.基准点左边的数小于x,右边的数大于x
 * 3.递归调用以上过程，直到数组有序。
 * 
 * 时间复杂度：
 * 最好情况：O(nlgn)
 * 最坏情况：O(n2) ， 在数组有序的情况下。
 * 期望：接近最好情况
 */

//2018/4/2
public class QuickSort{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {3,5,2,7,9,5,8,4};
		System.out.println("排序前数组：");
		print(array);
		
		sort(array);//排序
		
		System.out.println("排序后数组：");
		print(array);
		

	}
	public static void sort(int [] a){
		randomQuickSort(a,0,a.length-1);
	}
	//随机化版本，对于快排的改动非常小。只是在新划分的程序中，进行一次交换
	public static void randomQuickSort(int [] a,int p,int r){
		if(p<r){
			int q = randomPartition(a,p,r);
			randomQuickSort(a,p,q-1);
			randomQuickSort(a,q+1,r);
		}
		
	}
	public static int randomPartition(int [] a, int p,int r){
		int k = random(a,p,r);
		exchange(a,k,r);
		int x = a[r];	//选取右边的数作为基准，记为x
		int i = p-1;	//a[p..i]中的数小于x
			//a[i+1..j-1]中的数大于x
		for(int j = p; j<r;j++){
			if(a[j]<x){
				i = i + 1;
				exchange(a,i,j);
			}
		}
		exchange(a,i+1,r);
		return i+1;
	}
	private static int random(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		int length = p - r;
		int i = p + (int)(Math.random()) * length;	//产生一个p..r之间的随机数
		return i;
	}
	public static void exchange(int [] a,int i,int j){
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
}

/*public class QuickSort {
	//@version 1.0
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
*/