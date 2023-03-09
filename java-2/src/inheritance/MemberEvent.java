package inheritance;

//이벤트 관련 회원정보(아이디,이름,이메일)를 저장하기 위한 클래스
// => 회원정보를 저장하는 Member 클래스(아이디,이름)를 상속받아 작성하는 것을 권장 - 재사용성 증가
// => extends 키워드로 기존 클래스(부모클래스)를 상속받아 새로운 클래스(자식클래스) 작성
// => 자식클래스는 부모클래스의 필드 또는 메소드에 접근하여 사용 가능 - 상속성(Inheritance)
// => Java에서는 ★단일 상속★만 가능 - 부모클래스는 하나만 설정 가능
public class MemberEvent extends Member {
	/*
	  부모클래스(Member)을 상속받아 사용하므로(부모클래스랑 중복되는 부분은)필드 미선언 
	private String id;
	private String name;
	*/
	private String email; //부모클래스에 없는 부분만 따로 선언
	
	//자식클래스의 메소드에서 this 키워드로 자식클래스 객체의 필드 또는 메소드를 참조하고
	//없는 경우 자동으로 super 키워드로 부모클래스 객체의 필드 또는 메소드 참조
	//super 키워드 : 자식클래스의 메소드에서 부모클래스의 객체를 저장하기 위한 숨겨진 매개변수
	// => super 키워드로 자식클래스의 메소드에서 부모클래스 객체의 필드 또는 메소드에 접근
	// => super 키워드를 사용하지 않아도 자식클래스의 메소드에서는 부모클래스 객체의 필드 또는 메소드 사용 가능(this와 같은 개념)
	
	//super 키워드를 사용하는 경우
	// ★ 1. 자식클래스의 //생성자//에서 부모클래스의 //생성자를 호출//하기 위해 super 키워드 사용
	//    ㄴ 기본생성자가 super라서 부모를 먼저 참조하니까 본인꺼 먼저 사용하기 위해
	//   => 형식) super(값,값,...);
	//   => 부모클래스의 생성자를 호출하는 명령 전에 다른 명령을 작성하면 에러 발생
	// 2. 자식클래스의 메소드에서 //부모클래스의 숨겨진 메소드를 호출//하기 위해 super 키워드 사용
	//                              ㄴ숨기는 이유 : 자식클래스에 불필요해서 ==> 오버라이딩
	//   => 형식) super.메소드명(값,값,...);
	
	public MemberEvent() {
		//부모클래스의 기본 생성자 호출 - 부모클래스의 객체 생성
		//super(); 부모 클래스의 기본 생성자를 호출하는 명령, 생략 가능
	}

	/*
	public MemberEvent(String id, String name, String email) {
	
		super();//기본생성자 호출, 안하면 자동으로 생성됨(눈에 보이지 않음)
		//자식클래스에서 필드 또는 메소드에 접근하는 순서 
		// => 자식클래스(본인)의 필드 또는 메소드 참조 후 없는 경우 부모클래스의 필드 또는 메소드 참조(자동으로 이루어짐)
		// => 부모클래스의 은닉화 선언(private 접근지정자로)된 필드 또는 메소드 접근 불가능 (그래서 setter로 접근)
		
		//this.id = id;  본인의 필드 또는 메소드 먼저 참조하려고 this 사용됨(자동으로)
		setId(id);  부모 클래스에서 id를 호출 받으려고 setter 메소드 이용
		
		//this.name = name; 본인의 필드 또는 메소드 먼저 참조하려고 this 사용(자동으로)
		setName(name);   부모 클래스에서 name을 호출 받아서 설정하려고 setter 메소드 이용
		
		this.email = email;  나한테 있으니까 setEmail 할 필요 없음
	}
	*/                     //   ↓↓↓↓↓↓↓↓

	//[Alt]+[Shift]+[S] >> 팝업메뉴 >> [O] >> 부모클래스의 생성자 선택(매개변수 유무) >> 필드 선택 >> Generate
	public MemberEvent(String id, String name, String email) {
		// 부모클래스의 매개변수가 있는 생성자 호출 
		// => 부모클래스 객체에 원하는 초기값이 저장되도록 설정 - Setter 메소드 미호출
		super(id, name);
		this.email = email;
	}

	/*
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
	*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	//메소드 오버라이드(Method Override) : 상속 관계에서 부모클래스의 메소드를 자식클래스에서 //재선언//하는 기능
	// => 부모클래스의 메소드를 자식클래스의 객체가 사용하기 부적절한 경우 부모클래스의 메소드를 자식클래스에서 재선언하여 사용
	//메소드 오버라이드 작성 규칙 - 부모클래스의 메소드와 ★같은 접근제한자, 반환형, 메소드명
	//, 매개변수, 예외 전달을 사용하여 메소드 작성
	// => 부모클래스의 메소드는 숨겨지고 자식클래스의 메소드에만 접근 가능(메소드 뺏어오기)
	 
	public void display() {
		//System.out.println("아이디 = "+id);
		System.out.println("아이디 = "+getId()); -> 부모클래스에서 불러와야하는데 부모클래스의 필드가 
		//System.out.println("이름 = "+name);
		System.out.println("이름 = "+getName()); -> private 접근 지정자로 은닉화 돼있어서 getter 메소드 이용             
		System.out.println("이메일 = "+email);
	}
	*/
	
	//이클립스에서는 부모클래스의 메소드를 자식클래스에서 오버라이드 선언되도록 자동 완성하는 기능 제공
	// => 오버라이드 선언하고 싶은 부모클래스의 메소드명 입력 >> [Ctrl]+[Space] >> Override 선택
	
	//@Override : 오버라이드 선언된 메소드를 표현하기 위한 어노테이션
	// => 메소드 오버라이드 작성 규칙을 위반한 경우 에러 발생
	
	//어노테이션(Annotation) : API 문서에서 특별한 설명을 제공하기 위한 기능을 구현
	// => Java Source 작성에 필요한 특별한 기능을 제공 위해 사용 : @Override, @SuppressWarnings, @Deprecated
	
	@Override   //없어도 에러는 안나는데 오버라이드 유무를 확인하기 위해 있는것이 좋음
	public void display() {    //Member.java 클래스에 있는 메소드 재선언
		super.display(); //부모클래스에 있는 아이디와 이름 출력을 위해 super.메소드명();
		System.out.println("이메일 = "+email); //부모 클래스에 없는 이메일 출력은 직접 작성
	}
}
