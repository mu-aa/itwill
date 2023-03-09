package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.PhonebookDAO;
import xyz.itwill.dto.PhonebookDTO;

//PHONEBOOK 테이블에 저장된 모든 회원정보를 검색하여 클라이언트에게 전달하는 Servlet - DAO
@WebServlet("/new.itwill")
public class PhonebookNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//PHONEBOOK 테이블에 저장된 모든 회원정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
		List<PhonebookDTO> phonebookList=PhonebookDAO.getDAO().selectPhonebookList();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>전화번호부</h1>");
		out.println("<hr>");
		out.println("<table border='1' cellspacing='0'>");
		out.println("<tr>");
		out.println("<th width='200'>전화번호</th>");
		out.println("<th width='200'>이름</th>");
		out.println("<th width='300'>주소</th>");
		out.println("</tr>");
		//List 객체에 저장된 요소를 반복적으로 제공받아 클라이언트에게 전달
		for(PhonebookDTO phonebook:phonebookList) {
			out.println("<tr align='center'>");
			out.println("<td>"+phonebook.getPhone()+"</td>");
			out.println("<td>"+phonebook.getName()+"</td>");
			out.println("<td>"+phonebook.getAddress()+"</td>");
			out.println("</tr>");		
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}