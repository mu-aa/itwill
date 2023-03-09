package xyz.itwill.exception;

//예외(Exception) : 사용자에 의해 프로그램을 잘못 실행하거나 프로그램을 잘못 개발되어 실행한 경우 발생하는 프로그램 오류
//ㄴ 프로그램 실행 시 예외가 발생된 경우 예외가 발생된 지점에서 프로그램 강제 종료
//ㄴ 예외가 발생되어 프로그램이 종료되는 것을 방지하거나, 강제로 종료된 이유를 알기위해 예외처리(ExceptionHandle) 필요

//Java 에서는 예외를 처리하기 위해 다양한 예외클래스를 제공
//예외클래스(Exception Class) : 예외 관련 정보를 저장하기 위한 클래스
//ㄴ Exception 클래스를 상속받아 작성된 자식 클래스(Exception.ExceptionClass)

//Throwable 클래스 : 프로그램에서 발생하는 모든 오류정보를 저장하기 위한 부모클래스                  계층도(족보)
//ㄴ 자식클래스 : Error 클래스(하드웨어 오류정보), Exception 클래스(소프트웨어 오류정보) - Throwable.Exception.ExceptionClass

//예외의 종류
// 1. 일반 예외 클래스 - RuntimeException 클래스를 상속받지 않는 예외 클래스로 예외처리 하도록 제공
//   ㄴ 프로그램 실행 시 예외가 발생될 수 있는 가능성이 높아 컴파일 시 예외처리되어 있지 않으면 에러가 발생되게 처리
// 2. 실행 예외 클래스 - RuntimeException 클래스를 상속받는 예외 클래스로 예외처리 하도록 제공
//   ㄴ 프로그램 실행 시 예외가 발생될 수 있는 가능성이 낮아 컴파일 시 예외처리가 불필요
//   ㄴ 예외가 발생된 경우 JVM에서 자동으로 예외처리를 하여 예외메세지 제공

//예외처리 방법 - try~catch 구문 사용
/* 형식) try{
		예외가 발생할 수 있는 명령;  ㅡ 변수 선언 등은 try 밖에 선언
		...
	} catch(예외클래스 참조변수) {
		예외처리 명령;
		...
	} finally {
		예외에 상관없이 무조건 실행 될 명령
		...
	}
=> try 블럭에서 예외가 발생될 경우 JVM이 예외클래스로 객체 생성
=> try 블럭에서 발생된 예외 관련 객체를 catch 블럭으로 전달받아 참조변수에 저장
=> catch 블럭의 참조변수에 저장된 예외 관련 객체를 이용하여 예외처리 명령 작성
=> try 블럭에서 예외가 발생되면 프로그램을 종료하지 않고 프로그램의 흐름(스레드)이 catch 블럭으로 이동
=> catch 블럭은 여러 개 작성 가능 - 다양한 예외를 구분하여 예외처리 가능
=> finally 블럭에는 예외와 상관없이 무조건 실행 될 명령을 작성(사용 자원에 대한 제거 명령 실행) - 생략 가능
	
*/

public class ExceptionHandleApp {
	public static void main(String[] args) {
		int[] array= {10,20,30,40,50};
		
		try {
			//배열 요소 사용 시 첨자가 범위를 벗어난 경우 ArrayIndexOutOfBoundsException 발생 -> JVM에 의해 ArrayIndexOutOfBoundsException 객체 생성
			//ㄴ 실행 예외이므로 컴파일 시 예외처리 되어 있지 않아도 에러 미발생
			//ㄴ 실행 예외는 예외 발생 시 //JVM에 의해 자동으로 예외처리//되어 메세지를 제공받아 출력 - 비권장
			//ㄴ 사용자 중심의 프로그램을 작성하기 위해 직접 예외처리 하는 것을 권장
			for(int i=0;i<=array.length;i++) {
				System.out.println("array["+i+"] = "+array[i]);	
			}
			//예외가 발생된 경우 예외 발생 명령 하단에 존재하는 명령은 미실행
			//ㄴ 예외가 발생된 경우 프로그램은 강제 종료 되거나 catch 블럭으로 스레드가 이동하기 때문
			System.out.println("예외가 발생되지 않았습니다.");
		} catch(ArrayIndexOutOfBoundsException error) {
			//  ArrayIndexOutOfBoundsException 객체를 전달받아 참조변수에 저장하여 예외처리
			
			//프로그램 사용자에게는 예외 관련 메세지 출력 -> 생략 가능
			//System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생되었습니다.");
			
			//★프로그램 개발자에게는 예외 관련 메세지를 기록하여 전달(에러 로그) -> 필수
			System.out.println("[예외]"+error.getMessage());
			//Throwable.getMessage() : 예외 객체에 저장된 예외 메세지를 문자열로 반환하는 메소드
			
//			error.printStackTrace();  출력하기
//			error.getStackTrace();  배열로 반환받기
			//Throwable.printStackTrace() : 예외가 발생된 경로를 역추적하여 발생된 상세한 정보를 제공받아 출력하는 메소드
		} finally { // finally 생략 가능
			System.out.println("예외와 상관없이 무조건 실행되는 명령");
		}
		
	}
}
