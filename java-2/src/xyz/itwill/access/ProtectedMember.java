package xyz.itwill.access;

//protected : //필드, 메소드//에 사용 가능한 접근 제한자
//ㄴ 같은 패키지의 클래스에서 접근 가능하도록 설정
//ㄴ 다른 패키지의 클래스에서 접근할 경우 //상속을 사용하면 접근 가능//

public class ProtectedMember {
	protected int num;
	
	protected void display() {
		System.out.println("num = "+num);
	}
}
