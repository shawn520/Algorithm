package intro.sort.archived;

public class InsertionSort1 {

	public void sort(int [] a){
		int i,j;
		int N = a.length;
		for(j=1; j<N; j++){
			int key = a[j];
			//insert a[j] into the sorted a[1,..,j-1];
			i = j - 1;
			while(i>=0 && a[i] >key){
				
				a[i+1] = a[i];
				i = i -1;
			}
			a[i+1] = key;
		}
	}
}
