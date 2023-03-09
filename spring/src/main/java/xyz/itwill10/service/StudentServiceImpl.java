package xyz.itwill10.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.StudentDAO;
import xyz.itwill10.dto.Student;

//Service 클래스 : 요청 처리 메소드에서 데이터 처리 관련 기능을 모듈화하여 제공하기 위한 객체를 생성하는 클래스
//ㄴ Service 클래스의 메소드에서는 데이터 처리에 필요한 다수의 DAO 클래스의 메소드를 호출하여
//프로그램이 필요한 데이터 처리 기능을 모듈화하여 제공하도록 작성
//ㄴ Service 클래스가 변경돼도 의존관계가 설정된 Controller 클래스에 영향을 최소화하기 위해 인터페이스 작성

//Service 클래스는 Controller 클래스의 객체로 제공받아 사용되도록 반드시 Spring Bean으로 등록
//ㄴ Service 클래스는 @Service Annotation을 사용하여 Spring Bean으로 등록되도록 처리
//ㄴ @Service Annotation을 사용하여 TransactionManager 객체에 의해 트랜젝션 관리 가능
//ㄴ @Service Annotation을 Spring Container가 처리하기 위해서는 반드시 클래스를 작성한 패키지를
//Spring Bean Configuration File(servlet-context.xml)의 component-scan Element로 검색되도록 설정
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	//Service 클래스의 메소드에서 사용될 DAO 객체를 저장하기 위한 필드 선언
	//ㄴ @Autowired Annotation을 사용한 생성자로 필드에 Injection 처리
	private final StudentDAO studentDAO;
	
	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}
}