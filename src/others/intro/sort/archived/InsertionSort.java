/**
 * 
 */
package others.intro.sort.archived;

import java.util.Arrays;

/**
 * @author liush
 * 
 *插入排序
 *算法描述：
 *数组里面的数分为有序和无序。
 *初始状态下，第一个数默认有序，然后，依次从无序中的数，依次跟有序数比较。
 *如果小于，则后移一位。插入合适的位置。
 *直到所有数有序为止
 *
 *时间复杂度：
 *最好情况：O(n)
 *最坏情况：O(n2)
 *平均情况:O(n2)
 */
public class InsertionSort {

	/**
	 * @param args
	 * @param 
	 */
	
	public static void sort(int [] a){
		for(int j=1;j<a.length;j++){	//j的表示未排序数组的下标
			int key = a[j];		//key用来保存待插入的数
			int i = j-1;		//i跟踪有序数组的下标
			while(i>=0 && key<a[i]){
				a[i+1] = a[i];		//如果，待排序数小于当前的数，则将该数往后挪一位。
				i--;
			}
			a[i+1] = key;
		}
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
		//print(array);
		System.out.println(Arrays.toString(array));
		
		sort(array);//排序
		
		System.out.println("排序后数组：");
		//print(array);
		System.out.println(Arrays.toString(array));
	}

}
