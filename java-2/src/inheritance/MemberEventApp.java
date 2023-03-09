package inheritance;

public class MemberEventApp {
	public static void main(String[] args) {
		//자식클래스(MemberEvent)의 생성자로 객체를 생성할 경우 부모클래스(Member)의 생성자가
		//먼저 호출되어 부모클래스의 객체가 생성된 후 자식클래스의 객체 생성되어 상속 관계 성립
		// => 자식클래스의 참조변수에는 자식 클래스의 객체 저장
		MemberEvent member1=new MemberEvent();
		
		//참조변수에 저장된 자식클래스의 객체를 참조하여 메소드 호출
		// => 자식클래스 객체에 없는 메소드는 부모클래스의 객체를 참조하여 메소드 호출
		member1.setId("abc123");  //부모클래스에 있는 setter 메소드 호출
		member1.setName("홍길동");
		member1.setEmail("abc@itwill.xyz");
		
		member1.display();
		System.out.println("==============================================================");
		MemberEvent member2=new MemberEvent("xyz789", "임꺽정", "xyz@itwill.xyz");
		member2.display();
		System.out.println("==============================================================");
	}
}