<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript">


	var urno='';
	Handlebars.registerHelper("newDate", function(timeValue){
	var dateObj=new Date(timeValue);
		var year=dateObj.getFullYear();
		var month=dateObj.getMonth()+1;
		var date=dateObj.getDate();
		return year+"/"+month+"/"+date;
		//return new Date(timeValue);	
		});
		
		
	Handlebars.registerHelper("newUpload", function(rno, uploadFile) {
    	if (uploadFile != null) {

         var filename = uploadFile.substring(uploadFile.indexOf("_") + 1);
         var ddd = '<a href="replyDownload.do?rno='+rno+'">'+filename+'</a>';
			return new Handlebars.SafeString(ddd);
      } else {
         return "첨부파일 없음";
      }
   });

	$(document).ready(function() {
		$('#modifyModel').addClass('modifyHide');
		$(document).on('click','.timeline button', function(){
			if($(this).text()=='delete'){
					$.ajax({
						dataType : 'json',
						type: 'GET',
						url : 'replyDelete.do?bno=${boardDTO.bno}&rno='+$(this).attr('id'),		
						success : viewMessage, 
					})
					
				}else if($(this).text()=='update'){
					urno=$(this).prop('id');
					$('#modifyModel').removeClass('modifyHide');
					$('#modifyModel').addClass('modifyShow'); 
				}
		})	
		
	 	$('#replyAddBtn').on('click', reply_list); 
		$('#btnClose').on('click', reply_update_close);
		$('#btnModify').on('click',reply_update_send);
	});	
	
	function reply_list(){
		var form_data=new FormData();
		form_data.append('bno','${boardDTO.bno}');
		form_data.append('replyer',$('#newReplyWriter').val());
		form_data.append('replytext',$('#newReplyText').val());
		
		//첨부 파일 넣었는지 않나았는지 결과 console창에서 확인
		console.log('filename',$('#filename')[0].files[0]);
		if($('#filename')[0].files[0]!=undefined)
			form_data.append('filename',$('#filename')[0].files[0]);
		
		$.ajax({
			type:'POST',
			dataType : 'json',
			contentType:false,
			enctype: 'multipart/form-data',
			processData:false,
			data: form_data,
			url : 'replyInsertList.do',		
			success : viewMessage, 
		});
	}
	
	
	function reply_update_close(){
		$('#modifyModel').removeClass('modifyShow');
		$('#modifyModel').addClass('modifyHide');
		urno='';
	}
	
	
	function reply_update_send(){
		//alert('asdf');
		$.ajax({
		dataType : 'json',
		url : 'replyUpdate.do?bno=${boardDTO.bno}&rno='+urno+'&replytext='+$('#updateReplyText').val(),		
		success : viewMessage, 
	});
		$('#updateReplyText').val('');
		$('#modifyModel').removeClass('modifyShow');
		$('#modifyModel').addClass('modifyHide');
		
	}
	
	
	
	
	function viewMessage(res) {
		$('.timeline').empty();
		$('.timeline').append('<li class="time-label" id="repliesDiv"><span class="bg-green"> Replies List <small id="replycntSmall"> ['+res.length+'] </small></span>');
		$.each(	res,function(index, value) {
							/* $('.timeline').append('<p>'+ value.replyer+ '</p>');
							$('.timeline').append('<p>'+ value.replytext+ '</p>');
							$('.timeline').append('<p>'+ value.regdate+ '</p>');
							$('.timeline').append('<p><button id="${replyDTO.rno }">delete</button><button id="${replyDTO.rno }">update</button></p>'); */
		var source="<li class='time_sub' id='{{rno}}'><p>{{replyer}}</p><p>{{replytext}}</p><p>{{newDate regdate}}</p><p>{{newUpload rno rupload}}</p><p><button id='{{rno}}'>delete</button><button id='{{rno}}'>update</button></p></li>";
		var template = Handlebars.compile(source);
		$('.timeline').append(template(value));
		});
	}
	
	
	
</script>

<style type="text/css">
.modifyShow {
	display: block;
	position: absolute;
	top: 150px;
	left: 200px;
	width: 400px;
	height: 150px;
	z-index: 1000;
	border: 1px solid black;
	background-color: yellow;
	text-align: center;
}

.modifyHide {
	visibility:hidden;
	width:0px; 
	height:0px;
	
}
</style>
<body>
	<div class="wrap">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label> 
				<input type="text" name='title' class="form-control" value="${boardDTO.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea class="form-control" name="content" rows="3" readonly="readonly">${boardDTO.content}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label> 
				<input type="text" name="writer" class="form-control" value="${boardDTO.writer}" readonly="readonly">
			</div>
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
			<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
			<button type="submit" class="btn btn-primary" id="goListBtn">GO LIST</button>
		</div>
		<hr />

		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">ADD NEW REPLY</h3>
			</div>
			<div class="box-body">
				<label for="exampleInputEmail1">Writer</label> 
					<input class="form-control" type="text" placeholder="USER ID" id="newReplyWriter"> 
				<label for="exampleInputEmail1">Reply Text</label> 
					<input class="form-control" type="text"	placeholder="REPLY TEXT" id="newReplyText">
				<label for="filename">Upload</label>
					<input type="file" id="filename" name="filename" />
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="button" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
			</div>
		</div>


		<!-- The time line -->
		<ul class="timeline">
			<!-- timeline time label -->
			<li class="time-label" id="repliesDiv">
				<span class="bg-green"> Replies List 
				<small id='replycntSmall'> [${fn:length(boardDTO.replyList)} ] </small>
			</span>
			</li>

			<c:forEach items="${boardDTO.replyList}" var="replyDTO">
				<li class="time_sub" id="${replyDTO.rno}">
					<p>${replyDTO.replyer}</p>
					<p>${replyDTO.replytext }</p>
					<p><fmt:formatDate dateStyle="short" pattern="yyyy/MM/dd" value="${boardDTO.regdate}" /></p>
					<p><a href="replyDownload.do?rno=${replyDTO.rno}">${fn:substringAfter(replyDTO.rupload,"_")}</a></p>
					<p>
						<button id="${replyDTO.rno }">delete</button>
						<button id="${replyDTO.rno }">update</button>
					</p>
				</li>
			</c:forEach>
		</ul>


		<div class='text-center'>
			<ul id="pagination" class="pagination pagination-sm no-margin ">
			</ul>
		</div>
		
	<!-- Modal -->
		<div id="modifyModel">
			<p>
				<label for="updateReplyText">Reply Text</label> 
				<input class="form-control" type="text" placeholder="REPLY TEXT" id="updateReplyText">
			</p>
			<p>			    
				<button id="btnModify">Modify</button>
				<button id="btnClose">Close</button>
			</p>
		</div>
	</div>
</body>
</html>