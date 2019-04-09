package intro.sort.quickSort;

public class Main {
    public static void main(String [] args) {

        int [] array = {3,5,1,4,2,8,6,7};
        QuickSort quickSort = new QuickSort();
        int [] sortedArray = quickSort.sort(array);
        for (int number: sortedArray) {
            System.out.printf(number +" ");
        }
        System.out.println();
    }
}
