package intro.sort.archived.quickSort;

public class QuickSort {
    public int [] sort (int [] array) {

        int length = array.length;
        int left = 0;
        int right = array.length -1;


        return quickSort(array,left,right);
    }

    public int [] quickSort(int [] array, int left, int right) {
        if(left<right) {
            int mid = partition(array,left,right);
            quickSort(array,left,mid-1);
            quickSort(array,mid+1,right);
        }
        return array;
    }

    private int partition(int[] array, int left, int right) {
        int mid = (right -left)/2;
        int i=left,j=right;
        for(;i<j;) {
            if(array[i]<=array[mid]) {
                i++;
            }else if(array[j]>array[mid]){
                j--;
            }else {
                swap(array,i,j);
                i++;
                j--;
            }
        }
        return i;

    }

    private void swap(int [] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
