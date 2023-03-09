package xyz.itwill.access;

//접근제한자(Access Modifier) : 클래스,필드,메소드에 대한 접근 유무를 설정하기 위한 제한자
//=> private, package(default), protected, public

//private : //필드와 메소드//에 사용 가능한 접근제한자 - 은닉화 
//=> 클래스 내부에서만 접근 가능하며 클래스 외부에서는 접근 불가능

public class PrivateMember {
	private int num;
	
	@SuppressWarnings("unused")
	private void display() {
		System.out.println("num = "+num);
	}
}