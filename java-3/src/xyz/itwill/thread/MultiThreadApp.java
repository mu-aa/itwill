package xyz.itwill.thread;

//다중 스레드 프로그램
//ㄴ 개발자가 스레드를 직접 생성하여 여러 명령을 동시에 실행되도록 만든 프로그램
//ㄴ 프로그램의 모든 스레드가 소멸되면 프로그램 종료
//ㄴ GUI, Web 프로그램 등은 다중 스레드 프로그램으로 작성

//★개발자가 스레드를 생성하여 명령을 실행하는 방법(순서) <1>
//  1. Thread 클래스를 상속받은 자식클래스를 작성
//  2. Thread 클래스를 상속받은 자식클래스에 run() 메소드를 오버라이드
//     ㄴ run() 메소드에는 개발자에 의해 생성된 스레드가 실행할 명령 작성  --> 새로운 스레드를 만드는 이유
//  3. Thread 클래스를 상속받은 자식클래스의 객체 생성 --> 부모인 Thread 객체도 자동으로 생성
//  4. 자식클래스의 객체로 start() 메소드 호출 --> 자식클래스에 start() 메소드가 없으니, 부모클래스인 Thread 객체의 start() 메소드 호출
//     ㄴ Thread 객체로 새로운 스레드를 만들어 자식클래스에 오버라이드 선언된 run() 메소드를 호출

//개발자가 스레드를 생성하여 명령을 실행하는 방법(순서) <2> ←────────────────┐
//  1.Runnable 인터페이스를 상속받은 자식클래스 작성										  │
//    ㄴ 자식클래스가 다른 클래스를 상속받아 Thread 클래스를 상속받지 못할 경우 사용하는 방법 ┘
//  2.Runnable 인터페이스를 상속받은 자식클래스에 run() 메소드를 오버라이드 선언
//    ㄴ run() 메소드에는 프로그램 개발자에 의해 생성된 스레드가 실행할 명령 작성
//  3.Thread 객체 생성 - 생성자 매개변수에 Runnable 인터페이스를 상속받은 자식클래스의 객체를 전달받아 생성
//  4.Thread 객체로 start() 메소드 호출
//    ㄴ Thread 객체로 새로운 스레드를 만들어  Runnable 인터페이스를 상속받은 자식클래스의 오버라이드 선언된 run() 메소드에 명령 실행

public class MultiThreadApp {
	public static void main(String[] args) throws InterruptedException {  //main 메소드에 전달되는 모든 예외는 JVM에 의해 자동 예외처리
		//JVM에 의해 main 스레드가 자동으로 생성되어 main() 메소드의 명령 실행
		
		
		//Thread 객체를 참조변수에 저장하여 start() 메소드 호출
		//ㄴ 새로운 스레드가 만들어지면 Thread 클래스의 run() 메소드를 호출하여 명령 실행
		//ㄴ Thread 클래스의 run() 메소드에는 명령 미존재(오버라이드 하지 않아서)
		//Thread thread=new Thread();
		//thread.start();
		
		
		/*
		MultiThreadOne one=new MultiThreadOne();
		//Thread.start(); : Thread 객체로 새로운 스레드를 생성하여 run() 메소드를 호출 
		one.start();
		//one.start(); 하나의 Thread 객체로 start() 메소드를 여러번 호출 할 경우 IllegalThreadException 발생
		               ㄴ 다중 스레드 프로그램에서 예외 발생 시 해당 스레드는 자동 소멸
		*/
		
		
		//Thread 객체로 start() 메소드 외 다른 메소드를 호출하지 않을 경우
		//참조변수를 사용하지 않고 직접 start() 메소드 호출 하는것을 권장
		//ㄴ 새로운 스레드가 생성되어 MultiThreadOne 클래스의 run() 메소드의 명령 실행
		new MultiThreadOne().start(); //참조변수에 저장하지 않는 1회성 객체 생성, start() 메소드 호출
		new MultiThreadOne().start();
		
		//Thread(Runnable target) : Runnable 인터페이스를 상속받은 자식클래스의 객체를 전달 받아 Thread 객체를 생성하는 생성자
		//ㄴ Thread 객체에 run()메소드가 오버라이드 선언하는 것과 같은 기능
		new Thread(new MultiThreadTwo()).start();
		
		
		for(char i='0';i<='9';i++) {
			System.out.print(i);
			
			//Thead.sleep(long ms) : 현재 스레드를 원하는 시간(ms)만큼 일시적으로 중지하는 메소드
			//InterruptedException 발생(일반 예외) -> main 메소드로 throws(예외전달)
			Thread.sleep(500);
			
		}//for
		
		
	}//main
}//class
