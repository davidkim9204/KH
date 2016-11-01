<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  try{
    String data=request.getParameter("data");
    int num=Integer.parseInt(data);
    out.print(num);
  }catch(NumberFormatException ex ){
	  out.print(ex.toString());
  }
%>

<hr/>
<c:catch var="ex">
<%
String data=request.getParameter("data");
int num=Integer.parseInt(data);
out.print(num);
%>
</c:catch>

<!-- 실행하고 주소창에 ?data=10 쓰고 확인 -->
<p> ${!empty ex ? "exception발생": "OK" } </p>

</body>
</html>