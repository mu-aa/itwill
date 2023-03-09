package xyz.itwill.access;

//public : 클래스, 필드, 메소드에 사용 가능한 접근제한자
//ㄴ 모든 패키지의 클래스에서 접근할 수 있도록 설정

//public 클래스 : 다른 패키지의 클래스에서 접근할 수 있도록 작성된 클래스
//ㄴ public 클래스가 아닌 경우 다른 패키지의 클래스에서 접근(import) 불가능 - 에러 발생
//ㄴ 소스파일에 public 클래스는 하나만 작성 가능
//ㄴ 접근지정자가 없는(package) 클래스는 여러개 가능 하지만 보통 클래스는 소스파일 당 1개만 작성 권장

public class PublicMember {
	public int num;
	
	public void display() {
		System.out.println("num = "+num);
		
	}
}