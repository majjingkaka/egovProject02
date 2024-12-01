<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>








<!doctype html>
<html><!-- xmlns:th="http://www.thymeleaf.org" -->


<head>
<title>Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta charset="UTF-8">
<meta name="_csrf" id="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" id="_csrf_header" content="${_csrf.headerName}" />


<link type="text/css" href="/static/Bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<script src="<c:url value='/static/Bootstrap/js/bootstrap.bundle.min.js' />" ></script>




<script type="text/javascript">





function bookOrdrListChange(v){
	
	//alert(v.value);
	/* 
	$.post("/bible/bookOrdrListChange.do",
	  {bookAf: v.value},
	  function(data, status){
	    //alert("Data: " + data + "\nStatus: " + status);
	    console.log(data);
	    
	  }, "json");
	 */
	 
	// 데이터 형식
	var dataMap = {bookAf: v.value};
	// data json 문자열 화
	var jsonString = JSON.stringify(dataMap);

	// server에 요청
	$.ajax({
		type: 'POST',
		url : "<c:url value='/bible/bookOrdrListChange.do'/>",
		data: {"bookAf": v.value},
		dataType:'json' , 
		success: function(data){
			//작업이 성공적으로 발생했을 경우
			console.log("ss");
			console.log(data);
			
			var innerHtml = "";
        	//var innerReply = "";
        	//var innerPaging = "";
        	var length = data['selectBibleBookOrdrList'].length;
        	if(length > 0) {
        		$.each(data['selectBibleBookOrdrList'], function(i) {
        			innerHtml += '<option value='+data['selectBibleBookOrdrList'][i].bookSeq+'>'+data['selectBibleBookOrdrList'][i].bookNm+'</option>';  
        		})
        		$("#bookSeq").html(innerHtml);
        	}
		},
		error:function(){  
            //에러가 났을 경우 실행시킬 코드
			console.log('ee');
		}
	});
	
	
}

function btweenYn123(V){
	alert(v);
	
}

$(document).ready(function(){
	$("input:radio[name=btweenYn]").click(function(){
		
		if($("input:radio[name=btweenYn]:checked").val()=='Y'){        
			//$("#hostOption").attr("disabled",false);
			//$("#hostOption").removeClass("readonly");
			$("#d1").show();
		}else{        
			//$("#hostOption").attr("disabled",true);
			//$("#hostOption").addClass("readonly");
			$("#d1").hide();
		}
	});
});
	

function txtAdd(v){
	//alert(v);
	//var astxt = $("#bibleCn").val();
	var astxt = oEditors.getById["bibleCn"].getIR();
	//oEditors.getById["bibleCn"].getIR()
	
	if(astxt == "<p><br></p>"){
		astxt = v;
		
	}else{
		//astxt = astxt + '\n'+v;
		astxt = '<br>'+v;
	}
	
	oEditors.getById["bibleCn"].exec("PASTE_HTML", [astxt]);
	//$("#bibleCn").val(astxt);
}




function bibleSearch(){
	
	
	var bookAf = $("#bookAf").val();
	var bookSeq = $("#bookSeq").val();
	var btweenYn = $("input:radio[name=btweenYn]:checked").val();
	var chapter = $("#chapter").val();
	var verse = $("#verse").val();
	var chapter2 = $("#chapter2").val();
	var verse2 = $("#verse2").val();
	var searchKeyword = $("#searchKeyword").val();
	
	
	// 데이터 형식
	var dataMap = {
			bookAf: bookAf
			,bookSeq: bookSeq
			,btweenYn: btweenYn
			,chapter: chapter
			,verse: verse
			,chapter2: chapter2
			,verse2: verse2
			,searchKeyword: searchKeyword
	};
	// data json 문자열 화
	var jsonString = JSON.stringify(dataMap);
	console.log(dataMap);
	console.log(jsonString);
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	console.log(token);
	console.log(header);
	
	//var name = $("#userName").val();
	
	
	// server에 요청
	$.ajax({
		type: 'POST',
		url : "<c:url value='/bible/bibleSearch.do'/>",
		data: jsonString,
		contentType: 'application/json; charset=utf-8',
		//dataType:'json',
		cache : false,
		success: function(data){
			//작업이 성공적으로 발생했을 경우
			console.log("ss");
			console.log(data);
			
			var innerHtml = "";
        	//var innerReply = "";
        	//var innerPaging = "";
        	var length = data['selectBibleList'].length;
        	var content = "";
        	var chapter = "";
        	var verse = "";
        	
        	if(length > 0) {
        		
        		innerHtml += '<ul>';
        		$.each(data['selectBibleList'], function(i) {
        			content = data['selectBibleList'][i].content;
        			chapter = data['selectBibleList'][i].chapter;
        			verse = data['selectBibleList'][i].verse;
        			
        			innerHtml += '<li style="list-style: none;">'+content + ' - ' + '<a href="javascript:void(0);" onclick="txtAdd(\''+content+' - ('+chapter+'장 '+verse+'절)'+'\');">('+chapter+'장 '+verse+'절)</a></li>';
        			
        		})
        		innerHtml += '</ul>';
        		//console.log(innerHtml);
        		
        		$("#bibleList").html(innerHtml);
        		//$("#bibleList").hide();
        		
        	}
		},
		error:function(){
            //에러가 났을 경우 실행시킬 코드
			console.log('ee');
		}
	});
	
	
}

</script>







</head>

<body>






<div class="container-fluid">


	
	<form>
	<div class="mb-3">
	  <label for="bibleTitle" class="form-label">제목</label>
	  <input type="text" class="form-control" id="bibleTitle" placeholder="">
	</div>
	
	<div class="mb-3">
	  <label for="bibleCn" class="form-label">내용</label>
	  <!-- <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com"> -->
	  <textarea rows="20" cols="100" name="bibleCn" id="bibleCn" style="width:100%;"></textarea>
	</div>
	
	</form>


	<!-- 
	제목 : <input type="text" size="100">
	<br>
	
	내용 : <textarea rows="20" cols="100" name="bibleCn" id="bibleCn"></textarea>
	 -->
	
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<!-- <a href="javascript:void(0);" onclick="bibleSave();">저장</a> -->
		<a href="javascript:void(0);" onclick="bibleSave();" class="btn btn-outline-primary btn-sm" >저장</a>
	</div>
	
	
	

	
	
	
	<<성경책>>
	

	
	<form id="search" name="search" method="post" action="/bible/main.do">
	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
	<%-- 
	<input type="radio" name="btweenYn" id="btweenN" value="N" <c:if test="${btweenYn eq 'N' }">checked="checked"</c:if> <c:if test="${empty btweenYn}">checked="checked"</c:if>> 단일지정</input>
	<input type="radio" name="btweenYn" id="btweenY" value="Y" <c:if test="${btweenYn eq 'Y' }">checked="checked"</c:if>> 범위지정</input>
	 --%>
	
	
	<div class="form-check">
	  <input class="form-check-input" type="radio" name="btweenYn" id=btweenN value="N" <c:if test="${btweenYn eq 'N' }">checked="checked"</c:if> <c:if test="${empty btweenYn}">checked="checked"</c:if>>
	  <label class="form-check-label" for="btweenN">
	    단일지정
	  </label>
	</div>
	<div class="form-check">
	  <input class="form-check-input" type="radio" name="btweenYn" id="btweenY" value="Y" <c:if test="${btweenYn eq 'Y' }">checked="checked"</c:if>>
	  <label class="form-check-label" for="btweenY">
	    범위지정
	  </label>
	</div>
	
	
	
	
	<!-- <input type="text" name="bookAf" value="${bookAf}"> -->
	<select name="bookAf" id="bookAf" onchange="bookOrdrListChange(this);" class="form-select form-select-sm w-25 d-inline-block" aria-label="Default select example">
		<!-- <option value="">선택</option> -->
		<c:forEach var="code" items="${selectBibleBookAfList }" varStatus="status">
			<option value="${code.bookAf }" <c:if test="${code.bookAf eq bookAf }">selected="selected"</c:if>>${code.bookAfNm }</option>
		</c:forEach>
	</select>
	
	


	
	<%-- <input type="text" name="chapter" value="${chapter}"> --%>
	<select name="bookSeq" id="bookSeq" class="form-select form-select-sm w-25 d-inline-block" aria-label="Default select example">
		<!-- <option value="">선택</option> -->
		<c:forEach var="code" items="${selectBibleBookOrdrList }" varStatus="status">
			<option value="${code.bookSeq }" <c:if test="${code.bookSeq eq bookSeq }">selected="selected"</c:if>>${code.bookNm }</option>
		</c:forEach>
	</select>
	
	
	
	
	
	
	
	<%-- 
	<input type="text" id="chapter" name="chapter" size="4" maxlength="4" value="${chapter}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');">장
	<input type="text" id="verse" name="verse" size="4" maxlength="4" value="${verse}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');">절
	 --%>
	
	<input class="form-control form-control-sm w-25 d-inline-block" type="text" placeholder="장" aria-label=".form-control-lg example" id="chapter" name="chapter" size="4" maxlength="4" value="${chapter}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');">
	<input class="form-control form-control-sm w-25 d-inline-block" type="text" placeholder="절" aria-label=".form-control-lg example" id="verse" name="verse" size="4" maxlength="4" value="${verse}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');">
	
	
	<div id="d1" style="display: none;">
		~
		<input type="text" id="chapter2" name="chapter2" size="4" maxlength="4" value="${chapter2}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');">장
		<input type="text" id="verse2" name="verse2" size="4" maxlength="4" value="${verse2}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');">절
	</div>
	
	
	<%-- <input type="text" id="searchKeyword" name="searchKeyword" size="10" placeholder="검색어" value="${searchKeyword}"> --%>
	<input class="form-control form-control-sm w-25 d-inline-block" type="text" placeholder="검색어" aria-label=".form-control-lg example" id="searchKeyword" name="searchKeyword" size="4" maxlength="4" value="${searchKeyword}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');">
	
	
	<!-- <input type="submit" value="조회"></input> -->
	</form>
	<br>
	<!-- <a href="javascript:void(0);" onclick="bibleSearch();">조회</a> -->
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<!-- <a href="javascript:void(0);" onclick="bibleSave();">저장</a> -->
		<a href="javascript:void(0);" onclick="bibleSearch();" class="btn btn-outline-primary btn-sm" >조회</a>
	</div>
	
	
	
	<div id="bibleList">
		<ul>
			<%-- <c:forEach items="${ selectBibleList }" var="data" varStatus="status">
				<li style="list-style: none;">${data.content} -  <a href="javascript:void(0);" onclick="txtAdd('${data.content} - (${data.chapter }장 ${data.verse }절)');">(${data.chapter }장 ${data.verse }절)</a></li>
			</c:forEach> --%>
		</ul>
		
	</div>




















</div>

</body>
</html>


<!-- https://gaengdoo.tistory.com/3 크기정보 -->
<!-- https://naver.github.io/smarteditor2/user_guide/2_install/setting.html -->
<script type="text/javascript" src="/se2823/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
 oAppRef: oEditors,
 elPlaceHolder: "bibleCn",
 sSkinURI: "/se2823/SmartEditor2Skin.html",
 fCreator: "createSEditor2",
 htParams : {
		// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseToolbar : true,

		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : true,

		// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : true,
		bSkipXssFilter: true,
		fOnBeforeUnload: function(){
          // alert("완료!");
        }
	}
});


function bibleSave(){
	
	var txt = oEditors.getById["bibleCn"].getIR();
	
	alert('1:'+txt);
	oEditors.getById["bibleCn"].exec("UPDATE_CONTENTS_FIELD", []);
	
	if (oEditors.getById["bibleCn"].getIR() == "<p><br></p>") {
		alert('내용을 입력해 주세요.');
		oEditors.getById["bibleCn"].exec("FOCUS", []);
	    return;
	}
	
	// 에디터의 내용에 대한 값 검증은 이곳에서
	// document.getElementById("ir1").value를 이용해서 처리한다.
	//document.getElementById("bibleCn").value = oEditors.getById["bibleCn"].getIR();
	
	//oEditors.getById["content"].exec("SET_IR", [""]); //내용초기화

	//oEditors.getById["content"].exec("PASTE_HTML", ["내용 내용"]); //내용밀어넣기
	
	
}
//‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
function submitContents(elClickedObj) {
 // 에디터의 내용이 textarea에 적용된다.
 oEditors.getById["bibleCn"].exec("UPDATE_CONTENTS_FIELD", []);

 // 에디터의 내용에 대한 값 검증은 이곳에서
 // document.getElementById("ir1").value를 이용해서 처리한다.

 try {
     //elClickedObj.form.submit();
 } catch(e) {}
}










$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    
    
    console.log(token);
    console.log(header);
    //console.log('${_csrf.token}');
    
    if(token && header) {
        $(document).ajaxSend(function(event, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    }
});


</script>





