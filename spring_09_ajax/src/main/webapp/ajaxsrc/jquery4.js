$(document).ready(function(){
	$('#btn').click(function(){
		$.ajax({
			type:'GET',
			dataType:'xml',
			url:'searchOpen.do?search='+$('#search').val(),
			success:viewMessage,
			error:function(xhr,textStatus, error){           	//에러가 발생했을시 함수 실행
				alert(xhr.stauts+","+textStatus+","+error);        //xhr:상태오류 코드값     error:메세지        jqeury.com 에서 ajax가면  low-level interface에 설명 있음. 
			}
		});
	});
	
});

/*
 ajax의 dataType이 text일 때 
  function viewMessage(data){
	var data = data.replace(/&lt;/gi, "<");
	data = data.replace(/&gt;/gi, ">");
	$('#wrap').empty();
	$('#wrap').append(data);
};
*/

function viewMessage(data){
	$('#wrap').append('<table><tr><td>title</td><td>image</td><td>author</td><td>price</td></tr></table>')
	$('item',data).each(function(){
		$('#wrap table').append('<tr><td><a href="'+$('link',this).text()+'">'+$('title',this).text()+'</a></td><td><img src="'+$('cover_s_url',this).text()+'"/></td><td>'+$('author',this).text()+'</td><td>'+$('sale_price',this).text()+'</td></tr>');
	});
}