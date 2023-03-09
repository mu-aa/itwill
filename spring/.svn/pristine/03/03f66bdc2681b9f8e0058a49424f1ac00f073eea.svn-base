package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring Framework에서는 BeanFactory 객체 또는 ApplicationContext 객체로 Spring Container 기능 제공
//ㄴ Spring Container는 환경설정 파일(Spring Bean Configuration File - XML)을 제공받아 객체(Spring Bean)를 관리
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1. BeanFactory 객체를 생성하여 Spring Container로 사용 - 예전 방식, 비권장");
		System.out.println("============= Spring Container 초기화 전 =============");
		//BeanFactory 인터페이스를 상속받은 클래스로 객체를 생성 - BeanFactory 객체
		//ㄴ BeanFactory 객체를 생성할 때 Spring Bean Configuration File을 제공받아
		//Spring Container 생성 - Spring Container 초기화 작업
		//ㄴ Spring Bean Configuration File 경로를 모두 표현하여 설정
		//ㄴ BeanFactory 객체는 Spring Bean Configuration File에 등록된 클래스로 미리 객체를 생성하지않고
		//Spring Bean 요청 시 객체를 생성하여 제공
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("============= Spring Container 초기화 후 =============");
		//BeanFactory.getBean(String beanName) : Spring Container에서 Spring Bean을 구분하기 위한 식별자
		//(beanId 또는 beanName)을 전달하여 객체(Spring Bean)를 생성하여 반환하는 메소드
		//ㄴ Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		//ㄴ 전달받은 식별자(beanName)에 대한 Spring Bean이 없는 경우 NoSuchBeanDefinitionException 발생
		CreateBean bean1=(CreateBean)factory.getBean("createBean");
		bean1.display();
		System.out.println("======================================================\n");
		
		
		System.out.println("★2. ApplicationContext 객체를 생성하여 Spring Container로 사용 - 권장");
		System.out.println("============= Spring Container 초기화 전 =============");
		//ApplicationContext 인터페이스를 상속받은 자식클래스로 객체를 생성 - ApplicationContext 객체
		//ㄴ ApplicationContext 객체를 생성할 때 Spring Bean Configuration File을 제공받아
		//Spring Container 생성 - Spring Container 초기화 작업
		//ㄴ 클래스가 참조 가능한 디렉토리(ClassPath)에 있는 Spring Bean Configuration File을 표현하여 설정 
		//ㄴ ApplicationContext 객체는 Spring Bean Configuration File에 등록된 클래스로
		//미리 객체를 생성하여 Spring Bean 요청 시 제공 - 웹프로그램 속도 향상
        //ClassPathXmlApplicationContext : 매개변수의 XML 파일(Spring Bean Configuration File)을
        //객체(Spring Bean)로 생성
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("============= Spring Container 초기화 후 =============");
		//★DL(Dependency Lookup) : Spring Container로부터 필요한 Spring Bean을 검색하여 제공하는 기능
		//ApplicationContext.getBean(String beanName) : Spring Container에서 Spring Bean을 구분하기 위한
		//식별자(beanName)를 전달하여 객체(Spring Bean)를 반환하는 메소드
		CreateBean bean2=(CreateBean)context.getBean("createBean");
		bean2.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext 객체를 제거하는 메소드
		//ㄴ Spring Container에 의해 관리되는 모든 객체(Spring Bean) 자동 소멸
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("======================================================");
	}
}