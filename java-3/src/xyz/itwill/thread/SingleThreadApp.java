package xyz.itwill.thread;

//스레드(Thread) : 프로그램에서 명령을 실행하기 위한 최소의 작업 단위 -> 프로그램 흐름
//프로세스(Process) : 메모리에 저장되어 중앙처리장치(CPU)에 의해 실행되는 명령

//단일 스레드 프로그램 
//ㄴ JVM에 의해 생성된 main 스레드를 이용하여 main() 메소드의 명령 실행
//ㄴ main() 메소드가 종료되면 main 스레드는 자동 소멸 -> 프로그램 종료

//다중 스레드 프로그램
//ㄴ 

public class SingleThreadApp {
	public static void main(String[] args) {
		System.out.println("SingleThreadApp 클래스의 main() 메소드 시작\n");
		
		//Thread 클래스 : 스레드 관련 정보를 저장하기 위한 클래스
		//ㄴ 스레드 관련 정보를 저장하고 스레드 관련 기능을 메소드로 제공하는 클래스
		//Thread.currentThread() : 현재 사용중인 스레드에 대한 Thread 객체를 반환하는 메소드
		//Thread.getName() : Thread 객체에 저장된 스레드의 이름(고유값, 식별자)을 반환하는 메소드
		System.out.println("["+Thread.currentThread().getName()+"] 스레드에 의해 main() 메소드 명령 실행");
		
		//객체를 사용하여 메소드를 호출한 경우 스레드가 클래스의 메소드로 이동하여 명령 실행
		//ㄴ 메소드의 명령을 모두 실행한 뒤 다시 되돌아와 나머지 명령 실행
		new SingleThread().display(); // 참조변수 없이 1회성 선언
		
		System.out.println("\nSingleThreadApp 클래스의 main() 메소드 종료");
	}
}
