package offer.group0.test2;

/**
 * @description:
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 要求:空间复杂度和时间复杂度不超过O(n)
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {

        if(null == str) {
            return null;
        }

        //首先遍历一次,记录下空格的个数
        int spaceNumber = 0;
        int oldLength = str.length();
        for(int i=0;i<oldLength;i++) {
            if(' ' == str.charAt(i)) {
                spaceNumber++;
            }
        }

        int newLength = oldLength + 2 * spaceNumber;
        str.setLength(newLength);       //设置新的字符串buffer的长度


        for(int i=oldLength-1,j=newLength-1;i!=j || i>=0 || j>=0; i--) {
            if(' ' == str.charAt(i)) {

                str.setCharAt(j--,'0');
                str.setCharAt(j--,'2');
                str.setCharAt(j--,'%');
            }else {
                str.setCharAt(j--,str.charAt(i));
            }
        }
        return str.toString();
    }
}
