package archived.offer.group5.test51;

import org.junit.Test;

/**
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 *
 * 思路：
 * B[i] = 左边乘以右边
 *
 * @author Shawn
 * @date 2019/7/31
 */
public class Solution {

    @Test
    public void test() {
        int [] A = {1,3,5,2};
        int [] B = multiply(A);
        System.out.println(B);
    }

    public int[] multiply(int[] A) {
        int length = A.length;
        int [] B = new int[length];
        int [] C = new int[length];
        int [] D = new int[length];
        if(null == A || length < 1) {
            return B;
        }

        C[0] = 1;
        for(int i=1; i< length; i++) {
            C[i] = A[i-1] * C[i-1];

        }
        D[length-1] = 1;
        for(int j=length-2; j>=0; j--) {
            D[j] = A[j+1] * D[j+1];
        }

        for(int k=0; k<length;k++) {
            B[k] = C[k] * D[k];
        }

        return B;

    }
}
