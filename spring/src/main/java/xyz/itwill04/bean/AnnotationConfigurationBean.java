package xyz.itwill04.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration : Spring Container에 의해 관리될 객체(Spring Bean)을 생성하여 반환하는 메소드를
//작성하기 위한 클래스를 설정하기 위한 Annotation
//ㄴ Spring Bean Configuration File과 유사한 기능을 제공하는 클래스로 설정하기 위해 사용
@Configuration
public class AnnotationConfigurationBean {
	//@Bean : Spring Bean으로 등록하기 위한 메소드에 설정하는 Annotation
	//ㄴ @Bean Annotation을 사용한 메소드는 클래스를 객체로 생성하여 반환 - Spring Bean
	//ㄴ bean Element와 유사한 기능을 제공하는 Annotation
	//ㄴ 기본적으로 메소드의 이름을 Spring Bean의 식별자(beanName)로 사용
	//ㄴ @Bean Annotation의 name 속성을 사용하여 식별자 변경 가능
	@Bean
	public AnnotationBean annotationBean() {
		return new AnnotationBean();
	}
}