package basic;

import java.util.Scanner;

public class InputCheckApp {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int score=0;
		
		 while(true){  // 무한루프
			System.out.print("점수 입력(0~100) : ");
			score=scanner.nextInt();
			
			if(score<0 || score>100) { // 입력값이 비정상일 경우 재입력
				System.out.println("\n<<score error>>\n");
				} else {
					break;
					}
		 }
		 
		 scanner.close();
		
		char grade;
		switch (score/10) {
			case 10: 
			case 9: grade='A'; break;
			case 8: grade='B'; break;
			case 7: grade='C'; break;
			case 6: grade='D'; break;
			default: grade='F';
		}
		System.out.println("학점 : "+grade);
	}
}
