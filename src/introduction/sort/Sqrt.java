package introduction.sort;

public class Sqrt {

	//求开方
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static int sqrt(int x){
		int index = x/2;
		int left = 1, right = index, mid;
		while(left<right){
			
			mid = left + (right - left) / 2;
			int value = mid * mid;
			int answer = -1;
			if(value == x){
				answer = mid;
			}
			else if(value < x){
				left = mid + 1;
			} else{
				right = mid - 1;
			}	
		}
		return answer;
	}

}
