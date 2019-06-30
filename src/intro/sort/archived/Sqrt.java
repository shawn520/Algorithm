package intro.sort.archived;

public class Sqrt {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = sqrt(9);
		System.out.println(answer);
	}
	
	//求开方
	public static int sqrt(int x){
		int index = x/2;
		int answer = 0;
		int j ; //j表示平方
		for(int i=1;i<=index;i++){
			j = i*i;
			if(j < x){		//如果小于x,continue
				continue;
			}else if(j == x){
				answer = i;		//如果等于的话，结束循环，返回answer
				break;
			}else {
				answer = i-1;	//大于的话，返回上一个数。
				break;
			}
		}
		/*int left = 1, right = index, mid;
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
		}*/
		return answer;
	}

}
