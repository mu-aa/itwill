package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션(Annotation) : API 문서에 특별한 설명을 제공하기 위해 만들어진 기능
//ㄴ 프로그램의 작성에 필요한 특별한 의미를 제공하거나 실행에 필요한 기능 제공

//@WebServlet : Servlet Class를 Servlet으로 등록하고 URL 주소를 Mapping하기 위한 Annotation
//ㄴ [web.xml] 파일의 <servlet> Element(태그)와 <servlet-mapping> Element가 제공하는 기능과 동일한 효과
//@WebServlet Annotation 속성을 사용하여 Servlet의 이름과 요청 URL 주소를 설정
//ㄴ name 속성(설정) : Servlet의 이름을 속성값으로 설정 - 속성과 속성값을 생략하면 클래스명을 Servlet 이름으로 자동 설정
//ㄴ value 속성(필수) : 요청 URL 주소를 속성값으로 설정 - 다른 속성이 없는 경우 속성값만 설정 가능
@WebServlet(name="first", value="/first.itwill")
//@WebServlet("/first.itwill")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//클라이언트의 모든 요청방식에 의한 요청을 처리(service)하기 위해 자동 호출되는 메소드 - 요청 처리 메소드
	//ㄴ 클라이언트 요청에 대한 처리 명령과 응답결과를 생성하기 위한 명령 작성
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에게 응답할 결과에 대한 파일형식과 응답파일을 생성하기 위한 출력스트림을 반환받아 저장
		//ㄴ 클라이언트 요청에 대한 응답결과를 파일로 생성하지 않을 경우 생략 가능
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//요청에 대한 처리와 응답을 위한 결과파일 생성
		//ㄴ js : CSL, 클라이언트의 시간을(개인차가 있을 수 있음) 불러옴 
		//ㄴ servlet : SSL, 서버의 시간을(모든 클라이언트에게 일관성 있는 처리 결과) 불러옴
		//Date 객체 생성 - 서버 시스템의 날짜와 시간이 저장된 Date 객체 생성
		Date now=new Date();
		
		//날짜와 시간 관련 패턴정보가 저장된 SimpleDateFormat 객체 생성
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		//SimpleDateFormat 객체의 format() 메소드를 호출하여 매개변수로 전달받은 Date 객체를
		//SimpleDateFormat 객체의 저장된 패턴의 날짜와 시간 형식의 문자열로 변환하여 반환
		String displayNow=dateFormat.format(now); 
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("<style type=\"text/css\">");
		out.println("p {");
		out.println("width: 600px;");
		out.println("margin: 0 auto;");
		out.println("padding: 30px 0;");
		out.println("font-size: 2em;");
		out.println("font-weight: bold;");
		out.println("text-align: center;");
		out.println("border: 2px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("<script type='text/javascript'>");
		out.println("setInterval(function() { location.reload(); }, 1000);");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿 시계</h1>");
		out.println("<hr>");
		out.println("<p>"+displayNow+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
