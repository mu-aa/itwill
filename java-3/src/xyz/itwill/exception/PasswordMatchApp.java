package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값을 입력받아 저장된 비밀번호와 비교하여 결과를 출력
public class PasswordMatchApp {
	public static void main(String[] args) {
		/*
		 Scanner scanner=new Scanner(System.in);
		 
		 System.out.print("비밀번호 입력 : ");
		 int pass=scanner.nextInt();
		  
		 if(pass==123456) { 
		 	System.out.println("Logined"); 
		 } else {
		 	System.out.println("ERROR");
		 }
		 */
		
		Scanner scanner=new Scanner(System.in);

		try {
			System.out.print("비밀번호 입력 : ");
			int pass=scanner.nextInt();
			
			if(pass!=123456) {
				//인위적으로 예외가 발생시키는(예외 객체를 생성) 명령
				//형식) throw new 예외클래스(String message);
				throw new PasswordMismatchException("비밀번호가 다릅니다"); // 직접 만든 예외 클래스 사용
				//throw new Exception("비밀번호가 다릅니다.");  기존 예외 클래스 사용
				}
			//인위적인 예외가 발생되지 않을 경우 실행되는 명령
			System.out.println("로그인");
			} catch (InputMismatchException error) {
				System.out.println("숫자만 입력 가능합니다.");
			} catch(PasswordMismatchException error) {
				System.out.println(error.getMessage());
			} finally {
				scanner.close();
			}
		
		
		
	}
}
