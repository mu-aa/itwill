package xyz.itwill.util;

import java.util.Calendar;

//Calendar 클래스 : 날짜와 시간을 저장하고 날짜와 시간 관련 기능을 메소드로 제공하기 위한 클래스
public class CalendarApp{
	public static void main(String[] args) {
		//Calendar.getInstance() : 시스템의 현재 날짜와 시간이 저장된 Calendar 객체를 생성하여
		Calendar calendar=Calendar.getInstance();
		
//		System.out.println("calendar.toString()"+calendar.toString());
		System.out.println("calendar"+calendar);//toString() 생략 가능
		
		String[] dayOfWeek= {"일","월","화","수","목","금","토"};
		
		//Calendar.get(int (constant)field) : Calendar 객체에 저장된 날짜와 시간에서
		//매개변수에 전달된 Calendar 클래스의 상수에 대한 값을 반환하는 메소드
		//ㄴ [월]은 0~11(1월~12월)범위, [요일]은 1~7(일~토)범위로 표현
		String printDate=calendar.get(Calendar.YEAR)+"년"+(calendar.get(Calendar.MONTH)+1)+"월"+calendar.get(Calendar.DATE)+"일"+dayOfWeek[calendar.get(Calendar.DAY_OF_WEEK)-1]+"요일";
		System.out.println("printDate = "+printDate);
		System.out.println("\n====================================================\n");
		
	}
}
