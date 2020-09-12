package com.github.basic.archived.offer.online.archived.old;

import java.util.Iterator;  
import java.util.Map;  
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;  
import java.util.TreeMap;  
   
public class HuaWei1 {  
  
    public static void main(String[] args) {  
    	
    	//StringBuffer str = new StringBuffer();
    	
    	Scanner in = new Scanner(System.in);
    	String string = in.nextLine();
    /*	boolean flag= true;
    	sentence:
    	while(flag){
    		
    		String s = in.next();
        	
        	char c = s.charAt(0);
        	
        	if(c>'A' && c<'z' || c>'0' && c<'9'){
        		str.append(s);
        	}else if(c=='\r'||c=='\t'){
        		break sentence;
        	}else{
        		return ;
        	}
    	}*/
  
        //String str="eeefgghhh";  
              
        Map map=count(string);  
              
        print(map);  
              
    }  
      
    public static Map count(String string){  
    	
    	//String str = b_string.toString();
          
        char[] buffer=string.toCharArray();  
          
        Map<Character, Integer> map=new TreeMap<Character, Integer>();  
          
        for(Character c:buffer){  
            if(map.containsKey(c)){  
                map.put(c, map.get(c)+1);  
            }else{  
                map.put(c, 1);  
            }             
        }             
        return map;  
    }  
      
    public  static  void print(Map map){  
        //遍历  
        Set entrySet=map.entrySet();  
        Iterator<Entry> it=entrySet.iterator(); 
        int max = 0;
        while(it.hasNext()){
        	Entry entry = it.next();
        	if((int)entry.getValue()>max){
        		max = (int)entry.getValue();
        	}
        }
        for(int j=0;j<max;j++){
        	Iterator<Entry> i=entrySet.iterator();
        	while(i.hasNext()){  
                Entry entry=i.next();
                int value = (int)entry.getValue();
                
                if(value>0){
                	System.out.print(entry.getKey());
                	entry.setValue(--value);
                }
                  
            }   
        }
              
    }  
}  
