package xyz.itwill.app;

import java.util.Date;
//java.lang 패키지의 자료형은 기본적으로 import 처리되어 제공
import java.util.Scanner;

//키보드로 이름과 태어난 연도를 입력받아 이름가 나이를 출력하는 프로그램 작성
//ex) 이름 입력 >> 홍길동
//    태어난 연도 입력 >> 2000
//    [결과]홍길동님의 나이는 23살입니다.

public class CalcAgeApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String name="";
		int year=0;
		
		System.out.print("이름 입력 >> ");
		name = scanner.nextLine();
		
		System.out.print("태어난 연도 입력 >> ");
		year = scanner.nextInt();
		
		//java.util.Date 클래스로 객체를 생성하여 참조변수에 저장
		//ㄴ java.utl.Date 클래스 : 날짜와 시간정보를 저장하기 위한 클래스
		//Date 클래스의 기본 생성자를 이용하여 객체를 생성할 경우 Date 객체에는 시스템(OS)의 현재 날짜와 시간이 저장됨
		Date now=new Date();
		//Date.toString() : Date 객체에 저장된 날짜와 시간을 문자열로 변환해 반환하는 메소드		
		//참조변수를 출력할 경우 toString() 메소드 호출 생략 가능
		//System.out.println("now.toString() = "+now.toString());
		//System.out.println("now = "+now);
		
		
		
		
		// @Deprecated 어노테이션이 적용된 메소드(취소선)
		// @Deprecated : 메소드 사용을 권장하지 않도록 설정하는 어노테이션
		// @Deprecated 설정된 메소드를 호출할 경우 경고 발생
		@SuppressWarnings("deprecation") //@SuppressWarnings : 경고메세지 제거
										 //ㄴ value 속성을 사용하여 경고 관련 속성값을 설정
										 //ㄴ value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
		int currentYear=now.getYear()+1900;
		//Date 객체로 부터 현재 년도를 반환받아 저장
		//Date.getYear() : Date 객체에 저장된 날짜와 시간 중 년도를 반환하는 메소드
		//ㄴ Date 객체에 저장된 년도는 1900년부터 1년에 1씩 증가된 값으로 표현
		
		
		
		
		int age=currentYear-year+1;
		System.out.println("[결과]"+name+"님의 나이는 "+age+"살입니다.");
		
		
		scanner.close();
		
	}//main
}//class
