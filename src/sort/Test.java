package sort;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a [] = {18, 62, 68, 82, 65, 9};
		
		//打印排序前数组
		PrintArray print = new PrintArray();
		print.beforeSort(a);
		
		//调用排序算法
		new InsertionSort().sort(a);
		
		//打印排序后数组
		print.afterSorted(a);
	}

}
