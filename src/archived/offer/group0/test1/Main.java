package archived.offer.group0.test1;

public class Main {
    public static void main(String [] args) throws ClassNotFoundException {
        int [][] array = new int[][] {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Solution solution = new Solution();
        Boolean result = solution.Find(7,array);
        System.out.println(result);
    }
}
