package introduction.sort;

public class QuickSort {
    public void exchange(int [] array, int i, int j)
    {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    //
    public int partition(int [] array, int p, int r)
    {
        int x = array[r-1];
        int i = p-1;
        for(int j=p;j<=r-2;j++)
        {
            if(array[j]<=x)
            {
                i = i + 1;
                exchange(array,i,j);
            }
        }
        exchange(array,i+1,r-1);
        return i+1;
    }
    
    //递归实现快排
    void quicksort(int [] array, int p, int r)
    {
        if(p<r)
        {
            int q = partition(array,p,r);
            quicksort(array,p,q-1);
            quicksort(array,q+1,r-1);
        }
    }

    public static void main(String [] args)
    {
    	//初始化一个数组
        int [] array = {9,7,2,4,5,3,6,1,0};
        
        QuickSort qs = new QuickSort();
        
        qs.quicksort(array,0,array.length);
        
        //打印排序后的数组
        for (int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
    }
}