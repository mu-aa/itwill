package xyz.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Component : 클래스를 Spring Container가 관리할 수 있는 Spring Bean으로 등록하기 위한 Annotation
//ㄴ 클래스의 이름이 beanName으로 자동 설정 - 클래스의 이름에서 첫문자는 소문자로 변환
//ㄴ @Component Annotation의 value 속성을 사용하여 beanName 변경 가능 - 다른 속성이 없는 경우 속성값만 설정 가능
//@Component

//@Repository : *DAO 클래스를* Spring Container가 관리할 수 있는 Spring Bean으로 등록하기 위한 Annotation
//ㄴ 클래스의 이름이 beanName으로 자동 설정되지만 value 속성을 사용하여 beanName 변경 가능
@Repository
//@Primary : 의존성을 주입하기 위한 우선권을 제공하기 위한 Annotation
//ㄴ 동일 자료형의 클래스에 @Primary Annotation을 사용한 경우 의존성 주입 실패
public class AnnotationStudentJdbcDAO implements StudentDAO {
	public AnnotationStudentJdbcDAO() {
		System.out.println("### AnnotationStudentJdbcDAO 클래스의 기본 생성자 호출 ###");
	}
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스 insertStudent(Student student) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스 updateStudent(Student student) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스 deleteStudent(int num) 메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스 selectStudent(int num) 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스 selectStudentList() 메소드 호출 ***");
		return null;
	}
}