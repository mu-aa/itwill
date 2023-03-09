package xyz.itwill.student;

import java.util.List;

//DAO 클래스가 반드시 상속받아야 할 인터페이스
//ㄴ 추상메소드를 이용해 모든 DAO 클래스가 동일한 형태로 작성되도록 메소드 작성 규칙 제공
public interface StudentDAO {
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	//ㄴ DAO 클래스에서 학생정보를 전달받아 더 효율적으로 프로그램 작성
	//int insertStudent(int no, String name, String phone, String address, String birthday);
	
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	int insertStudent(StudentDTO student);
	
	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	int updateStudent(StudentDTO student);
	
	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	int deleteStudent(int no);
	
	//★학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 메소드 
	StudentDTO selectNoStudent(int no); //★유일한 하나의 행(단일행)만 검색
	
	//★이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생목록을 검색하여 반환하는 메소드
	List<StudentDTO> selectNameStudentList(String name); //★여러 개의 행들(다중행)을 검색
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	List<StudentDTO> selectAllStudentList();
}
