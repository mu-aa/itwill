package oop;

//객체배열, 스태틱

public class StudentApp {
	public static void main(String[] args) {
		
		Student student1=new Student(1000,"홍길동",90,90);
		Student student2=new Student(2000,"임꺽정",92,92);
		Student student3=new Student(3000,"전우치",94,94);
		Student student4=new Student(4000,"일지매",96,96);
		Student student5=new Student(5000,"장길산",98,98);
		/*
		 * student1.calcTot();
		 * student2.calcTot();
		 * student3.calcTot();
		 * student4.calcTot();
		 * student5.calcTot();
		 */
		
		student1.display();
		student2.display();
		student3.display();
		student4.display();
		student5.display();
		
		System.out.println();
		
		student1.setKor(100); // 내용이 변경 된 경우
//		student1.calcTot();      다시 합계 계산을 해줘야 정상반영됨,   setter에 추가해서 중복성 최소화
		student1.display();
		System.out.println("\n==========================================================\n");
		
		
		//객체를 저장할 수 있는 (참조)요소가 5개인 배열 생성 ==> 객체 5개x, 객체가 5개 들어갈 수 있는 자리를 5개 생성
		Student[] students=new Student[5];
		
		//객체 배열 생성(5개)
		students[0]=new Student(1000,"홍길동",90,90);
		students[1]=new Student(2000,"임꺽정",92,92);
		students[2]=new Student(3000,"전우치",94,94);
		students[3]=new Student(4000,"일지매",96,96);
		students[4]=new Student(5000,"장길산",98,98);
		
		//null이 저장된 참조변수를 사용하여 메소드를 호출한 경우 NullPointerException 발생
		for(int i=0;i<students.length;i++) {  // 배열로 일괄처리
			if(students[i]!=null) {   // NullPointerException 방지
			students[i].display();
			}
		}
		System.out.println("\n==========================================================\n");
		
		
		Student[] arr= {
				new Student(1000,"홍길동",90,90),
				new Student(2000,"임꺽정",91,91),
				new Student(3000,"전우치",92,92),
				new Student(4000,"일지매",93,93),
				new Student(5000,"장길산",94,94)
			};
		
//		int result=0; // 모든 학생들의 합계를 저장
		
		for(Student temp:arr) {
			temp.display();
//			result+=temp.getTot(); // 학생 총점을 반환받아 result에 누적 저장
			//정적메소드는 클래스를 이용하여 호출
			//형식) 클래스명.메소드명(값, 값, ...);
			// ㄴ 정적 필드의 접근 지정자가 private인 경우 접근 불가능
			//Student.result+=temp.getTot();
			Student.setResult(Student.getResult()+temp.getTot());
		}
		System.out.println("\n==========================================================\n");
		System.out.println("총합계 = "+Student.getResult());
		System.out.println("\n==========================================================\n");
		
	}//main
}//class
