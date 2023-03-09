package inheritance;

//계약직 사원 정보(사원번호 사원이름 계약급여)를 저장
//ㄴ Employee 클래스 상속
public class EmployeeContract extends Employee{
	private int contractPay;
	
	public EmployeeContract() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeContract(int empNo, String empName, int contractPay) {
		super(empNo, empName);
		this.contractPay = contractPay;
	}

	public int getContractPay() {
		return contractPay;
	}

	public void setContractPay(int contractPay) {
		this.contractPay = contractPay;
	}
	
	//급여를 계산하여 반환하는 메소드
	@Override
	public int computePay() {
		return contractPay;
	}
}
