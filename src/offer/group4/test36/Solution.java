package offer.group4.test36;

import org.junit.Test;

/**
 * 数组中的逆序对
 * 思路：用交换类排序方法。
 * 比如冒泡排序，记录下交换的次数。但是冒泡排序的时间复杂度O(n^2),太慢
 * 用空间换时间的方式，比如归并排序(分治)，记录交换的次数。时间复杂度nlgn
 *
 * 注意大数问题，每次加之后校验一下，对1000000007取模
 *
 * @author Shawn
 * @date 2019/7/22
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
        int [] array = {1,2,3,4,5,6,7,0};

        // 边界测试
//        int [] array = {};

        int result = InversePairs(array);
        System.out.println(result);
    }

    public int InversePairs(int [] array) {
        // 冒泡排序时间复杂度O(n^2).时间复杂度太高
        //return bubble_sort(array)%1000000007;
        int count = 0;
        if(null == array || array.length ==0) {
            return count;
        }
        int p = 0;
        int r = array.length -1;
        return merge_sort(array, p, r, 0);
    }

    public int merge_sort(int [] array, int p, int r, int count) {
        if(p<r) {
            int q = p + (r - p)/2;
            count = merge_sort(array, p, q, count);
            count = merge_sort(array, q+1, r, count);
            count = merge(array, p, q, r,count);
        }
        return count;

    }

    private int merge(int[] array, int p, int q, int r, int count) {
        int n1 = q-p+1;
        int n2 = r-q;
        int [] left = new int[n1];
        int [] right = new int[n2];
        for(int i = 0; i < n1; i++) {
            left[i] = array[p+i];
        }

        for(int j = 0; j < n2; j++) {
            right[j] = array[q+1+j];
        }
        int i = 0;
        int j = 0;
        int k = p;
        for(; k <= r && i < n1 && j <n2; k++) {
            if(left[i] <= right[j]) {
                array[k] = left[i++];
            } else {
                array[k] = right[j++];
                // 类加交换次数，这里可以举个例子为什么公式是这样，帮助理解
                count = count + n1 - i;
                // 数值过大求余
                if(count>=1000000007)
                {
                    count%=1000000007;
                }
            }
        }

        while(i < n1) {
            array[k++] = left[i++];
        }
        while (j < n2) {
            array[k++] = right[j++];
        }
        return  count;

    }

}
