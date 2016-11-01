<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String a=request.getParameter("x");
String b=request.getParameter("y");
int x = Integer.parseInt(a);
int y = Integer.parseInt(b);

String ope=request.getParameter("ope");
int res = 0 ;

/* String add=request.getParameter("+");
String sub=request.getParameter("-");
String multi=request.getParameter("*");
String div=request.getParameter("/");
 */
 
if (ope.equals("+")){
	res = x+y;
}else if(ope.equals("-")){
	res = x-y;
}else if(ope.equals("*")){
	res = x*y;
}else if(ope.equals("/")){
	res = x/y;
}	

 out.print(res);



%>


</body>
</html>