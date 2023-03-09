<%@page import="java.io.File"%>
<%@page import="xyz.itwill.dao.ProductDAO"%>
<%@page import="xyz.itwill.dto.ProductDTO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 제품정보를 전달받아 PRODUCT 테이블에 삽입하고 제품목록 출력페이지(product_manager.jsp)로 이동하기 위한 
URL 주소를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 제품 관련 이미지는 서버 디렉토리에 저장하고 PRODUCT 테이블에서 업로드된 이미지 파일명 저장 --%>
<%-- ㄴ 관리자만 요청 가능한 JSP 문서 --%>
<%-- ㄴ 입력페이지에서 전달된 [multipart/form-data]를 처리하기 위해 cos 라이브러리의 클래스 사용 --%>
<%@include file="/security/admin_check.jspf" %>
<%
	//비정상적인 요청 응답 처리
	if(request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400';");
		out.println("</script>");
		return;
	}

	//★ 전달받은 파일을 저장하기 위한 서버 디렉토리의 파일 시스템 경로를 반환받아 저장
	//ㄴ 작업디렉토리(workspace)가 아닌 웹디렉토리(apache-tomcat/webapps)의 파일 시스템 경로 반환
	String saveDirectory=request.getServletContext().getRealPath("/product_image");
	
	//MultipartRequest 객체 생성 - [multipart/form-data]를 처리하기 위한 객체
	//ㄴ 사용자로부터 입력받아 전달된 모든 파일을 서버 디렉토리에 자동으로 저장
	MultipartRequest multipartRequest=new MultipartRequest(request, saveDirectory
			, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
	//전달값과 업로드된 파일명을 반환받아 저장
	String category=multipartRequest.getParameter("category");
	String name=multipartRequest.getParameter("name");
	String imageMain=multipartRequest.getFilesystemName("imageMain");
	String imageDetail=multipartRequest.getFilesystemName("imageDetail");
	int qty=Integer.parseInt(multipartRequest.getParameter("qty"));
	int price=Integer.parseInt(multipartRequest.getParameter("price"));
	
	//ProductDTO 객체를 생성하여 전달값과 업로드 파일명으로 필드값 변경
	ProductDTO product=new ProductDTO();
	product.setCategory(category);
	product.setName(name);
	product.setImageMain(imageMain);
	product.setImageDetail(imageDetail);
	product.setQty(qty);
	product.setPrice(price);
	
	//제품정보를 전달받아 PRODUCT 테이블에 삽입하는 DAO 클래스 메소드 호출
	int rows=ProductDAO.getDAO().insertProduct(product);
	
	if(rows<=0) { //PRODUCT 테이블에 제품정보가 삽입되지 않은 경우
		//서버 디렉토리에 업로드되어 저장된 제품 관련 이미지 파일 삭제
		//File 객체 : 파일 정보를 저장하기 위한 객체
		//File.delete() : File 객체에 저장된 파일을 삭제하기 위한 메소드
		new File(saveDirectory, imageMain).delete();
		new File(saveDirectory, imageDetail).delete();
	}
	
	//페이지 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/index.jsp?workgroup=admin&work=product_manager';");
	out.println("</script>");
%>