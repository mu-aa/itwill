package inheritance;

//사람정보(번호,이름)를 저장하기 위한 클래스
// => 학생,강사,직원에 대한 공통적인 속성과 행위를 정의하기 위한 클래스
// => 학원인적자원 관련 클래스가 상속받아야 되는 부모클래스
// => 코드의 중복성을 최소화하여 프로그램의 생산성 및 유지보수의 효율성 증가
public class AcademyPerson {
	
	private int num;
	private String name;
	
	public AcademyPerson() {
		// TODO Auto-generated constructor stub
	}

	public AcademyPerson(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void display() {
		System.out.println("번호 = "+num);
		System.out.println("이름 = "+name);
	}
}