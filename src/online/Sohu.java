package online;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EachdayGrowthValue{
	int start;
	int end;
	int value;
}

class TaskGrowthValue{
	int day;
	int value;
}

class Sohu{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sumvalue = 0;
		
		//line 表示一共有多少行值
		int line = in.nextInt();
		List<EachdayGrowthValue> eachDayGrowthValues = new ArrayList<>();
		List<TaskGrowthValue> taskGrowthValues = new ArrayList<>();
		
		for(int i=0;i<line;i++){
			
			//输入每行的第一个数
			int number = in.nextInt();
			if(number ==1){
				//添加的是每日成长值规则
				EachdayGrowthValue value = new EachdayGrowthValue();
				value.start = in.nextInt();
				value.end = in.nextInt();
				value.value = in.nextInt();
				eachDayGrowthValues.add(value);
			}else if(number ==2){
				//添加的是任务成长值规则
				TaskGrowthValue value = new TaskGrowthValue();
				value.day = in.nextInt();
				value.value = in.nextInt();
				taskGrowthValues.add(value);
			}else{
				//非法输入
				return ;
			}	
		}
		
		//寻找一共有多少天
		int countday = 0;
		for(EachdayGrowthValue value:eachDayGrowthValues){
			if(value.end>countday){
				countday=value.end;
			}
		}
		//计算总的每日成长值
		for(int i=0;i<countday;i++){
			int max = 0;//其实这里有问题
			for(EachdayGrowthValue value: eachDayGrowthValues){
				if((i>=value.start && i<=value.end &&value.value>max)){
					max = value.value;
				}
			}
			sumvalue += max;	
		}
		//计算任务成长值
		for(TaskGrowthValue value:taskGrowthValues){
			sumvalue += value.value;
		}
		
		System.out.println(sumvalue);
		
		
	}
}
