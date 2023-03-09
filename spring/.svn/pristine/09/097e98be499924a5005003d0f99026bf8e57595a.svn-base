package xyz.itwill03.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object=new HelloMessageObject();
		MessagePrint print=new MessagePrint();
		print.setObject(object);
		print.messagePrint();
		*/
		
		//ApplicationContext 객체(Spring Container 기능을 제공하는 객체) 생성
		//ㄴ Spring Bean Configuration File을 제공받아 Spring Bean을 생성하여 관리
		ApplicationContext context=new ClassPathXmlApplicationContext("03_message.xml");
		
		//Spring Container로부터 필요한 Spring Bean을 제공받아 저장
		//ㄴ Spring Bean을 구분하기 위한 식별자(beanName 또는 beanId)를 전달
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		
		print.messagePrint();
		
		//Spring Container 제거
		((ClassPathXmlApplicationContext)context).close();
	}
}