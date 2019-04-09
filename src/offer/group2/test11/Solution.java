package offer.group2.test11;



/**
 * 描述:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {

    public void test() {
        int result =NumberOf1(7);
        System.out.println(result);
    }

    public int NumberOf1(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /*public int NumberOf1(int n) {

        int count =0;

        int left = 0;
        int right = 32;

        while( n>0 ) {

            int mid = (left + right) / 2;

            if(left<=right) {
                if(Math.abs(n - Math.pow(2,mid)) <1) {
                    n = n - n;
                    count++;
                }else if(n - Math.pow(2,mid) > 0) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            } else {
                left = left -1;
                n = (int)(n - Math.pow(2, left));
                count++;
                left = 0;
                right = right - 1;
            }
        }


        return count;

    }*/
}
