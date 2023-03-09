package xyz.itwill05.di;

//학생정보를 저장하기 위한 클래스 - VO, DTO 클래스
public class Student {
	private int num;
	public String name;
	public String email;
	
	public Student() {
		System.out.println("### Student 클래스의 기본 생성자 호출 ###");
	}
	
	public Student(int num) {
		super();
		this.num = num;
		System.out.println("### Student 클래스의 매개변수가 있는 생성자 호출 ###");
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
		System.out.println("### Student 클래스의 매개변수가 있는 생성자 호출 ###");
	}
	
	public Student(int num, String name, String email) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		System.out.println("### Student 클래스의 매개변수가 있는 생성자 호출 ###");
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		System.out.println("*** Student 클래스 setNum(int num) 메소드 호출 ***");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("*** Student 클래스 setName(String name) 메소드 호출 ***");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println("*** Student 클래스 setEmail(String email) 메소드 호출 ***");
	}
	
	@Override
	public String toString() {
		return "학번 = "+num+", 이름 = "+name+", 이메일 = "+email;
	}
}