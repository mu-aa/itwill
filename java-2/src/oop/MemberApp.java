package oop;

public class MemberApp {
	public static void main(String[] args) {
		// new 연산자로 클래스의 매개변수가 없는 기본 생성자를 사용하여 객체 생성
		// 생성된 객체의 필드는 기본값으로 자동 초기화
		// new 연산자로 호출한 생성자가 없는 경우 에러 발생 - 객체 생성 불가능
		Member test=new Member();
		
		//Getter 메소드를 호출하여 필드값을 반환받아 출력
		System.out.println("아이디 : "+test.getId());
		System.out.println("이름 : "+test.getName());
		System.out.println("이메일 : "+test.getEmail());
		System.out.println("\n========================================\n");
		
		
		//Setter 메소드를 호출하여 매개변수의 전달값으로 객체의 필드값을 변경
//		test.setId("muaa");
//		test.setName("김민재");
//		test.setEmail("alswo9234@naver.com");
//		System.out.println("아이디 : "+id);
//		System.out.println("이름 : "+name);
//		System.out.println("이메일 : "+email);
		
		test.display(); //display 메소드에 출력 정보 불러오기로 대체
		System.out.println("\n========================================\n");
		
		
//		생성자(Constructor) 선언 : 객체를 생성하기 위한 특별한 메소드
//		ㄴ 생성자를 선언하면 기본 생성자 미제공, 객체의 필드를 원하는 값으로 초기화 하기위해 생성자를 선언함
//		ㄴ 형식) 접근지정자 클래스명(자료형 매개변수, ...) { 초기화명령; ... }
//		ㄴ ★ 반환형을 작성하지 않으며 생성자의 이름은 반드시 클래스명과 동일하게 작성 ★
//		ㄴ 메소드 오버로드 선언 가능 : 매개변수의 자료형 또는 갯수가 다른 여러개의 생성자 선언 가능
		
//		test.setId("muaa");
//		test.setName("김민재");
//		test.setEmail("alswo9234@naver.com");
		
//		생성자에 초기값 입력으로 대체
		System.out.println("\n========================================\n");
		
		
//		Member test2=new Member();                                         매개변수 존재하지 않는 생성자(기본 생성자)
		Member test2=new Member("muaa","김민재","alswo9234@naver.com");  //매개변수 존재하는 생성자(더 편함)
		test2.display();
		System.out.println("\n========================================\n");
	}
}
