package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("============= Spring Container 초기화 전 =============");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
		
		System.out.println("============= Spring Container 초기화 후 =============");
		//ApplicationContext.getBean(String beanName) : 스프링 컨테이너에게 Spring Bean를 구분
		//하기 위한 식별자(beanName)을 전달하여 객체(Spring Bean)를 반환하는 메소드
		//ㄴ Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		//InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");
		
		//ApplicationContext.getBean(String beanName, Class<T> clazz) : 스프링 컨테이너에게 
		//Spring Bean를 구분하기 위한 식별자(beanName)와 Class 객체(Clazz)를 전달하여 원하는 
		//클래스 타입의 객체(Spring Bean)로 변환하여 반환하는 메소드

		InitDestroyMethodBean bean=context.getBean("initDestroyMethodBean", InitDestroyMethodBean.class);
		
		//bean.init();
		bean.display();
		//bean.destroy();
		
		System.out.println("======================================================");
		context.getBean("lazyInitBean", LazyInitBean.class);
		System.out.println("======================================================");
		ScopeBean bean1=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean2=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean3=context.getBean("singletonBean", ScopeBean.class);
		System.out.println("bean1 = "+bean1);
		System.out.println("bean2 = "+bean2);
		System.out.println("bean3 = "+bean3);

		ScopeBean bean4=context.getBean("prototypeBean", ScopeBean.class);
		ScopeBean bean5=context.getBean("prototypeBean", ScopeBean.class);
		ScopeBean bean6=context.getBean("prototypeBean", ScopeBean.class);
		System.out.println("bean4 = "+bean4);
		System.out.println("bean5 = "+bean5);
		System.out.println("bean6 = "+bean6);
		System.out.println("======================================================");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("======================================================");
	}
}