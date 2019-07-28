package others.online.archived;

import java.util.Scanner;

public class Toutiao2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = "a";
		String m = s;
		System.out.println("请输入需要的到字符串s长度");
		int n = input.nextInt();
		System.out.println(3);
	}
	
	public void method1(String m,String s){
		m = s;
		s = s.concat(s);
	}
	
	public void method2(String m,String s){
		s = s.concat(m);
	}
	
	public void solution(String m,String s){
/*		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				
			}
				
		}*/
	}
}

