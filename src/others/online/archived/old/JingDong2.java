package others.online.archived.old;

import java.util.Scanner;

public class JingDong2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //输入一个正整数t
        int t = in.nextInt();
        if(t<1 || t>1000){
        	return ;
        }
        int [] a = new int [t];
        for(int i=0;i<t;i++){
        	//给出N
        	a[i] = in.nextInt(); 	
        }
        solution(a,t);
        
    }
    
    public static void solution(int [] a,int t){
    	for(int i=0;i<t;i++){
        	String ans= devide(a[i]);
        	System.out.println(ans);
        }
    }
    public static String devide(int N){
    	String ans = "No";
    	if(N%2 !=0){
    		return ans;
    	}
    	for(int i=2;i<N;i=i+2){
    		if(N%i==0){
    			int X = N/i;
    			if(X%2==0){
    				continue;
    			}else{
    				int Y = i;
    				String s2 = Integer.toString(Y);
    				String s1 = Integer.toString(X);
    				ans = s1+" " + s2;
    				return ans;
    			}
    			
    		}
    	}
    	return ans;
    }
    
}

