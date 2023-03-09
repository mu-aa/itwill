package xyz.itwill.util;

import java.util.Random;

//java.util 패키지 : 프로그램 작성에 유용한 기능을 제공하는 클래스가 선언된 패키지

//Scanner 클래스 : 입력장치(키보드, 파일 등)로부터 값을 입력받기 위한 기능을 메소드로 제공하는 클래스
//Arrays 클래스 : 배열 요소를 처리하기 위한 기능을 메소드로 제공하는 클래스
//Random 클래스 : 난수값 관련 기능을 메소드로 제공하는 클래스
//Date 클래스 : 간단한 날짜와 시간정보를 저장하고 관련 기능을 메소드로 제공하는 클래스
//Calendar 클래스 : 상세한 날짜와 시간정보를 저장하고 관련 기능을 메소드로 제공하는 클래스
//★자료구조 클래스(Collection Class) : 다수의 객체를 효울적으로 저장하고 관리하기 위한 기능을 메소드로 제공하는 클래스
//ㄴ ArrayList, HashSet, HashMap 등 => Collection 인터페이스(Set 인터페이스, List 인터페이스) 또는 Map 인터페이스를 상속받은 자식클래스

public class RandomApp {
	public static void main(String[] args) {
		
		Random random=new Random();
		
		//Random.nextInt(int bound) : 0~bound-1 범위의 정수 난수 발생
		for(int i=1;i<=5;i++) {
			System.out.println(i+"번째 정수 난수 = "+random.nextInt(100)); // 0~99범위 난수 발생
		}
		
	}//main
}//class
