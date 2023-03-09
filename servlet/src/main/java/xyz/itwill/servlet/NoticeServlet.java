package xyz.itwill.servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//오늘 날짜의 공지사항 파일을 읽어 파일내용을 웹문서로 생성하여 클라이언트에게 전달하는 서블릿
// => 오늘 날짜의 공지사항 파일이 없는 경우 클라이언트에게는 공지사항이 없음을 알리는 웹문서 전달
// => 공지사항 파일은 /WEB-INF/notice 폴더에 년월일(yyyyMMdd.txt)을 이용하여 작성
@WebServlet("/notice.itwill") //어노테이션을 이용한 매핑(Servlet Class -> Servlet(웹프로그램) 변환)
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		/*
		//서버 시스템의 현재 날짜와 시간이 저장된 Date 객체 생성
		Date now=new Date();
		//[yyyyMMdd] 형식의 패턴이 저장된 SimpleDateFormat 객체 생성
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
		//SimpleDateFormat 객체를 이용하여 Date 객체에 저장된 날짜와 시간을 특정 패턴의 문자열로 변환
		String nowString=dateFormat.format(now);
		//공지사항 파일의 이름 생성
		String noticeFileName=nowString+".txt";
		*/
		
		String noticeFileName=new SimpleDateFormat("yyyyMMdd").format(new Date())+".txt";
		//System.out.println("noticeFileName = "+noticeFileName);
		
		//공지사항 파일의 시스템 경로를 반환받아 저장
		String noticeFilePath=request.getServletContext().getRealPath("/WEB-INF/notice/"+noticeFileName);
		//System.out.println("noticeFilePath = "+noticeFilePath);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 style='text-align: center;'>공지사항</h1>");
		out.println("<hr>");
		String displayNow=new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
		out.println("<p style='text-align: center;'>"+displayNow+"의 공지사항</p>");
		try {
			//공지사항 파일을 읽기 위한 입력스트림 생성
			// => 공지사항 파일이 없는 경우 FileNotFoundException 발생
			BufferedReader in=new BufferedReader(new FileReader(noticeFilePath));
			
			//공지사항 파일을 읽어 클라이언트에게 응답할 문서에 전달하여 저장
			while(true) {
				String text=in.readLine();//공지사항 파일에 저장된 내용을 한 줄 읽어 변수에 저장
				if(text==null) break;
				if(text.equals("")) text="&nbsp;";
				out.println("<div>"+text+"</div>");//응답파일에 전달
			}
			
			in.close();//파일 입력스트림 제거
		} catch (FileNotFoundException e) {
			out.println("<p>오늘은 공지사항이 없습니다.");
		}
		out.println("<hr>");
		out.println("<div style='text-align: center;'>");
		out.println("<button type='button' onclick='window.close();'>닫기</button>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}