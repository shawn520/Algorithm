/**
 * 
 */
package others.intro.sort.archived;

/**
 * @author liush
 * 冒泡排序算法
 * 算法描述：设为从小到大排序
 * 1.从第一个数起，依次与相邻元素比较，如果大于后一个元素，则交换，这样，一轮下来，
 * 最大的数就置换到最后的位置了。
 * 2.重复以上过程，直到所有元素有序为止。
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	

	public static void sort(int [] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j] > a[j+1]){
					swap(a,j,j+1);
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
		print(array);
		
		sort(array);//排序
		
		System.out.println("排序后数组：");
		print(array);
		

	}

}
