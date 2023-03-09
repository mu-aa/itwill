package xyz.itwill.util;

import java.util.Calendar;

//현재 연월에 대한 달력을 출력하는 프로그램 작성
public class CurrentCalendarApp {
	public static void main(String[] args) {
		//시스템의 현재 날짜와 시간이 저장된 Calendar 객체를 반환받아 저장
		Calendar calendar=Calendar.getInstance();
		
		//Calendar.set(int field, int value) : Calendar 객체에 날짜와 시간에서
		//매개변수로 전달된 Calendar 클래스의 상수에 대한 값을 변경하는 메소드
		//ㄴ Calendar 객체에 저장된 날짜와 시간 중 [일]을 [1일]로 변경
		calendar.set(Calendar.DATE, 1);
		
		//Calendar 객체에 저장된 날짜와 시간 중[요일]을 반환받아 저장 - 1~7 범위의 정수값 반환
		int week=calendar.get(Calendar.DAY_OF_WEEK);
		
		
		System.out.println("          "+calendar.get(Calendar.YEAR)+"년"+(calendar.get(Calendar.MONTH)+1)+"월");
		System.out.println("===============================");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("===============================");
		
		//[1일]에 대한 요일전까지 공백 출력
		for(int i=1;i<week;i++) {
			System.out.print("   -");
		}
		
		//1일부터 [월]의 마지막 날짜까지 출력
		//Calendar.getActualMaximum(int field) : Calendar 객체에 저장된 날짜와 시간에서
		//매개변수에 전달된 Calendar 클래스의 상수에 대한 최대값을 반환하는 메소드
		for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			//날짜 출력 >> 1의자리, 10의자리 자릿수 맞춤
			if(i<=9) {
				System.out.print("   "+i);
			} else {
				System.out.print("  "+i);
			}
			
			week++; // 요일 증가
			
			if(week%7==1) { // 증가된 요일이 일요일인 경우
				System.out.println(); // 토요일까지 출력되고 줄바꿈
			}
		}
		
		
	}
}
