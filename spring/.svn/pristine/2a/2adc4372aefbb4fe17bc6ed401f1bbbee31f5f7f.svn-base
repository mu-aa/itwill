package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailSendApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("06-4_email.xml");
		EmailSendBean bean=context.getBean("emailSendBean", EmailSendBean.class);
		System.out.println("===========================================================");
		bean.sendEmail("alswo9234@naver.com", "Email Test", "JavaMail 기능을 사용하여 전달된 이메일입니다.");
		System.out.println("===========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}