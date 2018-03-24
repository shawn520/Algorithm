package introduction.sort.util;

public class PrintArray {
	public void beforeSort(int [] a){
		
		//打印排序前数组
		System.out.println("排序前数组:");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

	public void afterSorted(int [] a){
		//输出排序后数组
		System.out.println("排序后数组:");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}
