package xyz.itwill.thread;

//스레드를 상속받는 클래스 = 스레드 클래스
public class MultiThreadOne extends Thread{
	
	@Override
	public void run() {
		for(char i='A';i<='Z';i++) {
			System.out.print(i);
			
			try {
				Thread.sleep(500);  // 오버라이드 된 메소드의 머릿부는 수정할 수 없음(상속, 예외전달 등 불가능)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}//for
	}//run
	 
	
	
	
}//class
