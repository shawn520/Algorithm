package intro.sort;

public class Insertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//初始化一个数组
        Comparable [] array = {9,7,2,4,5,3,6,1,0};
        
        Selection ss = new Selection();
        
        sort(array);
        
        //打印排序后的数组
        for (int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
	}
	
	public static void sort(Comparable [] a){
		int N = a.length;
		
		for(int i=1; i<N;i++) {
			for(int j=i; j>0 && less(a[j], a[j-1]);j--){
				exch(a, j, j-1);
			}
		}
	}
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
	}
	
	public static void exch(Comparable [] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
