package xyz.itwill.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//[*] 패턴 문자를 사용하여 Spring Bean Configuration File 설정 가능
//ㄴ [**] 형식으로 0개 이상의 하위 폴더 표현 가능
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class StudentControllerTest {
	private static final Logger logger=LoggerFactory.getLogger(StudentControllerTest.class);
	
	//WebApplicationContext 객체를 저장하기 위한 필드 선언 - DI
	//ㄴ WebApplicationContext 객체 : SpringMvc 프로그램에서 Spring Container 역할을 제공하기 위한 객체
	@Autowired
	private WebApplicationContext context;
	
	//MockMvc 객체를 저장하기 위한 필드 선언
	//ㄴ MockMvc 객체 : 가상의 요청과 응답을 제공하기 위한 객체
	private MockMvc mvc;
	
	//@Before : 테스트 메소드 호출 전 실행될 명령을 작성한 메소드를 설정하는 Annotation - 초기화 작업
	@Before
	public void setup() {
		//MockMvcBuilders.webAppContextSetup(WebApplicationContext context)
		//ㄴ MockMvcBuilder 객체를 생성하여 반환하기 위한 메소드
		//MockMvcBuilder.build() : MockMvc 객체를 생성하여 반환하기 위한 메소드
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
		logger.info("MockMvc 객체 생성");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
		//MockMvc.perform(Builder requestBuilder) : 가상으로 페이지를 요청하는 메소드
		//ㄴ Controller 클래스에서 해당 페이지의 요청 처리 메소드 호출
		//ㄴ 요청에 대한 처리결과가 저장된 ResultActions 객체 반환
		//MockMvcRequestBuilders.get(String url) : URL 주소를 전달받아 GET 방식으로 요청하는 메소드
		//ㄴ 페이지에 대한 URL 주소의 요청 관련 정보(Request Message)가 저장된 Builder 객체 반환
		//ResultActions.andReturn() : 요청 처리 메소드의 실행 결과를 MvcResult 객체로 반환하는 메소드
		MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		
		logger.info(result.getModelAndView().getViewName());
		logger.info(result.getModelAndView().getModel().toString());
	}
}