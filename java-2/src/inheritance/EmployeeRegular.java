package inheritance;

//정규직 사원 정보(사원번호 사원이름 연봉)를 저장하기 위한 클래스
//ㄴ Employee 클래스 상속
public class EmployeeRegular extends Employee{
	private int annualSalary;
	
	public EmployeeRegular() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeRegular(int empNo, String empName, int annualSalary) {
		super(empNo, empName);
		this.annualSalary = annualSalary;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	//급여를 계산하여 반환하는 메소드
	@Override
	//추상클래스를 상속받은 자식클래스에서는 반드시 부모클래스의 모든 추상메소드를 오버라이드 선언해야 함.
	//ㄴ추상메소드를 오버라이드 선언하지 않은 자식클래스는 추상클래스로 설정 가능 - 비권장
	public int computePay() {
		return annualSalary/12;	
	}
	
	/*   final 메소드로 오버라이드를 제한함
  	@Override 
	public int computeIncentive() { 
		return 10000;
	}
	*/
	
	
}
