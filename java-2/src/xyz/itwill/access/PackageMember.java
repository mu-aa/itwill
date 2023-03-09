package xyz.itwill.access; // --> 접근제한자가 아님

//package : 클래스, 필드, 메소드에 사용 가능한 접근제한자
//ㄴ 클래스 필드 메소드 작성 시 접근제한자를 사용하지 않으면 package 접근제한자로 설정됨(기본값)
//ㄴ 같은 패키지의 클래스에서 접근 가능하도록 설정
//ㄴ 다른 패키지의 클래스에서 접근할 경우 //상속에 관계 없이 무조건 에러// 발생

public class PackageMember {
	int num;
	
	void display() {
		System.out.println("num = "+num);
	}
}