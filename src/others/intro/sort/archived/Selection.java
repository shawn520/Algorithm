package others.intro.sort.archived;

public class Selection {

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
	
	
	public static void sort(Comparable [] a) {
		int N = a.length;
		for(int i=0; i<N; i++){
			int min = i;
			for(int j=i+1; j<N; j++){
				if(less(a[j],a[min])){
					min = j;
				}
			}
			exch(a,i,min);
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
