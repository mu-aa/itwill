package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값 2개를 입력받아 첫번째 정수값을 두번째 정수값으로 나눈 몫을 계산하여 출력하는 프로그램
public class CalcApp {
//	public CalcApp() throws Exception{  --> 모든 예외를 Exception 클래스 하나로 전달    //비권장
	public CalcApp() throws InputMismatchException, ArithmeticException{
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("첫번째 정수값 입력 >> ");
		int num1=scanner.nextInt();
		//ㄴ 입력값이 정수값으로 변환되지 못할 경우 InputMismatchException 발생
		//ㄴ 직접 예외처리하지 않고 메소드에 throws를 사용하여 발생 예외 전달 가능
		
		System.out.print("(0이 아닌)두번째 정수값 입력 >> ");
		int num2=scanner.nextInt();
		
		//어떤 수를 0으로 나눈 경우 ArithmeticException 발생
		System.out.println("[결과] "+num1+" / "+num2+" = "+num1/num2);
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		//생성자를 이용하여 객체 생성 - 생성자의 명령 실행
		//ㄴ 예외가 전달된 메소드 호출 -> 예외 발생 -> 예외처리
		try {
		new CalcApp(); //CalcApp 생성자 객체 생성
		} //catch(InputMismatchException | ArithmeticException error) { 예외 클래스를 | 연산자로 연결하여 다수의 예외에 대한 처리 가능(비권장)
		  catch(InputMismatchException error) {
			System.out.println("\n[에러]형식에 맞는 값을 입력해 주세요");
		} catch(ArithmeticException error) {
			System.out.println("\n[에러]0으로 나눌 수 없습니다");
		} catch(Exception error) { // Exception : 모든 예외 객체를 전달받아 참조변수에 저장하여 예외처리 가능(else 개념?)
			System.out.println("\n[에러]프로그램에 예기치 못한 오류가 발생했습니다");
		}
	}
	
}
