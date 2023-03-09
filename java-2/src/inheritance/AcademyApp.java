package inheritance;

//학원인적자원(학생,강사,직원) 관리 프로그램 (객체 형변환)
public class AcademyApp {
	public static void main(String[] args) {
		/*
		//학생정보를 저장하기 위한 요소들이 존재하는 배열 생성
		// => 배열 참조요소에 학생정보만 저장 가능
		AcademyStudent[] students=new AcademyStudent[300];
		
		//강사정보를 저장하기 위한 요소들이 존재하는 배열 생성
		// => 배열 참조요소에 강사정보만 저장 가능
		AcademyInstructor[] instructors=new AcademyInstructor[50];
		 
		//직원정보를 저장하기 위한 요소들이 존재하는 배열 생성
		// => 배열 참조요소에 직원정보만 저장 가능
		AcademyStaff[] staffs=new AcademyStaff[100];
		*/
//		                ↓↓↓↓↓↓
		//사람정보를 저장하기 위한 요소들이 존재하는 배열 생성
		// => 배열 참조요소에 학생정보,강사정보,직원정보 저장 가능
		// => 부모클래스의 참조변수에는 자식클래스의 생성자로 객체를 만들어 저장 가능 => 웬만하면 부모클래스에서 객체배열 생성
		AcademyPerson[] persons=new AcademyPerson[5];
		
		//자식클래스의 생성자로 객체를 생성하면 부모클래스의 객체 생성 후 자식클래스의 객체 생성
		// => 배열의 참조요소는 부모클래스의 객체가 저장되어 참조되므로 부모클래스의 메소드 호출
		// => 객체 형변환을 이용하면 배열의 참조요소로 자식클래스 객체를 참조하여 자식클래스의 메소드 호출 가능 
		persons[0]=new AcademyStudent(1000, "홍길동", "웹개발자 과정");
		persons[1]=new AcademyInstructor(2000, "임꺽정", "Java 과목");
		persons[2]=new AcademyStaff(3000, "전우치", "운영관리팀");
		persons[3]=new AcademyStudent(4000, "일지매", "웹디자인 과정");
		persons[4]=new AcademyStaff(5000, "장길산", "경영회계팀");
		
		for(AcademyPerson temp:persons) {
			// 오버라이드 선언되지 않은 자식클래스의 메소드를 호출하기 위해서는 명시적 객체
			// 형변환을 이용하여 참조변수에 자식클래스의 객체가 일시적으로 저장하여 호출
			// 문제점) 상속관계가 아닌 클래스로 명시적 객체 형변환 할 경우 ClassCastException 발생
			// 해결법) 참조변수로 객체 형변환 가능한 클래스를 확인한 후 명시적 객체 형변환하여 사용
			// => instanceof 연산자 사용
			// 형식)참조변수 instanceof 클래스명
			// => 참조변수로 참조 가능한 클래스인가? 를 확인하여 거짓(false) 또는 참(true)중 하나를 제공
			if(temp instanceof AcademyStudent) {
				System.out.println(((AcademyStudent)temp).getCourse()+ "의 학생정보 >> ");
			} else if(temp instanceof AcademyInstructor) {
				System.out.println(((AcademyInstructor)temp).getSubject()+ "의 강사정보 >> ");
			} else if(temp instanceof AcademyStaff) {
				System.out.println(((AcademyStaff)temp).getDepart()+ "의 직원정보 >> ");
			}
			
			// 오버라이드 선언된 메소드는 묵시적 객체 형변환에 의해 부모클래스의 메소드를 
			//호출하지 않고 자식클래스의 메소드 호출
			// => 묵시적 객체 형변환으로 인해 참조변수에는 //일시적//으로 자식클래스의 객체가
			//자동 저장되어 자식클래스의 메소드 호출
			// 참조변수에 저장된 자식클래스의 객체에 의해 다른 클래스의 메소드 호출
			// => 오버라이드에 의한 다형성 : 객체 형변환에 의해 참조변수에 저장된 객체에 따라
			//다른 클래스의 메소드를 선택 호출
			// ㄴ 각각의 자식 클래스에 오버라이드 된 display 메소드가 있기 때문에 묵시적 객체 형변환으로 인해 그것을 호출
			
			temp.display(); //
			System.out.println("==========================================================");
		}
		
		
		
	}
}	