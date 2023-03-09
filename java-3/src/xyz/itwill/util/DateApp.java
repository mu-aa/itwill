package xyz.itwill.util;

import java.util.Date;

//Date 클래스 : 날짜와 시간을 저장하고 관련 기능을 메소드로 제공하기 위한 클래스
public class DateApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Date 클래스의 기본 생성자로 Date 객체를 생성하면
		//현재 날짜와 시간이 저장된 Date 객체 생성
		Date now=new Date();
		
		System.out.println(now.toString());
		System.out.println(now); //toString() 생략 가능
		
		String[] day= {"일","월","화","수","목","금","토"};
		//Date.getYear() : Date 객체에 저장된 날짜와 시간 중 [연도]를 반환하는 메소드
		//ㄴ 1900년부터 1씩 증가된 정수값 반환
		//Date.getMonth() : Date 객체에 저장된 날짜와 시간 중 [월]을 반환하는 메소드
		//ㄴ 0~11(1월~12월) 범위의 정수값 반환
		//Date.getDate() : Date 객체에 저장된 날짜와 시간 중 [일]을 반환하는 메소드
		//Date.getDay() : Date 객체에 저장된 날짜와 시간 중 [요일]을 반환하는 메소드
		//ㄴ 0~6(일~토) 범위의 정수값 반환
		String printDate=(now.getYear()+1900)+"년"+(now.getMonth()+1)+"월"+now.getDate()+"일"+day[now.getDay()]+"요일";
		System.out.println("현재 = "+printDate);
		
		//Date.getTime() : Date 객체에 저장된 날짜와 시간을 long 자료형의 정수값(타임스탬프)으로 반환하는 메소드
		//ㄴ 타임스탬프 : 1970년 1월 1일을 기준으로 1ms마다 1씩 증가된 정수값
		//ㄴㄴ 날짜와 시간을 정수값으로 표현하여 연산하기 위해 사용
		//long nowTime=now.getTime();
		
		/*★*/long nowTime=System.currentTimeMillis();
		System.out.println("nowTime = "+nowTime);
		
		Date wantDate=new Date(100,0,1); //2000년 1월 1일 0시 0분 0초가 저장된 Date 객체 생성
		System.out.println("wantDate = "+wantDate);
		
		long wantTime=wantDate.getTime();
		
		//2000년 1월 1일부터 오늘까지 며칠이 지났는지 계산
		System.out.println("연산 결과 = "+((nowTime-wantTime)/1000)/86400+"일");
		
	}
}
