package leetcode.archived;

class Solution11 {
    public static int maxArea(int[] height) {
        int max = 0;
/*        for(int i=0;i<height.length;i++){
        	for(int j=0;j<height.length;j++){
        		int area = min(height[i],height[j]) *(j-i);
        		if(area>max)
        			max = area;
        	}
        }*/
        int area = 0;
/*        for(int i=0;i<height.length;i++){
        	int j = maxDistance(i,height);
        	if(height[j]>=height[i]){
        		area = min(height[i],height[j])*(j-i); 
        	}
        	if(max<area){
        		max = area;
        	}
        }*/
        for(int i=0,j=height.length-1;i<=j;){
        	area = min(height[i],height[j])*(j-i); 
        	if(max<area){
        		max = area;
        	}
        	if(height[i]<height[j]){
        		i++;
        	}else{
        		j--;
        	}
        } 
        return max;
    }
    public static int min(int i,int j){
    	if(i<=j)
    		return i;
    	else 
    		return j;
    }
    
    //返回距离i最远的位置
    public static int maxDistance(int i,int [] a){
    	if(i>a.length-1-i){
    		return 0;
    	}else{
    		return a.length - 1;
    	}
    }
    
    
    public static void main(String[] args) {
		int [] a = {3,4,5,7,9,5};
		int max = maxArea(a);
		System.out.println(max);
	}   
}

