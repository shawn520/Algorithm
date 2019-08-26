package others.online.toutiao.test4;

import java.util.*;

/**
 * @author Shawn
 * @date 2019/8/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] a = new int[n][n];
        boolean [] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                a[i][j] = in.nextInt();
            }
            visited[i] = false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(i);
        }
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();
//        int result = find(a, visited, set);
//        System.out.println(result);

    }
}
