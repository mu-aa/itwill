package basic;

import java.util.Scanner;

public class RpaGameApp {
	public static void main(String[] args) {
		//가위(0)바위(1)보(2)
		//컴퓨터(난수) vs 사용자(키보드)
		//사용자가 이길 경우 반복 실행
		//대결 종료 후 사용자의 승리 횟수 출력
		
		Scanner scanner=new Scanner(System.in);
		int win=0;
		
		while(true) {
			System.out.print("\n\n0:가위  1:바위  2:보 >> ");
			int input = scanner.nextInt();  //입력받기
			
			int cpu=(int)(Math.random()*3);  //난수발생
			
			if(input<0||input>2) {  //오류검사
				System.out.println("error");
				continue;
			}
			
			switch(input) {  //유저가 낸 거
			case 0: System.out.println("\n((user)) : 가위"); break;
			case 1: System.out.println("\n((user)) : 바위"); break;
			case 2: System.out.println("\n((user)) : 보"); break;
			}
			
			switch(cpu) {  //컴퓨터가 낸 거
			case 0: System.out.println("{{cpu}} : 가위\n"); break;
			case 1: System.out.println("{{cpu}} : 바위\n"); break;
			case 2: System.out.println("{{cpu}} : 보\n"); break;
			}
			
			if((input==0&&cpu==2) || (input==1&&cpu==0) || (input==2&&cpu==1)) {  //가위바위보 승리여부
				win++;
				System.out.println("----user win----\n");
			} else if(input==cpu) {
				System.out.println("----draw----\n");
			} else {
				System.out.println("----cpu win----\n");
				break;
			}
		}
		
		if(win==0) {
			System.out.println("\n한 번도 못 이김..");
		} else {
			System.out.println("\n"+win+"승");
		}
		
		scanner.close();
	}
}
