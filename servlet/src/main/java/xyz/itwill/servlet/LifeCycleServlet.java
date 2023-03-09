package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet(웹프로그램)은 클라이언트 요청에 의해 WAS 프로그램에 등록된 Servlet Class를 읽어
//메모리에 저장하고 Servlet 객체로 생성하여 요청 처리 메소드(doGet, doPost, service, ...)를 호출
//ㄴ 클라이언트 요청에 의한 Servlet 객체가 이미 생성되어 있는 경우 새로운 Servlet 객체를 
//생성하지 않고 기본 Servlet 객체를 사용하여 요청 처리 메소드 호출
//ㄴ WAS 프로그램이 종료되면 WAS 프로그램에 의해 관리되는 모든 Servlet 객체 소멸
//WAS 프로그램의 주요 기능 중 하나는 Servlet 객체를 관리하는 WebContainer 기능 제공
//Container : 프로그램 관련 객체(Component)의 LifeCycle을 관리(생성, 사용, 소멸) - IOC
@WebServlet("/LifeCycle.itwill")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	//생성자를 만드는 이유 : 객체 생성 시 필드에 필요한 초기값 저장
	//ㄴ Servlet을 클라이언트가 요청한 경우 WAS 프로그램이 Servlet Class로
	//Servlet 객체를 생성하기 위해 최초 1회 호출
	public LifeCycleServlet() {
		System.out.println("### LifeCycleServlet 클래스의 생성자 호출 - Servlet 객체 생성 ###");
		//name="홍길동"; //비권장
	}
	
	//★ WAS 프로그램에 의해 Servlet 객체가 생성된 후 가장 먼저 최초 1회만 호출되는 메소드
	//ㄴ 초기화 작업 관련 명령 작성(생성자와 같은 역할)
	//ㄴ Servlet은 생성자 대신 init() 메소드를 이용하여 초기화 작업 명령을 작성하는 것을 권장
	//생성자 대신 init() 메소드로 초기화 작업 명령을 작성하는 이유
	//ㄴ init() 메소드의 매개변수로 ServletConfig 객체를 전달받아 메소드에서 사용 가능
	//ServletConfig 객체 : 웹자원(WebContext)을 생성하기 위한 환경설정 관련 정보를 저장한 객체
	//ㄴ [web.xml] 파일에서 제공되는 값(<context-param>의 값)을 얻어와 Servlet Class에서 사용 가능
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("### LifeCycleServlet 클래스의 init() 메소드 호출 ###");
		//name="홍길동"; //권장
		
		//ServletConfig.getServletContext() : ServletContext 객체를 반환하는 메소드
		//ㄴ ServletContext 객체 : 웹자원 관련 정보를 저장한 객체
		//ServletConfig.getInitParameter(String name) : [web.xml] 파일에서 <context-param> Element로
		//제공되는 값을 얻어와 반환하는 메소드
		name=config.getServletContext().getInitParameter("name");
	}
	
	//WAS 프로그램에 의해 Servlet 객체가 소멸되기 전 마지막으로 최후 1회만 호출되는 메소드
	//ㄴ 마무리 작업 관련 명령 작성(사용자 정보 소멸 등..) - Java에선 gs가 자동으로 처리해서 필요없음
	//ㄴ WAS 프로그램이 종료될 경우 WAS 프로그램에 의해 관리된 모든 Servlet 객체 소멸
	@Override
	public void destroy() {
		System.out.println("### LifeCycleServlet 클래스의 destroy() 메소드 호출 ###");
	}
	
	//클라이언트 요청에 대한 처리와 처리 결과를 파일로 응답하기 위한 명령을 작성하는 메소드
	//ㄴ 클라이언트 요청마다 WAS 프로그램에 의해 Servlet 객체로 반복 호출되는 메소드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("### LifeCycleServlet 클래스의 service() 메소드 호출 ###");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>"); //출력스트림으로 문자열(HTML 태그)을 전달하여 문서파일 작성
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿의 생명주기(LifeCycle)</h1>");
		out.println("<hr>");
		out.println("<p>"+name+"님, 안녕하세요. </p>");
		out.println("</body>");
		out.println("</html>");
	}
}
