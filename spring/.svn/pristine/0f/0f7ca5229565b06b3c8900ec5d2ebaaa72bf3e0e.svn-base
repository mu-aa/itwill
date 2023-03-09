package xyz.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component("studentService")

//@Service : *Service 클래스를* Spring Container가 관리할 수 있는 Spring Bean으로 등록하기 위한 Annotation
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	//@Autowired : Spring Container로부터 Spring Bean을 제공받아 필드에 저장되도록 자동으로 의존관계를 구현하는 Annotation 
	//ㄴ 의존성 주입을 위해 필드에 사용하는 Annotation - 선언된 필드마다 Annotation 설정
	//ㄴ bean Element에서 autowire 속성값을 [byType]으로 설정한 것과 같은 방법으로 의존성 주입 - Setter Injection
	//ㄴ Setter 메소드를 이용하여 의존관계를 설정하지만 Setter 메소드를 작성하지 않아도 의존성 주입
	//문제점) 필드의 자료형과 같은 자료형의 Spring Bean이 2개 이상 존재할 경우 의존성 주입 실패 - NoUniqueBeanDefinitionException 발생
	//해결법-1) 필드의 자료형과 같은 자료형의 Spring Bean이 2개 이상 존재할 경우 필드에 저장될
	//Spring Bean의 식별자(beanName)를 필드명과 같은 이름으로 변경
	//ㄴ @Autowired Annotation은 필드의 자료형과 같은 자료형의 Spring Bean이 2개 이상 존재할 경우
	//bean Element에서 autowire 속성값을 [byName]으로 설정한 것과 같은 방법으로 의존성 주입
	@Autowired
	//해결법-2) 필드의 자료형과 같은 자료형의 Spring Bean이 2개 이상 존재할 경우 필드에 저장될 경우
	//Spring Bean에 대한 클래스에 @Primary Annotation을 사용하여 작성
	//해결법-3) @Qualifier Annotation을 사용하여 의존성 주입을 위한 Spring Bean 지정
	//ㄴ @Primary Annotation보다 @Qualifier Annotation의 우선순위가 더 높음
	//@Qualifier : 필드와 의존관계가 설정될 Spring Bean을 직접 지정하기 위한 Annotation
	//ㄴ @Autowired Annotation에 종속된 Annotation
	//value 속성 : 의존성 주입을 위한 Spring Bean의 식별자(beanName)를 속성값으로 설정
	//ㄴ 다른 속성이 없는 경우 속성값만 설정 가능
	//@Qualifier("annotationStudentMybatisDAO")
	@Qualifier("annotationStudentJdbcDAO")
	private StudentDAO studentDAO;
	
	//@Autowired Annotation 대신 @Resource 또는 @Inject Annotation을 사용하여 의존성 주입 가능
	//ㄴ @Autowired은 Spring Framework의 라이브러리에서 제공하는 Annotation이지만
	//@Resource, @Inject는 JDK 라이브러리에서 제공하는 Annotation
	//ㄴ @Resource 또는 @Injection Annotation은 다른 Framework에서 사용 가능
	//@Resource : bean Element에서 autowire 속성값을 [byName]으로 설정한 것과 같은 방법으로 의존성 주입하는 Annotation
	//@Inject : bean Element에서 autowire 속성값을 [byType]으로 설정한 것과 같은 방법으로 의존성 주입하는 Annotation
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스 modifyStudent(Student student) 메소드 호출 ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스 removeStudent(int num) 메소드 호출 ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스 getStudent(int num) 메소드 호출 ***");
		studentDAO.selectStudent(num);
		return null;
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl 클래스 getStudentList() 메소드 호출 ***");
		studentDAO.selectStudentList();
		return null;
	}
}