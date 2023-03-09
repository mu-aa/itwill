package example;

import java.util.Scanner;

//컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요.
// => 1~100 범위의 정수 난수값을 제공받도록 작성
// => 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
// => 키보드 입력값이 1~100 범위가 아닌 경우 메세지 출력 후 재입력
// => 난수값과 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료
// => 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
// => 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성
public class UpAndDownExample {
	public static void main(String[] args) {
		
		int cpu=(int)((Math.random()*100)+1);
		int cnt=0;
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			
			cnt++;
			
			System.out.print("1~100 입력 : ");
			int input=scanner.nextInt();
			
			if(input>100 || input<1){
				System.out.println("out of bounds");
				continue;
			} else {
				if(input==cpu) {
					System.out.println("\n정답, 입력 횟수 "+cnt);
					break;
				} else if(input>cpu) {
					System.out.println(input+" Down\n");
				} else if(input<cpu) {
					System.out.println(input+ " Up\n");
				}
				
				if(cnt==10) {
					System.out.println("\n횟수 초과, 정답 : "+cpu);
					break;
				}
			}
		}
		
		scanner.close();
		
	}//main
}//class