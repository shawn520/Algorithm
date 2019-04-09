package online;

import java.util.Scanner;
import java.util.Stack;

public class JingDong3 {
    public static void main(String[] args) {
        
    	Scanner in = new Scanner(System.in);
        //输入一个正整数t
        int t = in.nextInt();
        if(t<1 || t>1000){
        	return ;
        }
        
        solution(t);
    }

	private static void solution(int t) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		char c1 ='(';
		char c2 =')';
		
		for(int i=0;i<t;i++){
			int num=0;
			String s = in.next();
			
			for(int j=0;i<s.length();i++){
				char c = s.charAt(i);
				
				//如果是'('入栈
				if(c==c1){
					stack.push(c);
				}else if(c==c2){
					
					//如果是')'且栈不为空，则出栈
					if(!stack.isEmpty()){
						stack.pop();
					}else{
						num++;
					}
				}else{
					
					//非法输入
					return ;	
				}
			}
			if((num==0 && stack.isEmpty()) || (num==1 && stack.size()==1)){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
		
	}
    
   
}


