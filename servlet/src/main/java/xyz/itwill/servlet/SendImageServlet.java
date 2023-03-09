package xyz.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트 요청에 대해 이미지 파일을 응답하기 위한 Servlet
@WebServlet("/image.itwill")
public class SendImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에게 이미지 파일이 응답되도록 설정 - 응답될 파일형식(MimeType) 변경
		//ㄴ 이미지 파일(이진 파일 - Binary File)로 응답하므로 Charset 미설정
		response.setContentType("image/png");
		
		//응답될 이미지 파일을 생성하기 위한 값(원시 데이터 - 1Byte)을 전달하는 출력스트림(ServletOutputStream 객체)
		//을 반환받아 저장
		ServletOutputStream out=response.getOutputStream();
		
		//서버에 저장된 이미지 파일의 파일 시스템 경로를 반환받아 저장
		//HttpServletRequest.getServletContext() : ServletContext 객체를 반환하는 메소드
		//ㄴ ServletContext 객체 : 클라이언트가 요청한 웹자원을 관리하기 위한 객체 - WAS
		//웹자원(WebContext) : Web Server가 사용할 수 있는 자원a- 웹 관련 문서, 이미지 파일 등
		//★ ServletContext.getRealPath(String contextPath) : 매개변수로 전달받은 웹자원 관련 파일의
		//시스템 경로를 반환하는 메소드
		String filePath=request.getServletContext().getRealPath("/WEB-INF/1.png");
		System.out.println("filePath = "+filePath);
		
		//이미지 파일을 읽기 위한 입력스트림 생성
		FileInputStream in=new FileInputStream(filePath);
		
		//입력스트림으로 원시데이터를 읽어 출력스트림으로 전달 - 반복 처리
		//ㄴ 서버에 저장된 이미지 파일을 클라이언트에게 응답되도록 생성
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		//파일 입력스트림 제거
		in.close();
	}
}
