package others.online.toutiao.test1;

import java.util.*;

/**
 * @author Shawn
 * @date 2019/8/25
 */
/*public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] a = new int[n][n];
        boolean [][] visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                a[i][j] = in.nextInt();
                visited[i][j] = false;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(i);
        }
        int result = find(a, visited, set);
        System.out.println(result);

    }

    private static int find(int[][] a, boolean[][] visited, Set<Integer> set) {
        Queue<Integer> queue = new LinkedList<>();
//        queue.add(k);
        int n = a.length;
        while (!queue.isEmpty()) {
            int q = queue.remove();
            for(int i=0; i<n; i++) {
                if(a[q][i] > 3) {
                    queue.add(i);
                    set.remove(i);
                }
            }
        }
        return 2;

    }
}*/
