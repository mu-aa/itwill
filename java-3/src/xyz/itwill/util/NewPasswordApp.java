package xyz.itwill.util;

import java.util.Random;
import java.util.UUID;

//새로운 비밀번호를 제공하는 프로그램 작성
public class NewPasswordApp {
	public static String newPasswordOne() {
		//새로운 비밀번호를 생성하여 반환하는 메소드
		Random random=new Random();
		
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~!@#$%^&*()-_=+"; //문자 범위
		StringBuffer password=new StringBuffer(); // 객체 선언
		
		for(int i=1;i<=10;i++) {
			//범위(str.legnth)내에 있는 랜덤한 첨자(random.nextInt)위치의 문자를 반환받아(str.charAt) 문자열 합치기(append) == password 객체에 저장
			password.append(str.charAt(random.nextInt(str.length()))); 
		}
		return password.toString(); //문자열로 출력
	}
	
	public static String newPasswordTwo() {
		//UUID 클래스 : 범용적으로 사용되는 식별자를 생성하기 위한 기능을 메소드로 제공하는 클래스
		//UUID.randomUUID() : 식별자가 저장된 UUID 객체를 생성하여 반환
		//ㄴ UUID 객체에 저장된 식별자는 숫자, 영문자(소문자),-(4개)의 36개의 문자로 구성
		//UUID.toString() : UUID 객체에 저장된 식별자를 문자열(String 객체)로 반환하는 메소드
		//substring(0, 10) : 0에서부터 10범위까지 문자 추출
		return UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
		//  == 랜덤UUID객체생성.문자열로반환.-특수문자제거.0번째부터10번째까지.대문자로변환;
	}
	
	public static void main(String[] args) {
		System.out.println("새로운 비밀번호1 = "+newPasswordOne());
		System.out.println("새로운 비밀번호2 = "+newPasswordTwo()); //영문+숫자만 가능
	}
	
}
