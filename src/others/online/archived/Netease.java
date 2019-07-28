/**
 * 
 */
package others.online.archived;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liush
 *
 */

class Friend{
	int id;
	int power; //能力值
	
	public Friend(int id, int power){
		this.id = id;
		this.power = power;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}

class Work{
	int id;
	int power;	//需要的能力值
	int salary;	//薪水
	public Work(int id,int power,int salary){
		this.id = id;
		this.power = power;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}

public class Netease {

	/**
	 * @param N 工作数
	 * @param M 小伙伴数
	 * @param Di 工作难度
	 * @param Pi 报酬
	 * @param Ai 小伙伴能力值
	 */
	public static List<Work> findJob(List<Work> works,int N,List<Friend> friends,int M){
		List<Work> bestWorks = new ArrayList<>();	//最匹配的工作
		
		
		//给每位小伙伴找所有能力范围内的工作
		for(Friend friend :friends){	
			List<Work> usefulWorks = new ArrayList<>();
			for(Work work:works){
				if(friend.getPower()>=work.getPower()){
					usefulWorks.add(work);
				}
			}

			Work bestWork = null;
			
			for(Work work:usefulWorks){	//在可用的工作中寻找最好的工作
				
				int salary = 0;
				if(work.salary>salary){
					salary = work.salary;
					bestWork = work;
				}	
			}

			bestWorks.add(bestWork);
		}
		
		return bestWorks;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("请输入工作数：");
		int N = in.nextInt();
		System.out.println("请输入小伙伴数:");
		int M = in.nextInt();
		
		//初始化所有工作
		List<Work> works = new ArrayList<>();
		for(int i=0;i<N;i++){
			System.out.println("请输入第"+i+"个工作的难度：");
			int power = in.nextInt();
			System.out.println("请输入第"+i+"个工作的薪水:");
			int salary = in.nextInt();
			Work work = new Work(i,power,salary);
			works.add(work);
		}
		
		//初始化所有小伙伴的能力值
		List<Friend> friends = new ArrayList<>();
		for(int i=0;i<M;i++){
			System.out.println("请输入第"+i+"个小伙伴的能力值：");
			int power = in.nextInt();
			Friend friend = new Friend(i, power);
			friends.add(friend);
		}
		
		//为所有小伙伴找能力范围内薪水最高的工作
		List<Work> bestWorks = new ArrayList<>();
		bestWorks = findJob(works, N, friends, M);
		
//		for(Work work: works){
//			System.out.print(work.getSalary()+"\t");
//		}
		for(Work work: bestWorks){
			System.out.print(work.getSalary()+"\t");
		}

	}

}
