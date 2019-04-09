package online;

import java.util.ArrayList;
import java.util.Scanner;

public class Zhaoshang {
	/**
     * Given the number N, return all of the correct brackets.
     * @param n
     * @return
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<String> getBracketsOfN(int n) {
        @SuppressWarnings("rawtypes")
        ArrayList[] dp = new ArrayList[n+1];
        for(int i=0; i<dp.length; i++)
            dp[i] = new ArrayList<String>();
        dp[0].add("");
        dp[1].add("()");
        if(n == 0) 
            return dp[0];
        if(n == 1) 
            return dp[1];
        int count = 2;
        while(count < n+1) {
            ArrayList<String> lcount = dp[count];
            for(int i=0; i<count; i++) {
                ArrayList<String> l1 = dp[i];
                ArrayList<String> l2 = dp[count-i-1];
                for(int j=0; j<l1.size(); j++) {
                    for(int k=0; k<l2.size(); k++) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(l1.get(j));
                        sb.append("(");
                        sb.append(l2.get(k));
                        sb.append(")");
                        lcount.add(sb.toString());
                    }
                }
            }
            dp[count++] = lcount;
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//System.out.println("输入一个正整数：");
		int N = in.nextInt();
		
		ArrayList<String> results = getBracketsOfN(N);
		//System.out.println(results.toString());
//		for(String result:results){
//			System.out.print(result.toString()+",");
//		}
		for(int i=0;i<results.size()-1;i++){
			System.out.print(results.get(i)+",");
		}
		System.out.println(results.get(results.size()-1));

    }
}
