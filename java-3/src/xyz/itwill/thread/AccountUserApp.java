package xyz.itwill.thread;

//다중스레드 프로그램의 문제점
//ㄴ 동일한 다수의 스레드(같은 클래스)가 run() 메소드의 명령을 동시에 호출하여 필드값(공유데이터)을 변경할 경우 잘못된 결과가 발생할 수 있음

//해결법) 스레드 동기화를 이용하여 스레드에 대한 메소드 호출 제어
//스레드 동기화(Thread Synchronized)
//ㄴ 스레드에 의해 메소드 호출 시 메소드의 명령을 모두 처리하기 전까지 다른 스레드의 호출을 방지
//ㄴㄴ 스레드를 일시 중지하여 명령이 실행되지 않도록 락(Lock) 기능 제공

//스레드 동기화 처리 방법
//  1. Synchronized 키워드를 사용하여 메소드 선언 - 동기화 메소드(Synchronized Method)
//     ㄴ형식) 접근제한자 synchronized 반환형 메소드명(자료형 매개변수명, ...) { ... }
//  2. Synchronized 키워드로 블럭을 설정하여 메소드 호출 (메소드 변경을 하지 못할 경우 사용)
//     ㄴ형식) synchronized(객체) { 객체.메소드명(값, ...); ... }
//     ㄴ> 객체로 호출되는 모든 메소드는 동기화 처리되어 실행 (비권장)
public class AccountUserApp {
	public static void main(String[] args) {
		
		Account account=new Account(10000);
		
		/*
		//단일 스레드(main 스레드)를 이용해 은행계좌 사용자를 생성하여 입금 처리
		AccountUser[] users=new AccountUser[3];
		
		//모든 사용자가 동일한 계좌 사용
		users[0]=new AccountUser(account, "홍길동");
		users[1]=new AccountUser(account, "임꺽정");
		users[2]=new AccountUser(account, "전우치");
		
		for(AccountUser temp:users) {   //5000원씩 입금 일괄처리
			temp.getAccount().deposit(temp.getUserName(), 5000);
		}
		*/
		
		//다중 스레드를 이용, 은행계좌 사용자를 생성해 입출금 처리
		new AccountUser(account, "홍길동").start();
		new AccountUser(account, "임꺽정").start();
		new AccountUser(account, "전우치").start();
		
	}//main
}//class
