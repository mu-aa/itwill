<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 USERINFO 테이블에 저장된 해당 아이디의 회원정보를 검색하여 입력태그의 초기값으로 
설정하고 변경할 회원정보를 사용자로부터 입력받기 위한 JSP 문서 - 관리자만 요청 가능한 페이지 --%>
<%-- ㄴ [수정] 태그를 클릭한 경우 회원정보 변경페이지(user_modify_action.jsp)로 이동 - 입력값 전달 --%>
<%-- ㄴ [목록] 태그를 클릭한 경우 회원목록 출력페이지(user_list.jsp)로 이동 --%>

<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	if(loginUserinfo==null) { //비로그인 사용자인 경우 - 비정상적인 요청
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	if(request.getParameter("userid")==null) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	String userid=request.getParameter("userid");
	
	UserinfoDTO userinfo=UserinfoModelOneDAO.getDAO().selectUserinfo(userid);
	
	if(userinfo==null) {
		response.sendRedirect("user_error.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MVC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/user.css" type="text/css">
<script language="JavaScript">
function userModify() {
	if ( f.name.value == "" ) {
		alert("이름을 입력하십시요.");
		f.name.focus();
		return false;
	}
	f.action = "user_modify_action.jsp";
	f.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 회원정보수정</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <form name="f" method="post">
	  <input type="hidden" name="userid" value="<%=userinfo.getUserid() %>">
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">아이디</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				abc
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<input type="password" style="width:150" name="password">
				<span style="color: red;">** 비밀번호를 변경하지 않을 경우 입력하지 마세요. **</span>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<input type="text" style="width:240" name="name" value="<%=userinfo.getName()%>">
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이메일 주소</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<% if(userinfo.getEmail()!=null) { %>
					<input type="text" style="width:240" name="email" value="<%=userinfo.getEmail()%>">
				<% } %>
			</td>
		  </tr>		  
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">회원등급</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<select name="status">
					<option value="1">일반회원</option>
					<option value="9">관리자</option>
				</select>
			</td>
		  </tr>	
	  </table>
	  </form>
	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="button" value="수정" onClick="userModify();">
			<input type="button" value="목록" onClick="location.href='user_list.jsp';">
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  

</body>
</html>