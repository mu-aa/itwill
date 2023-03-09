package inheritance;

//상속(Inheritance) : 클래스 작성시 다른 클래스를 물려받아 사용하는 기능
// => 기존 클래스를 재활용하여 보다 빠르고 쉽게 새로운 클래스 작성(프로그램의 생산성 증가)
// => 공통적인 속성과 행위를 가진 다수 클래스 작성시 공통적인 속성과 행위가 선언된 클래스를 상속받아 작성(유지보수의 효율성 증가)

//물려주는 클래스 : 부모클래스, 선조클래스, 기본클래스, 슈퍼클래스(Super Class)
//물려받는 클래스 : 자식클래스, 후손클래스, 파생클래스, 서브클래스(Sub Class)

//형식) public class 자식클래스 extends 부모클래스 {
//			//자식클래스에서는 부모클래스의 필드 또는 메소드 사용 가능	
//      }
// => 부모클래스의 //생성자//는 자식클래스에게 상속X
// => 부모클래스의 //은닉화// 선언된 필드 또는 메소드는 자식클래스에서 접근X (상속은 가능)

//자식클래스의 생성자로 객체를 생성할 경우 //부모클래스의 생성자가 먼저 호출//되어
//자동으로 부모클래스의 객체 생성 후 자식클래스의 객체 생성 -> 객체간의 상속관계가 자동으로 성립

//회원정보(아이디, 이름)를 저장하기 위한 클래스
public class Member {
	private String id;
	private String name;
	
	public Member() { // 자식의 생성자를 만들 때 필요해서(기본적으로 자식의 생성자를 만들 때 부모의 기본 생성자를 참조함)
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String name) {
		super(); // 기본 생성자 생략 가능, 안보이지만 자동으로 만들어짐(this와 같은 개념으로)
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void display() { // ==> MemberEvent 클래스에서 오버라이딩해서 숨겨진 메소드
		System.out.println("아이디 = "+id);
		System.out.println("이름 = "+name);
	}
}








