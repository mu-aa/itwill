package xyz.itwill.util;

import java.util.Collections;
import java.util.List;

//학생 관리 프로그램
public class StudentManagerApp {
	public static void main(String[] args) {
		StudentManager manager=new StudentManager();
		
		//학생정보를 전달하여 저장매체(컬렉션 필드)에 저장하는 메소드 호출
		manager.addStudent(new Student("홍길동", 1000)); //일회성 객체 생성
		manager.addStudent(new Student("전우치", 3000));
		manager.addStudent(new Student("임꺽정", 2000));
		manager.addStudent(new Student("일지매", 4000));
		
		
		boolean result=manager.addStudent(new Student("장길산",5000));
		if(result) {
			System.out.println("[메세지]학생 정보를 성공적으로 저장했습니다.");
		} else {
			System.out.println("[메세지]이미 저장된 학생 정보입니다.");
		}
		System.out.println("\n===========================================================\n");
		
		
		//학번이 [2000]인 학생정보를 검색하여 출력
		Student searchStudent=manager.getStudent(2000);
		if(searchStudent==null) {
			System.out.println("[메세지]해당 학번의 학생 정보를 찾을 수 없습니다");
		} else {
			System.out.println(searchStudent);  //학생정보 출력
		}
		System.out.println("\n===========================================================\n");
		
		
		//학번이 [2000]인 학생의 이름을 [임걱정]으로 변경
		searchStudent.setName("임걱정");
		manager.modifyStudent(searchStudent);
		System.out.println("[메세지]학생 정보를 성공적으로 변경했습니다.");
		System.out.println("\n===========================================================\n");
		
		
		//학번이 [4000]인 학생정보를 저장매체에서 삭제
		if(manager.removeStudent(4000)) { //삭제될 학생 정보가 있는 경우
			System.out.println("[메세지]학생 정보를 성공적으로 삭제했습니다.");
		} else {
			System.out.println("[메세지]해당 학번의 학생 정보를 찾을 수 없습니다.");
		}
		System.out.println("\n===========================================================\n");
	
		
		//저장매체에 저장된 모든 학생 정보를 반환하는 메소드 호출
		List<Student> students=manager.getStudentList();
		
		for(Student temp:students) {
			System.out.println(temp);  //temp.[toString()]-> 생략되어 있음  ==  필드값 반환
		}
		System.out.println("\n===========================================================\n");

		//Collections.sort(List<T> list) 메소드의 매개변수에 전달되는 List 객체는 
		//요소값을 비교하기 위한 기능의 compareTo() 메소드가 오버라이드 선언되지 않은 경우 에러 발생
		Collections.sort(students);
		
		for(Student temp:students) {
			System.out.println(temp);  //temp.[toString()]-> 생략되어 있음  ==  필드값 반환
		}
		System.out.println("\n===========================================================\n");
		
	}
}
