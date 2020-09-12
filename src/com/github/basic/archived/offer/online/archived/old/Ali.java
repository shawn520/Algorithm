package com.github.basic.archived.offer.online.archived.old;



/*已知有两个长度相等的正整数数组A、B，
其元素分别记为{a(1)，a(2)，a(3)，a(4) ...... a(n) ......}和{b(1)，b(2)，b(3)，b(4) ...... b(n) ......}，
两个数组中任一元素大小不超过10000，数组长度在1000以内，
现在按照以下规则将A数组中的元素插入到B数组中进行合并：

    对于A数组中任一元素可以插入到B数组中任意位置。
    对于A数组中任一元素a(i)，在合并之后的数组中a(i)对应的下标小于a(i+1)对应的下标。（如果a(i+1)存在的话）

问题：
对合并之后的数组中相邻元素两两相乘，然后求其累加值，请给出所有合并可能形成的数组对应累加值的最小值。

以长度为4的两个数组为例：
A：{a1，a2，a3，a4}
B：{b1，b2，b3，b4}
插入完成后的数组可能为：
{a1，a2，b1，b2，b3，b4，a3，a4}、
{b1，a1，b2，b3，a2，a3，b4，a4}等。
其对应的累加值分别对应为
a1*a2 + b1*b2 + b3*b4 + a3*a4、
b1*a1 + b2*b3 + a2*a3 + b4*a4等。
*/

import java.util.*;

public class Ali {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static long min(int[] from, int[] to) {
    	long ans = 0;
    	return ans;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;
            
        int _from_size = 0;
        _from_size = Integer.parseInt(in.nextLine().trim());
        int[] _from = new int[_from_size];
        int _from_item;
        for(int _from_i = 0; _from_i < _from_size; _from_i++) {
            _from_item = Integer.parseInt(in.nextLine().trim());
            _from[_from_i] = _from_item;
        }
        
        int _to_size = 0;
        _to_size = Integer.parseInt(in.nextLine().trim());
        int[] _to = new int[_to_size];
        int _to_item;
        for(int _to_i = 0; _to_i < _to_size; _to_i++) {
            _to_item = Integer.parseInt(in.nextLine().trim());
            _to[_to_i] = _to_item;
        }
  
        res = min(_from, _to);
        System.out.println(String.valueOf(res));  

    }
}
