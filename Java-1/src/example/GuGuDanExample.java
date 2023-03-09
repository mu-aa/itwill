package example;

import java.util.Scanner;

public class GuGuDanExample {
	public static void main(String[] args) {
		
		//키보드로 정수값을 입력받아 1~9 범위의 정수값을 곱한 결과를 출력하는 프로그램을 작성하세요.
		//단,키보드로 입력된 정수값은 2~9 범위의 정수값만 허용하면 범위를 벗어난 정수값을 입력한 경우
		//에러 메세지 출력 후 재입력하도록 프로그램 작성
		//ex) 단 입력[2~9] >> 7
		
		Scanner scanner=new Scanner(System.in);
		int input;
		
		while(true) {
			
			System.out.print("단 입력[2~9] >> ");
			input=scanner.nextInt();
			
			if(input<2 || input>9) {
				System.out.println("out of bounds");
				continue;
			} else {
				for(int i=1;i<=9;i++) {
					System.out.println(input+" * "+i+" = "+ ""+input*i);
				}
				break;
			}
		}
		
		scanner.close();
		
		
		
	}
}
