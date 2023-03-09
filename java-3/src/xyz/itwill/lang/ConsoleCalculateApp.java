package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 연산식을 입력받아 연산결과를 계산하여 출력
//ex) 연산식 입력 >> 20 + 10
//    [결과] 30
//입력 연산식에서 사용 가능한 연산자는 사칙 연산자(+ - * /)만 허용
//ㄴ 형식에 맞지 않은 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 종료
//ㄴ 입력 연산식에 공백 입력이 가능하도록 처리

public class ConsoleCalculateApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("연산식 입력 >> ");
		String operation=scanner.nextLine().replace(" ",""); //입력받기+공백처리
		
		scanner.close();

		//연산식에서 검색할 연산자가 저장된 배열 선언
		String[] operatorArray= {"*", "/", "+", "-"};
		
		int index=-1; //index는 0부터 시작이라 의미 없는 값으로 초기화 하기위해 -1로 선언
		
		for(String temp:operatorArray) {
			//String.lastIndexOf(String str)
			//ㄴ String 객체에 저장된 문자열에서 매개변수에 저장된 문자열을 뒤에서부터 검색하여 시작위치값을 반환
			//ㄴ 음수를 처리하기 위해 lastIndexOf를 사용
			index=operation.lastIndexOf(temp);
			
			if(index!=-1) break;  // 연산자를 찾은 경우 break;
		}
		
		//연산식에서 연산자가 없거나 연산자의 위치가 잘못된 경우
		if(index<=0 || index>operation.length()-1) {
			System.out.println("연산자가 없거나 위치가 잘못되었습니다.");
			System.exit(0);
		}
		
		try {
		
			//연산자의 시작 위치값을 이용해 연산식에서 연산자와 피연산자를 분리해 저장
			int num1=Integer.parseInt(operation.substring(0, index)); // 연산자 앞부분의 피연산자를 분리해 정수값으로 변환해 num1변수에 저장
			int num2=Integer.parseInt(operation.substring(index+1)); // 연산자 뒷부분의 피연산자를 분리해 정수값으로 변환해 num2변수에 저장
			String operator=operation.substring(index, index+1); //연산자 분리해 operator변수에 저장
		
			//연산자에 따른 연산 결과값 출력
			int result=0;
			
			switch(operator) {
			case "*" : result=num1*num2; break;
			case "/" : result=num1/num2; break;
			case "+" : result=num1+num2; break;
			case "-" : result=num1-num2; break;		
			}
		
			System.out.println("[결과] "+result);
			
		} catch(NumberFormatException error) {
			System.out.println("[에러]연산식에 숫자가 아닌 문자가 입력 되었습니다.");
		} catch(ArithmeticException error) {
			System.out.println("[에러]0으로 나눌 수 없습니다.");
		} catch(Exception error) {
			System.out.println("[에러]예기치 못한 문제가 발생했습니다.");
		}
	}//main
}//class
