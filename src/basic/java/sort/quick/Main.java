package basic.java.sort.quick;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2019/8/19
 */
public class Main {

    public static void main(String[] args) {
        int [] array = {3,9,4, 4,6,7};
        sort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void sort(int[] array) {
        quicksort(array, 0, array.length - 1);

    }

    public static void quicksort(int[] array, int p, int r) {
        if(p<r) {
            int q = randomPartition(array, p, r);
            quicksort(array, p, q-1);
            quicksort(array, q+1, r);

        }
    }

    public static int randomPartition(int [] array, int p, int r) {
        int j = p + (int)((r-p) * Math.random());
        swap(array, j, r);
        return partition(array, p, r);
    }

    public static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p -1;
        for(int j = p; j<r; j++) {
            if(array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array,i+1, r);
        return i+1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
