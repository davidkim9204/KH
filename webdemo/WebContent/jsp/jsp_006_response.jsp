<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_006_response</title>
</head>
<body>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
if(id.equals("kim") && pwd.equals("1234")){
	//response.sendRedirect("jsp_006_logout.jsp");
	/*  RequestDispatcher dis=
			request.getRequestDispatcher("jsp_006_logout.jsp");
	//서버에서만 페이지 이동  (주소하고 응답한 페이지하고 주소가 다름)
	dis.forward(request, response); */
	//밑에 방식 거의 안쓰는데 그냥 적어준거. 
%>	
<jsp:forward page="jsp_006_logout.jsp" /> 
<% 	
 }else{
	//서버의 클라이언트 사이에서 페이지 이동
	response.sendRedirect("jsp_006_login.jsp");
}

%>
</body>
</html>