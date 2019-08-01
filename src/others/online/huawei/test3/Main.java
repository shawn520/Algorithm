package others.online.huawei.test3;

import java.util.Scanner;

/**
 * @author Shawn
 * @date 2019/7/31
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 顶点数
        int N = in.nextInt();
        // 边数
        int M = in.nextInt();

        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}

class Node{
    Node start;
    Node next;
    String name;

    public Node() {

    }
}

class Edge{
    Node start;
    Node end;
    String name;

    public Edge(String name) {
        this.name = name;
    }

}
