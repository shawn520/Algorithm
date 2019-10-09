package leetcode.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2019/8/27
 */
public class Main {

    @Test
    public  void test() {
        int n = 5;
        int m = 7;
        int [][] a = new int[][] {{1,2,5},{1,3,13},{2,3,4},{3,4,9},{1,4,10},{5,2,6},{1,5,12} };

        int [][] b = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                b[i][j] = 100000;
            }
        }

        for(int [] c : a) {
            int i = c[0]-1;
            int j = c[1]-1;
            b[i][j] = c[2];
        }


        /*boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            visited[i] = false;
        }*/

        int [] ans = new int [n];
        for(int i=0; i<n; i++) {
            ans[i] = find(b, 0, i);
        }
        System.out.print(Arrays.toString(ans));
    }

    private int find(int[][] b, int p, int q) {
        int n = b[0].length;
        int ans = b[p][q];
        for(int i=0; i<n; i++) {
            int max = Math.max(b[p][i], b[i][q]);
            if(max < ans) ans = max;
        }
        String a = new String();
        return ans;

    }

}
