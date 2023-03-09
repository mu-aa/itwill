package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//java.text 패키지 : 값을 변환하는 기능을 제공하는 클래스가 선언된 패키지

//SimpleDateFormat : Date 객체와 String 객체를 서로 변환하기 위한 기능을 메소드로 제공하는 클래스
//DecimalFormat : Number 객체(숫자값)와 String 객체를 서로 변환하기 위한 기능을 메소드로 제공하는 클래스
public class SimpleDateFormatApp {
	public static void main(String[] args) {
		Date now=new Date();
		
		//SimpleDateFormat(String pattern) : 날짜와 시간에 대한 패턴정보가 저장된
		//SimpleDateFormat 객체를 생성하기 위한 생성자
		//ㄴ 패턴정보 : 패턴문자를 이용하여 표현된 문자열
		//ㄴ 패턴문자 : y(년), M(월), d(일), E(요일), AM|PM(오전|오후), H(시, 24시), h(시, 12시), m(분), s(초)
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		
		//SimpleDateFormat.format(Date date) : 매개변수로 전달받은 Date 객체에 저장된 날짜와 시간을
		//SimpleDateFormat 객체에 저장된 패턴정보를 이용하여 문자열로 변환하여 반환하는 매소드
		String printDate=dateFormat.format(now); //Date -> String
		
		System.out.println("printDate = "+printDate);
		
		//SimpleDateFormat.applyPattern(String pattern) :  SimpleDateFormat 객체에 저장된 패턴정보를 변경하는 메소드
		dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("현재 = "+dateFormat.format(now));
		
		String want="2000-01-01 00:00:00.00";
		try {
			//SimpleDateFormat.parse(String str) : SimpleDateFormat 객체에 저장된 패턴정보 형식의 문자열을
			//매개변수로 전달받아 Date 객체로 변환하여 반환하는 메소드
			//ㄴ SimpleDateFormat 객체에 저장된 패턴정보와 일치하지 않는 문자열을 매개변수에 전달한 경우 ParseException 발생
			Date wantDate=dateFormat.parse(want); // String -> Date
			System.out.println("wantDate = "+wantDate);
		} catch (ParseException e) {
			System.out.println("[에러]형식에 맞지 않는 날짜와 시간입니다.");
		}
		
		
	}
}
