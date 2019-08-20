package leetcode.archived;

class TwoSum {
	
	
    public static int[] twoSum(int[] nums, int target) {
    	/*Given an array of integers, 
    	return indices of the two numbers such that they add up to a specific target.
    	You may assume that each input would have exactly one solution, 
    	and you may not use the same element twice.*/
    	int [] a = new int [2];//定义一个数组长度为2的数组a,用于返回位置信息
    	a[0] = -1;
    	a[1] = -1;
    	
    	//寻找索引，成功则结束循环
    	outloop://标记外部循环，用于成功寻找索引，结束外部循环
    	for(int i=0;i<nums.length;i++){
    		for(int j=i+1;j<nums.length;j++){
    			if(nums[i]+nums[j] == target){
    				a[0] = i;
    				a[1] = j;
    				break outloop;
    			}
    		}
    	}
    	return a;
        
    }
    
    public static void main(String[] args) {
		int nums [] = {2, 7, 11, 15};
		int target = 9;
		int [] array = new int [2];
		System.arraycopy(twoSum(nums,target), 0, array, 0, 2);
		for (int each:array){
			System.out.println(each);
		}
	}
}