package others.intro.sort.quick;

import org.junit.Test;
import others.intro.sort.Sort;

/**
 * @author Shawn
 * @date 2019/6/30
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Test
    public void test() {
        int [] array = {2,8,7,1,3,5,6,4};
        print(array);
        sort(array);
        print(array);
    }

    @Override
    public void sort(int[] nums) {
        quicksort(nums, 0, nums.length-1);
    }

    private void quicksort(int[] array, int p, int r) {
        if(p < r) {
            int q = randomPartition(array, p, r);
            quicksort(array, p, q-1);
            quicksort(array, q+1, r);
        }

    }

    private int randomPartition(int[] a, int p, int r) {
        int random = (int)(Math.floor(Math.random() * r)) ;
        swap(a, r, random);
        return partition(a, p, r);
    }

    private int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for(int j = p; j < r; j++) {
            if(a[j] <= x) {
                i = i + 1;
                swap(a, i, j);
            }
        }
        swap(a, i+1, r);

        return r;
    }

    private void print(int[] array) {
        for(int i=0; i< array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }





}
