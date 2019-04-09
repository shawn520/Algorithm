package offer.group1.test1;

/**
 * @desciption: 在一个二维数组中（每个一维数组的长度相同）,
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author liuxiao_sx
 * @date 2018/12/24
 * @version 1.0
 */

public class Solution {
    public boolean Find(int target, int [][] array) {
        boolean result = false;
        int column = array[0].length;
        //int length = array.
        int row = array.length;
        if(row < 0 || column < 0){
            return false;
        }
        //init
        int i = row - 1;
        int j = 0;
        while(i>=0 && j< column) {
            if(target == array[i][j]) {
                result = true;
                return result;
            }else if(target > array[i][j]) {
                j++;
            }else {
                i--;
            }
        }
        return result;
    }
}