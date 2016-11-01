<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_010_scope</title>
</head>
<body>
	<%
		/* 
			scope(영역) - 데이터를 참조할 수 있도록 저장해놓은 공간
		*/	
		
		//한 페이지내에서만 사용가능
		//page영역에 p1이름으로 page값이 저장된다.
		pageContext.setAttribute("p1", "page");

		//request영역에 저장된것은 클라이언트에서 한번 요청했을때 페이지끼리 공유해서 사용할 수있다.
		//request영역에 p2이름으로 request값이 저장된다.
		request.setAttribute("p2", "request");

		//클라이언트와 서버의 연결을 지속시켜주기 위한 목적으로 사용함 (주로 로그인에서 사용)
		//seesion영역에 p3이름으로 session값이 저장된다.
		session.setAttribute("p3", "session");
		
		//application영역에 p4이름으로 application값이 저장된다.
		//모든 클라이언트와 관련, 현재서버에 접속하는 클라이언트끼리 데이터를 공유할시에 사용함.
		application.setAttribute("p4", "application");
		
	%>


	<jsp:forward page="jsp_010_next.jsp" />
	

</body>
</html>