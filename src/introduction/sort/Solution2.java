package introduction.sort;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void solve(int k, int [] a){
		
		//第一步，用数组b给a去重
		LinkedList b = new LinkedList<>();
		for(int i=0; i<a.length;i++){
			b.add(a[i]);
		}
		
		//去重
		HashSet<LinkedList> map;
		while(b.iterator()){
			map.add(b);
		}
		
	}

}
