package basic.java.sort.select;

/**
 * @author liush
 *选择排序
 *时间复杂度：任何时候都为O(n2)
 *算法实现：
 *将数组中元素分为有序和无序
 *初始化时，整个数组无序，每次从无序数组中选择最小的数，插入到有序数组中。
 */
public class SelectionSort {
	
	public static void sort(int [] a){
		for(int i=0;i<a.length;i++){
			int minIndex = i;
			for(int j=i;j<a.length;j++){
				if(a[j]< a[minIndex]){
					minIndex = j;
				}
			}
			swap(a,i,minIndex);
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
		print(array);
		
		sort(array);//排序
		
		System.out.println("排序后数组：");
		print(array);
		

	}

}
