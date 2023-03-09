package xyz.itwill07.aop;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

import lombok.Setter;

//Java Mail 기능을 구현하기 위해서는 spring-context-support 라이브러리와 javax.mail 라이브러리가
//프로젝트에 빌드되도록 처리 - Maven 사용 : pom.xml

//메일 전송 기능을 제공하는 클래스
//ㄴ 메일 서버 : 메일을 송수신 하는 서비를 제공하는 SMTP(Simple Message Transfer Protocol) 서비스로 메일을 보내고
//POP3(Post Office Protocol) 서비스 혹은 IMAP(Internet Message Access Protocol) 서비스로 메일을 받아 사용자에게 전달
@Setter
public class EmailSendBean {
	//메일을 전송하는 서비스(SMTP)를 제공하는 메일서버의 정보가 저장된 JavaMailSender 객체를 저장하기 위한 필드 선언
	private JavaMailSender javaMailSender;
	
	//메일을 전송하는 메소드
	//ㄴ 메일을 받는 사람의 이메일 주소, 제목, 내용을 매개변수로 전달받아 저장
	//ㄴ 메일을 받는 사람의 이메일 주소를 반환
	public String sendEmail(String email, String subject, String content) throws Exception {
		//JavaMailSender.createMimeMessage() : MimeMessage 객체를 생성하여 반환하는 메소드
		//MimeMessage 객체(SMTP) : 메일 전송 관련 정보를 저장하기 위한 객체
		MimeMessage message=javaMailSender.createMimeMessage();
		
		//MimeMessage.setSubject(subject) : 전송할 메일의 제목을 변경하는 메소드
		message.setSubject(subject);
		
		//MimeMessage.setText(content) : 전송할 메일의 내용(텍스트 메소드)을 변경하는 메소드
		//message.setText(content);
		
		//MimeMessage.setContent(Object o, String type) : 전송할 메일의 내용을 변경하는 메소드
		//ㄴ type 매개변수에 문서의 형식(MimeType)을 전달하여 저장
		message.setContent(content, "text/html; charset=utf-8");
		
		//MimeMessage.setRecipient(RecipientType type, Address address) : 받는 사람의
		//이메일 주소 관련 정보를 변경하는 메소드
		//ㄴ RecipientType : 메일 수신 사용자를 구분하기 위한 상수값 전달
		//ㄴ Address : 이메일 주소가 저장된 Address 객체를 전달
		//InternetAddress : 이메일 주소를 저장하기 위한 클래스 - Address 추상 클래스를 상속받은 자식클래스
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
		
		//MimeMessage.setRecipient(RecipientType type, Address address) : 받는 사람의
		//이메일 주소 관련 정보를 변경하는 메소드
		//ㄴ RecipientType : 메일 수신 사용자를 구분하기 위한 상수값 전달
		//ㄴ Address : 이메일 주소가 저장된 Address 객체를 전달
		//InternetAddress.parse(String email) : 문자열로 전달된 이메일 주소를 Address 객체 배열로 반환
		//message.setRecipient(MimeMessage.RecipientType.TO, InternetAddress.parse(email)[0]);
		
		//JavaMailSender.send(MimeMessage message) : 메일을 보내는 서비스를 이용하여
		//메일을 전송하는 메소드
		javaMailSender.send(message);
		
		System.out.println("[메세지]이메일을 성공적으로 전송 하였습니다.");

		return email;
	}
}