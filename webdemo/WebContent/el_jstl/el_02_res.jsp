<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <%
String data = request.getParameter("data");
out.print(data);
%>
 --%>

<!-- parameter 객체값을 갖고 올 때는 무조건 param.값  생략 불가능 -->
<p>${param.data}</p>

<%-- <%  아무것도 체크하지 않으면 null값이라 오류가 뜸.
String[] chk=request.getParameterValues("chk");
for(String sn : chk)
	out.print(sn);
%> --%>

<p>${paramValues.chk[0]}</p>
<p>${paramValues.chk[1]}</p>
<p>${paramValues.chk[2]}</p>


</body>
</html>