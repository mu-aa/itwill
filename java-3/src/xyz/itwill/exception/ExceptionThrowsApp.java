package xyz.itwill.exception;

public class ExceptionThrowsApp {
	
	//예외가 발생된 명령에서 예외처리하지 않고 발생된 예외를 메소드를 이용해 전달 가능
	//형식) 접근제한자 반환형 메소드명(자료형 매개변수명, ...) throws 예외클래스, 예외클래스, ... {  }
	//ㄴ 메소드 명령에서 발생된 예외를 메소드를 호출하는 명령으로 전달하는 방법
	public static void display() throws ArrayIndexOutOfBoundsException{
		int[] array= {10,20,30,40,50};
		
		for(int i=0;i<=array.length;i++) {			
			System.out.println("array["+i+"] = "+array[i]);
		}
	}
	
	public static void main(String[] args) {
		try {
			//ExceptionThrowsApp.display();
			//정적 메소드는 클래스를 이용하여 메소드를 호출
			//ㄴ 같은 클래스에 선언된 정적 메소드는 클래스 없이 메소드 호출 가능
			//ㄴ 예외가 발생되는 메소드를 호출한 명령을 try~catch 구문으로 예외처리
			//ㄴ display 메소드 전체에 예외 발생 시 throws로 전달, 예외가 발생한 메소드를 호출한 명령을 try~catch로 예외처리(일괄처리의 장점)
			//ㄴ 일반예외 : 컴파일 에러     실행예외 : JVM이 자동 예외처리
			display();
		} catch(ArrayIndexOutOfBoundsException error) {
			System.out.println("ERROR");
		}
		
	}//main
}//class
