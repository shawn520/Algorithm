/**
 * 
 */
package others.intro.sort.archived;

import java.util.Arrays;

/**
 * @author liush
 * @version 1.0
 * 希尔排序
 * 算法描述：
 * 1.
 */
public class ShellSort {

	/**
	 * 在插入时，采用交换法
	 * @param args
	 */
	
	public static void sort(int [] a){
		
		//增量gap,并逐步缩小增量
		for(int gap=a.length/2;gap>0;gap=gap/2){
			
			//从第gap个元素起，逐个对其所在的组进行插入排序操作
			for(int i = gap;i<a.length;i++){
				
				int j=i;
				while(j-gap>=0 && a[j]<=a[j-gap]){
					
					//插入排序操作
					swap(a,j,j-gap);
					j = j - gap;
				}
			}
		}
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
		System.out.println(Arrays.toString(array));
		
		sort(array);//排序
		
		System.out.println("排序后数组：");
		System.out.println(Arrays.toString(array));
		

	}

}
