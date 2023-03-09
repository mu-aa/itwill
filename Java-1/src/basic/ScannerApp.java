package basic;

import java.util.Scanner;

/*
 System.out : 출력스트림을 사용하여 값을 출력하는 기능을 제공하는 객체
 System.in : 키보드로부터 전달된 값을 입력스트림을 사용하여 입력하는 기능을 제공하는 객체
 

*/
public class ScannerApp {
	public static void main(String[] args) {
		
		// Scanner 클래스 : 입력장치(키보드, 파일 등)로부터 값을 전달받아 반환하기 위한 기능을 제공하는 클래스
		// Scanner 클래스로 객체를 생성하여 변수에 저장
		// 변수에 저장된 객체를 사용하여 메소드 호출 - 원하는 기능 구현
		// System.in 객체를 사용하여 키보드로부터 값을 전달받기 위한 Scanner 객체 생성
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name=scanner.nextLine();
		// scanner.nextLine(); : 키보드로부터 입력 값을 전달받아 문자열로 변환
		// ㄴ 키보드 입력 값이 없는 경우 스레드가 일시 중지
		// ㄴ 키보드로 값을 입력 후 엔터를 입력해 스레드가 다시 진행
		// 키보드로 입력 된 값을 문자열로 반환받아 변수(String name)에 저장(=)
		
		System.out.print("나이 입력 : ");
		int age=scanner.nextInt();
		// 키보드로 입력 된 값을 정수로 반환받아 변수(int age)에 저장(=)
		// 입력된 값이 정수값이 아닌 경우 예외(Exception) 발생
		
		System.out.println("\n이름: "+name+"\t나이: "+age);
		scanner.close(); // scanner 객체를 제거하는 메소드
	}
}
