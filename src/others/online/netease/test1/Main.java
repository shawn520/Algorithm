package others.online.netease.test1;

//import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Shawn
 * @date 2019/8/3
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        if(length < 1) {
            return ;
        }
        int [] array = new int[length];
        int i = 0;
        while (i < length) {
            int score = in.nextInt();
            if(score >=0 && score <= 150) {
                array[i] = score;
            } else {
                return;
            }
            i++;
        }

        int times = in.nextInt();
        if(times <=0 || times >=10000) {
            return ;
        }

        int [] query = new int[times];
        int j = 0;
        while (j < times) {
            query[j] = in.nextInt();
            j++;
        }
        if(array.length <length || query.length < times ) {
            return ;
        }

        compute(array, query);
        
    }

    /*@Test
    public void test(){
        int [] a_array = {100, 98, 87};
        int [] query = {1, 2, 3};
        compute(a_array, query);
    }*/

    private static void compute(int[] array, int[] query) {
        int lenghth = array.length;
        int [] copy_array = new int[lenghth];
        for(int i = 0 ; i < lenghth; i ++) {
            copy_array[i] = array[i];
        }
        Arrays.sort(copy_array);
        int times = query.length;
        for(int j = 0; j < times; j++) {
            int index = query[j];
            index--;
            int value = array[index];
            int location = Arrays.binarySearch(copy_array, value);
            double percent = 100.0 * location / lenghth;
            String result = String.format("%.6f", percent);
            System.out.println(result);
        }
    }
}
