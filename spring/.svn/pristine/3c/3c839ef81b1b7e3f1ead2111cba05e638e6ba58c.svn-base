package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanApp {
	public static void main(String[] args) {
		System.out.println("============= Spring Container 초기화 전 =============");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-2_collection.xml");
		System.out.println("============= Spring Container 초기화 후 =============");
		CollectionBean bean=context.getBean("collectionBean", CollectionBean.class);
		
		//CollectionBean 객체에 저장된 필드값을 반환받아 출력
		//ㄴ Collection 객체의 toString() 메소드 자동 호출 - Collection 객체에 저장된 모든 요소값을 문자열로 반환
		System.out.println("NameSet = "+bean.getNameSet());
		System.out.println("NameList = "+bean.getNameList());
		System.out.println("ControllerSet = "+bean.getControllerSet());
		System.out.println("ControllerList = "+bean.getControllerList());
		System.out.println("ControllerMap = "+bean.getControllerMap());
		System.out.println("ControllerProperties = "+bean.getControllerProperties());
		System.out.println("======================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}