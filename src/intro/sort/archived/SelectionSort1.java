package intro.sort.archived;

public class SelectionSort1 {
	/*选择法排序的思路：
	把第一位和其他所有的进行比较，只要比第一位小的，就换到第一个位置来
	比较完后，第一位就是最小的
	然后再从第二位和剩余的其他所有进行比较，只要比第二位小，就换到第二个位置来
	比较完后，第二位就是第二小的*/
	public static void selection_sort(int [] a){
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[i]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	//打印数组
	public static void print(int [] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		//使用随机数初始化数组
		int [] array = new int [5];		
		for(int i=0;i<array.length;i++){
			array[i] = (int)(Math.random()*100);
		}
		
		//打印排序前数组
		System.out.println("排序前数组:");
		print(array);
		
		selection_sort(array);
		
		//打印排序前数组	
		System.out.println("排序后数组:");
		print(array);
	}
}
