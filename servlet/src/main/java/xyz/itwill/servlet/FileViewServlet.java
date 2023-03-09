package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지(file_view.html)에서 전달된 입력값(올린이)과 입력파일을 반환받아 클라이언트에게 전달하는 Servlet
//ㄴ 입력페이지에서 전달된 원시데이터(멀티파트 폼데이터)를 클라이언트에게 전달하여 응답 처리
@WebServlet("/view.itwill")
public class FileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//비정상적인 요청에 대한 처리
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("file_view.html");
			return;
		}
		
		//Request Message의 Body에 대한 Charset 변경
		request.setCharacterEncoding("utf-8");
		
		//전달값을 반환받아 저장
		//ㄴ 원시데이터로 전달되는 값 또는 파일은 HttpServletRequest 객체의 getParameter() 메소드를 호출하여
		//값 또는 파일의 전달이 불가능
		
		/*
		String name=request.getParameter("name");
		String fileone=request.getParameter("fileone");
		
		//응답결과 생성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>입력값과 입력파일</h1>");
		out.println("<hr>");
		out.println("<p>올린이 = "+name+"</p>");
		out.println("<p>파일명 = "+fileone+"</p>");
		out.println("</body>");
		out.println("</html>");
		*/
		
		//HttpServletRequest.getInputStream() : Request Message의 Body에 저장되어 전달되는 원시데이터를
		//읽기위한 입력스트림을 반환하는 메소드
		ServletInputStream in=request.getInputStream();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>입력값과 입력파일</h1>");
		out.println("<hr>");
		out.println("<p>Request Message의 Body에 저장되어 전달된 원시데이터(멀티파트 폼데이터)</p>");
		out.println("<pre>");
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		out.println("</pre>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
