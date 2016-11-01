<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
   $('#all').click(function(){
	   //실행후 처음 한번은 checkbox가 선택이 되지만 두번째 부터는
	   //적용이 안된다. attr('checked',true)은 정적속성만 적용된다.
	   
	   $('[type=checkbox]').prop('checked',true);
   });
   
   $('#del').click(function(){
	   $('form').submit();
   })
   /*  $('#del').click(function(){	
	 // alert("cnt:"+$(":checked").size());
	 var arr=new Array();
	 $(":checked").each(function(index, value){		
		//alert($(value).val());
		arr[index]=$(value).val();
	 }); 
	
	  $.ajax({
		 type:'get',
		 data:'data='+arr,
		 url:'myList',
		 success:function(res){
			 $('body').html(res);
		 }
	 }); 
   }); */
});

</script>
</head>
<body>
  <form name="frm" method="get" action="myList">
  <table>
   <tr>
    <th>
    
     <input type="button" id="all" value="전체"/>
     <input type="button" id="del" value="삭제" />
  
    </th>
   <!--  l.city, d.department_name, e.first_name, e.salary -->
    <th>num</th><th>name</th><th>age</th><th>loc</th>
   </tr>
   
   <c:forEach items="${aList}"  var="dto">
   <c:forEach items="${dto.dept}" var="dept"> 
   <c:forEach items="${dto.loc}" var="loc">
    <tr>
     <td>${loc.city}</td>
     <td>${dept.department_name}</td>   
     <td>${dto.first_name}</td>
     <td>${dto.salary}</td>
    </tr>
    </c:forEach>
    </c:forEach>
   </c:forEach>
  </table>
    </form>
</body>
</html>















