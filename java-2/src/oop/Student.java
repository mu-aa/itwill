package oop;

// 학생정보(학번,이름,국어,영어,총점)을 저장하기 위한 VO 클래스
public class Student {
	// ● 인스턴스 필드(Instance Field) : 객체 생성 시 메모리(Heap Area)에 만들어지는 필드
	private int num;
	private String name;
	private int kor, eng, tot;
	
//	private int result;   객체마다 생성돼버림
	private static int result=0;  //객체의 갯수에 상관없이 메모리에 하나만 만들고 싶을 때 static 사용
//  ㄴ 정적필드(Static Field) : 클래스 생성 시 <객체가 생성되기 전에> 메모리(Static 영역)에 만들어지는 필드
//	ㄴ 생성자에서 초기화 하지않고 직접 초기화 설정 함
//	ㄴ 모든 객체에서 정적 필드 사용 가능 - 공유값 : 메모리 절약 및 필드값 변경 용이
//	ㄴ 클래스 외부에서는 객체가 아닌 클래스명.(점 연산자) 사용하여 접근
	
	
	// ● 생성자(Constructor)
	// ㄴ객체 생성 시 인스턴스 필드에 원하는 초기값을 저장하기 위한 기능 제공
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int num, String name, int kor, int eng) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
		//총점 계산
		//tot=kor+eng;  
		calcTot();   // ==> 코드의 중복성 최소화, 유지보수 효율성 증가
	}

	// ● 인스턴스 메소드(Instance Method) : this 매개변수가 존재하는 메소드
	// ㄴ 인스턴스 필드 및 정적 필드에 접근 가능
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		calcTot();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		calcTot();
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}
	
	//은닉화 선언된 메소드 - 클래스 내부에서만 사용 가능 ==> 시스템 메소드
	//코드의 중복성을 최소화 하기 위한 메소드(보통 private으로 설정)
	private void calcTot() {
		tot=kor+eng;
	}
	
	public void display() {  //필드값 출력 메소드(임시)
		System.out.print(name+"["+num+"]님의 성적 >> ");
		System.out.println("국어 = "+kor+", 영어 = "+eng+", 총점 = "+tot);
	}
	
	// 정적 메소드(Static Method) : this 매개변수가 없는 메소드
	// ㄴ this 매개변수가 없으므로 객체 필드에 접근 불가능
	// ㄴ 정적 필드만 접근하여 사용 가능
	// ㄴ 객체 생성 전에도 클래스 이름을 사용하여 접근 가능 - 메소드 호출의 용이성
	public static int getResult() {
		return result;
	}

	public static void setResult(int result) {
		Student.result = result;
	}
	
}//class
