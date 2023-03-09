package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		System.out.println("============= Spring Container 초기화 전 =============");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-1_di.xml");
		
		System.out.println("============= Spring Container 초기화 후 =============");
		Student student1=context.getBean("student1", Student.class);
		//Student 클래스의 toString() 메소드 자동 호출 - 객체 필드값 확인
		System.out.println(student1);
		
		System.out.println("======================================================");
		Student student2=context.getBean("student2", Student.class);
		System.out.println(student2);
		
		System.out.println("======================================================");
		Student student3=context.getBean("student3", Student.class);
		System.out.println(student3);
		
		System.out.println("======================================================");
		Student student4=context.getBean("student4", Student.class);
		System.out.println(student4);
		
		System.out.println("======================================================");
		Student student5=context.getBean("student5", Student.class);
		System.out.println(student5);
		
		System.out.println("======================================================");
		Student student6=context.getBean("student6", Student.class);
		System.out.println(student6);
		
		System.out.println("======================================================");
		//프로그램 실행에 필요한 데이터 처리 기능은 Service 클래스의 메소드를 호출하여 사용
		//ㄴ Spring Container에게 Service 클래스의 객체를 제공받아 메소드 호출
		//StudentServiceImpl service=context.getBean("studentServiceImpl", StudentServiceImpl.class);
		
		//클래스보다 인터페이스로 참조변수를 생성하여 객체를 반환받아 저장하는 것이 유지보수 효율성 증가
		//ㄴ 인터페이스로 반환받기 위한 객체의 형변환 가능
		StudentService service=context.getBean("studentServiceImpl", StudentServiceImpl.class);

		service.addStudent(student1);
		service.modifyStudent(student1);
		service.removeStudent(1000);
		service.getStudent(100);
		service.getStudentList();
		System.out.println("======================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}