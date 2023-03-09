package inheritance;

//사원정보(사원번호 사원이름)를 저장
//ㄴ 모든 사원 관련 클래스가 상속 받아야 하는 부모클래스
//ㄴ 객체 생성이 아닌 상속이 목적인 클래스 -> 추상클래스 작성하는 것을 권장

//추상 클래스(Abstract Class) : abstract 제안자(지정자)를 사용하여 선언된 클래스 - 객체 생성X, 상속 전용
//ㄴ 형식) public abstract class 클래스명 { ...  }

//static 제한자 - 필드, 메소드, 클래스(내부 클래스)에 설정 가능
//ㄴ 객체에 상관 없이 클래스로 접근하기 위해 사용하는 제한자

//final 제한자 - 필드, 메소드, 클래스에 설정 가능  ←--반대개념--→  abstract
// 1. final 필드 (ex. 접근제한자 final 자료형 필드명=값;)
//    ㄴ 필드에 저장된 값 불가능, 필드 값 변경 시 에러
//    ㄴ 필드에 반드시 초기값이 저장되도록 설정
// 2. final 메소드 (ex. 접근제한자 final 반환형 메소드명(자료형 매개변수명, ...){ 명령; ... })
//    ㄴ 자식클래스에서 절대로 오버라이드를 선언 할 수 없게 설정하는 메소드
// 3. final 클래스 (ex. 접근제한자 final class 클래스명)
//    ㄴ 다른 클래스에서 상속 받을 수 없는 클래스 ex) public final class System. extends Object 클래스

public abstract class Employee {
	
	private int empNo;
	private String empName;
	
	//상수(Constant) : 프로그램에서 값 대신 사용하기 위해 의미있는 단어로 제공되는 ★절대값
	// ㄴ 접근제한자 final 자료형 상수명=값;
	// ㄴ 상수명은 스네이크 표기법을 사용하여 작성(대문자로 작성, 언더바로 구분)
	public static final double INCENTIVE_RATE=1.5; //보통 상수는 public 접근제한자 사용(값이 안변하니까)
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	public int getempNo() {
		return empNo;
	}

	public void setempNo(int empNo) {
		this.empNo = empNo;
	}

	public String getempName() {
		return empName;
	}

	public void setempName(String empName) {
		this.empName = empName;
	}
	
	/*
	자식클래스에서 부모클래스의 메소드를 오버라이드 선언하지 않아도 에러는 없음
	ㄴ 자식클래스에서 부모클래스의 메소드를 오버라이드 선언하지 않은 경우 부모클래스의 메소드 호출
	public int computePay() {
		return 0;
	}*/
	
	//자식클래스에서 부모클래스의 메소드를 무조건 오버라이드 선언 되도록 설정하기 위해 추상 메소드(Abstract Method)로 선언
	//ㄴ 메소드의 머릿부만 작성하고 몸체부는 작성하지 않는 미완성된 메소드 --> 어차피 오버라이드 돼서 몸체부가 필요없음
	//형식) 접근제한자 반환형 메소드명(자료형 매개변수명, ...);
	//추상 메소드는 반드시 추상 클래스에 선언해야 함
	public abstract int computePay();  // 추상 메소드(Abstract Method)
	
	//인센티브 계산 메소드
	//모든 사원에게 급여의 150%를 인센티브로 제공
	//자식 클래스에서 오버라이드 선언할 수 없게 설정
	public final int computeIncentive() {
		return (int)(computePay()*INCENTIVE_RATE);
	}
	
}//class
