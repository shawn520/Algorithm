package intro.sort;

public class BarrelSort {

	//桶排序
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {8, 5 ,5,3,2};
		int [] array = new int [11];
		
		//初始化数组array
		for(int i=0;i<array.length;i++){
			array[i] = 0;
		}
		
		for(int i=0;i<a.length;i++){
			array[a[i]]++;
		}
		
		for(int i=0;i<array.length;i++){
			for(int j=array[i];j>0;j--){
				System.out.print(i+"\t");
			}			
		}
	}

}
