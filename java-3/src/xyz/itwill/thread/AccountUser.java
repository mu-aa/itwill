package xyz.itwill.thread;

//은행계좌 사용자정보(은행계좌정보, 사용자명)를 저장하기 위한 클래스
public class AccountUser extends Thread {
	private Account account; //은행계좌정보 - 포함관계
	private String userName;

	public AccountUser() {
		// TODO Auto-generated constructor stub
	}

	public AccountUser(Account account, String userName) {
		super();
		this.account = account;
		this.userName = userName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public void run() {
		//개발자에 의해 생성된 새로운 스레드가 run() 메소드의 명령 실행
		//ㄴ 은행계좌 사용자에 의한 은행계좌 입금 처리 메소드 호출
		//account.deposit(userName, 5000);
		
		synchronized (account){ 
			account.withDraw(userName, 5000);
		}
	
		
	}
	
	
	
	
	
}//class
