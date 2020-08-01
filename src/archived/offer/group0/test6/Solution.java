package archived.offer.group0.test6;

/**
 * 描述:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 分析：
 * 第一印象：从头到尾扫描一遍，时间复杂度O(n)
 *
 *
 *
 * 用二分查找的思路
 */


public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int result = 0;
        if(array.length == 0) {
            return result;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = (right - left) / 2;
        result = findMinNumber(array,left,right);
        return result;

    }

    public int findMinNumber(int [] array,int left,int right) {
        if(left<right){
            int mid = (right + left) / 2;
            if(array[0]<array[mid] && array[mid+1]<array[0]) {
                return array[mid+1];
            }else if(array[mid]>array[0] && array[mid+1] >array[0]) {
                return findMinNumber(array, mid + 1, right);
                //}else if(a_array[mid]<a_array[0] && a_array[mid] >a_array[mid-1]){
            }else {
                return findMinNumber(array,left,mid);
            }
        }else {
            return array[left];
        }

    }

}