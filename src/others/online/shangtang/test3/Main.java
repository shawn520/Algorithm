package others.online.shangtang.test3;

/**
 * @author Shawn
 * @date 2019/8/19
 */
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();

        String D = in.nextLine();
        D = in.nextLine();
        String [] input = D.split(" ");
        for(int i = 0; i<input.length; i++) {
            char [] chars = input[i].toCharArray();
            Arrays.sort(chars);
            input[i] = String.valueOf(chars);
        }

        String [] T = new String[q];
        for(int i=0; i< q; i++) {
            T[i] = in.nextLine();
        }
        
        int [] result = new int[q];
        for(int i = 0; i<q; i++) {
            result[i] = query(input, T[i]);
        }
        for(int i=0; i< result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int query(String[] input, String str) {
        char [] chars = str.toCharArray();
        Arrays.sort(chars);
        str = String.valueOf(chars);
        int count = 0;
        for(int i=0; i< input.length; i++) {
            if(input[i].equals(str)){
                count++;
            }
        }
        return count;
    }
}
