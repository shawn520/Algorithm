package others.leetcode;
import java.util.Set;
import java.util.TreeSet;



/**
 * @author liush
 * 
 *给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
 *不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
 *
 *示例：
 *给定数组: nums = [1,1,2],
 *你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2
 *不需要理会新的数组长度后面的元素
 *
 *思路：
 *本题关键在于数组不重复，数组按插入顺序排放。
 *
 *第一眼想到的是借助Set实现，因为Set类似于数学中集合的定义，数组中没有重复元素。
 *HashSet实现了Set接口，但HashSet中元素是无序的。
 *可以用LinkedHashSet或TreeHashSet都可以保证集合中没有重复元素，且有序。
 */
class RemoveDuplicates {
	
	public static void main(String[] args) {
		int [] a = {1,1,2,1};
		System.out.println(removeDuplicates(a));
	}
    public static int removeDuplicates(int[] a) {
        Set<Integer> results = new TreeSet<>();
        
        for(int i=0;i<a.length;i++){
        	results.add(a[i]);
        }
        
        int j=0;
        for(Integer i : results){
        	a[j++] = i;
        	
        }
        
        return results.size();
    }
    
    public static void swap(int [] a,int i,int j){
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
}