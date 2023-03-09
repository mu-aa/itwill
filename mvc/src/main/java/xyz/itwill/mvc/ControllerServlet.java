package xyz.itwill.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러(Controller - Servlet) : 클라이언트의 모든 요청을 받아 모델(Model - Class)의 
//요청 처리 메소드를 호출하여 요청을 처리하고 처리결과를 뷰(View - JSP)로 전달받아 응답되도록
//제어하는 웹프로그램

//●1. 클라이언트의 모든 요청을 받을 수 있도록 Servlet을 설정하여 단일 진입점의 기능 구현 - Front Controller Pattern
//@WebServlet(URL) : Servlet Class를 웹프로그램(Servlet)으로 등록하고 요청 URL 주소를 Mapping하는 Annotation
//ㄴ Mapping 설정될 URL 주소에 패턴문자(*:전체 OR ?:문자 하나)를 사용하여 URL 패턴 등록 가능
//ㄴ @WebServlet("*.do") : 클라이언트가 [XXX.do] 형식의 URL 주소로 요청한 경우 Servlet 실행
//ㄴ @WebServlet 대신 [web.xml] 파일에서 Servlet Class를 웹프로그램(Servlet)으로 등록하고 URL 주소 Mapping 처리 가능
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//요청정보(Key - String)와 Model 객체(Value - Action)를 하나의 요소(Entry)로 묶어 여러 개
	//저장하기 위한 Map 객체를 저장하는 필드
	//ㄴ Map 객체를 이용하여 요청정보(Key)로 Model 객체(Value)를 빠르게 제공받기 위해 사용
	private Map<String, Action> actionMap;
	
	//클라이언트 최초 요청에 의해 Servlet 객체가 생성된 후 가장 먼저, 최초 1회만 호출되는 메소드
	//ㄴ Servlet 객체의 초기화 작업을 위해 Overried 선언
	@Override
	public void init(ServletConfig config) throws ServletException{
		actionMap=new HashMap<String, Action>();
		
		/*
		//Map 객체에 엔트리(Entry - Key : 요청정보, Value : Model 객체) 추가
		actionMap.put("/loginForm.do", new LoginFormModel());
		actionMap.put("/login.do", new LoginModel());
		actionMap.put("/logout.do", new LogoutModel());
		actionMap.put("/writeForm.do", new WriteFormModel());
		actionMap.put("/write.do", new WriteModel());
		actionMap.put("/list.do", new ListModel());
		actionMap.put("/view.do", new ViewModel());
		actionMap.put("/modifyForm.do", new ModifyFormModel());
		actionMap.put("/modify.do", new ModifyModel());
		actionMap.put("/remove.do", new RemoveModel());
		actionMap.put("/error.do", new ErrorModel());
		*/
		
		//Properties 파일에 요청정보와 Model Class를 저장하고 파일을 읽어 Map 객체의 Entry 추가
		//ㄴ 유지보수의 효율성 증가 - Controller를 변경하지 않고 요청정보와 Model 객체 변경 가능
		//Properties 파일(XXX.properties) : 프로그램 실행에 필요한 값을 제공하기 위한 텍스트 파일
		
		//Properties 파일의 정보를 저장하기 위한 Properties 객체 생성
		Properties properties=new Properties();
		
		//ServletConfig.getInitParameter(String name) : [web.xml] 파일에서 init-param Element로
		//제공되는 값을 읽어와 반환하는 메소드
		String configFile=config.getInitParameter("configFile");
		
		//Properties 파일의 시스템 경로를 반환받아 저장
		String configFilePath=config.getServletContext().getRealPath(configFile);
		
		try {
			//Properties 파일에 대한 입력스트림을 생성하여 저장
			FileInputStream in=new FileInputStream(configFilePath);
			
			//Properties.load() : 입력스트림을 사용하여 Properties 파일의 내용을 읽어 Properties 객체에 Entry로 저장
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Properties 객체의 모든 Key를 반환받아 반복 처리
		//Properties.keySet() : Properties 객체에 저장된 모든 Entry의 Key를 Set 객체로 반환하는 메소드
		for(Object key:properties.keySet()) { //Set 객체로부터 요소를 하나씩 제공받아 반복 처리
			//Properties 객체에 저장된 Entry의 Key - 요청정보
			String actionCommand=(String)key;
			
			//Properties 객체에 저장된 Entry의 Value - Model Class
			String actionClass=(String)properties.get(key);
			
			try {
				//Model Class를 이용하여 Model 객체 생성 - 리플렉션 기능 사용
				//★리플렉션(Reflection) : 프로그램 실행 시 [메모리에 저장된 클래스(Clazz)]를 읽어 객체를 생성하고
				//객체의 필드 또는 메소드에 접근(접근지정자 상관없이) 가능하도록 제공하는 기능
				//Class.forName(String className) : 문자열로 표현된 클래스를 전달받아 클래스를 읽어
				//메모리에 저장하고 Class 객체(Clazz)를 반환하는 메소드 - ClassNotFoundException 발생
				//Class.getDeclaredConstructor() : 메모리에 저장된 Clazz의 생성자가 저장된
				//Constructor 객체를 반환하는 메소드
				//Constructor.newInstance() : Constructor 객체에 저장된 생성자를 이용하여
				//Object 타입의 객체를 생성하여 반환하는 메소드
				Action actionObject=(Action)Class.forName(actionClass).getDeclaredConstructor().newInstance();
				
				//Map 객체에 엔트리(Entry - Key : 요청정보, Value : Model 객체) 추가
				actionMap.put(actionCommand, actionObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//for
	}//init
	
	//클라이언트의 요청을 처리하기 위해 자동 호출되는 메소드
	//ㄴ 클라이언트가 Servlet(웹프로그램)을 요청할 때 마다 Servlet 객체를 이용하여
	//반복적으로 호출
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//●2. 클라이언트 요청 분석 : 요청 URL 주소 이용 - http://localhost:8000/mvc/XXX.do
		//HttpServletRequest.getRequestURI() : 요청 URL 주소에서 URI 주소를 반환하는 메소드
		String requestURI=request.getRequestURI(); //requestURI = /mvc/XXX.do
		
		//HttpServletRequest.getContextPath() : 요청 URL 주소에서 Context 경로를 반환하는 메소드
		String contextPath=request.getContextPath(); //contextPath = /mvc
		
		//클라이언트 요청에 대한 요청값을 반환받아 저장
		String command=requestURI.substring(contextPath.length()); //command = /XXX.do
		
		//●3. 클라이언트 요청을 Model을 사용하여 처리하고 View 관련 정보를 반환받아 저장
		//ㄴ Model 역할의 Java Class로 객체를 생성하여 요청 처리 메소드 호출
		//ㄴ 하나의 요청에 대해 하나의 Model이 처리하도록 설정 - Command Controller Pattern
		//회원관리 프로그램에서 클라이언트 요청에 대한 모델 객체가 Mapping 되도록 설계
		//ㄴ 로그인정보 입력페이지(환영메세지 출력페이지) - /loginForm.do >> LoginFormModel Class
		//ㄴ 로그인 처리페이지 - /login.do >> LoginModel Class
		//ㄴ 로그아웃 처리페이지 - /logout.do >> LogoutModel Class
		//ㄴ 회원정보 입력페이지 - /writeForm.do >> WriteFormModel Class
		//ㄴ 회원정보 삽입페이지 - /write.do >> WriteModel Class
		//ㄴ 회원목록 출력페이지 - /list.do >> ListModel Class
		//ㄴ 회원정보 출력페이지 - /view.do >> ViewModel Class
		//ㄴ 변경회원정보 입력페이지 - /modifyForm.do >> ModifyFormModel Class
		//ㄴ 회원정보 변경페이지 - /modify.do >> ModifyModel Class
		//ㄴ 회원정보 삭제페이지 - /remove.do >> RemoveModel Class
		//ㄴ 에러메세지 출력페이지 - /error.do >> ErrorModel Class
		
		//Model 클래스가 상속받은 인터페이스를 이용하여 참조변수 선언
		//ㄴ 참조변수에는 인터페이스를 상속받은 모든 자식클래스(Model)로 생성된 객체 저장 가능
		/*
		Action action=null;
		
		if(command.equals("/loginForm.do")) {
			action=new LoginFormModel();
		} else if (command.equals("/login.do")) {
			action=new LoginModel();
		} else if (command.equals("/logout.do")) {
			action=new LogoutModel();
		} else if (command.equals("/writeForm.do")) {
			action=new WriteFormModel();
		} else if (command.equals("/write.do")) {
			action=new WriteModel();
		} else if (command.equals("/list.do")) {
			action=new ListModel();
		} else if (command.equals("/view.do")) {
			action=new ViewModel();
		} else if (command.equals("/modifyForm.do")) {
			action=new ModifyFormModel();
		} else if (command.equals("/modify.do")) {
			action=new ModifyModel();
		} else if (command.equals("/remove.do")) {
			action=new RemoveModel();
		} else { //요청에 대한 Model Class가 없는 경우
			action=new ErrorModel();
		}
		*/
		
		//Map 객체에 저장된 Entry에서 요청정보(Key)를 이용하여 Model 객체(Value)를 반환받아 저장
		//ㄴ 메모리 효율 및 가독성 증가
		Action action=actionMap.get(command);
		if(action==null) { //참조변수의 요청에 대한 Model 객체가 저장되어있지 않은 경우
			action=actionMap.get("/error.do");
		}
		
		//인터페이스 참조변수를 이용하여 추상메소드를 호출하면 참조변수에 저장된 Model 객체에
		//Override 선언된 요청 처리 메소드 호출 - Override에 의한 다형성
		//ㄴ 요청 처리 메소드에 의해 요청 처리 후 응답 관련 정보가 저장된 ActionForward 객체를 반환받아 저장
		ActionForward actionForward=action.execute(request, response);
		
		//●4. 응답 관련 정보를 저장된 ActionForward 객체를 이용하여 응답 처리
		if(actionForward.isForward()) { //ActionForward 객체의 forward 필드값이 [true]인 경우 - Forward 이동
			//Controller에서 View(XXX.jsp)로 Thread를 이동하여 처리결과(HTML 문서)를 클라이언트에게 전달하여 응답
			request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
		} else { //ActionForward 객체의 forward 필드값이 [false]인 경우 - Redirect 이동
			//Controller에서 클라이언트에게 요청 URL 주소(XXX.do)를 전달하여 재요청하도록 응답
			response.sendRedirect(actionForward.getPath());
		}
	}
}