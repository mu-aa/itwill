package inheritance;

//사원(정규직, 시간제, 계약직)급여 관리 프로그램
public class EmployeeApp {
	public static void main(String[] args) {
		
//		Employee.employee=new Employee();  추상클래스라 객체 생성 시 에러 발생
		
		/*  추상클래스(부모클래스)로 참조변수를 생성하여 모든 자식클래스의 객체 저장 가능
		 * Employee employee1=new EmployeeRegular(); 
		 * Employee employee2=newEmployeeContract();   //배열화 하는게 효율적
		 * Employee employee3=new EmployeeTime();             │    
		 */											//        │		
		//모든 사원 정보 저장								  │
		Employee[] empArray=new Employee[5];        //      ←┘
		
		empArray[0]=new EmployeeRegular(1000,"홍길동",96_000_000);
		empArray[1]=new EmployeeTime(2000,"임꺽정",50_000,150);
		empArray[2]=new EmployeeContract(3000,"전우치",7_000_000);
		empArray[3]=new EmployeeTime(4000,"일지매",20_000,100);
		empArray[4]=new EmployeeRegular(5000,"장길산",60_000_000);
		
		//모든 사원 정보 출력
		for(Employee temp:empArray) {
			System.out.println("사원번호 = "+temp.getempNo());
			System.out.println("사원이름 = "+temp.getempName());
			//부모의 객체만 참조 가능해서 자식의 메소드 호출 불가능
			//명시적 객체 형변환을 사용해 자식 객체의 메소드 호출
			
			/*
			 * //instanceof 연산자 사용 (오버라이드 x) -- 명시적 객체 형변환, ClassCastException 유의
			 * if(temp instanceof EmployeeRegular) {
			 * System.out.println("급여 = "+((EmployeeRegular)temp).computeRegular()); 
			 * } else if (temp instanceof EmployeeTime) {
			 * System.out.println("급여 = "+((EmployeeTime)temp).computeTime()); 
			 * } else if (temp instanceof EmployeeContract) {
			 * System.out.println("급여 = "+((EmployeeContract)temp).computeContract()); }
			 * 
			 * System.out.println("\n====================================\n");
			 */
			
			System.out.println("급여 = "+temp.computePay());  //부모, 자식클래스에 오버라이딩 해놨을 때 묵시적 객체 형변환 가능
			
			//사원의 인센티브를 반환받아 출력
			System.out.println("인센티브 = "+temp.computeIncentive());
			System.out.println("\n====================================\n");
		}//for
		
		
		
		
	}//main
}//class
