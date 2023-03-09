package basic;
/*
 
 continue : 반복문에서 바로 아래에 명령을 스킵(컨티뉴가 존재하는 블럭을 탈출)하고 처음부터 실행하기 위한 반복문
 
*/
public class ContinueApp {
	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++) {
			if(i==3) continue;
			System.out.print(i+"\t");
		}
		System.out.println("\n=================================\n");

		loop:
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(j==3) continue loop; // 실행을 처음부터 다시(결괏값은 초기화 되지 않음)
			System.out.println("i= "+i+"\tj= "+j);
				}
			System.out.println();
			}
		System.out.println("\n=================================\n");
	}
}
