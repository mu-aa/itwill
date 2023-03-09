package inheritance;

//시간제 사원 정보(사원번호 사원이름 시급 근무시간)를 저장
//ㄴ Employee 클래스 상속
public class EmployeeTime extends Employee{
	private int workedHour;
	private int moneyPerHour;
	
	public EmployeeTime() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeTime(int empNo, String empName, int workedHour, int moneyPerHour) {
		super(empNo, empName);
		this.workedHour = workedHour;
		this.moneyPerHour = moneyPerHour;
	}

	public int getWorkedHour() {
		return workedHour;
	}

	public void setWorkedHour(int workedHour) {
		this.workedHour = workedHour;
	}

	public int getMoneyPerHour() {
		return moneyPerHour;
	}

	public void setMoneyPerHour(int moneyPerHour) {
		this.moneyPerHour = moneyPerHour;
	}
	
	//급여를 계산하여 반환하는 메소드
	@Override
	public int computePay() {
		return workedHour*moneyPerHour;
	}
	
}
