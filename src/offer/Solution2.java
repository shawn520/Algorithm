package offer;

public class Solution2 {
	
	//替换空格
	//请实现一个函数，将一个字符串中的空格替换成“%20”。
	//例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    public String replaceSpace(StringBuffer str) {
    	if(str == null){
    		return null;
    	}
    	StringBuffer newString = new StringBuffer();
    	for(int i = 0; i < str.length(); i++){
    		if(str.charAt(i) == ' '){
    			newString.append("%20");
    		}else{
    			newString.append(str.charAt(i));
    		}
    	}
    	
    	return newString.toString();  	
    }
}