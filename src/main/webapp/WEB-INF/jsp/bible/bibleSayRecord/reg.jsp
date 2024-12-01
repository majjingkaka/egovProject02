<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>


<style>
	#smart_editor2{
		background-color: white;
	}
</style>


<script type="text/javascript">

function bibleCancle(){
	document.location.href = "/bible/bibleSayRecord/view.do?bbSeq=${result.bbSeq}";
}

function bibleList(){
	document.location.href = "/bible/bibleSayRecord/list.do";
}


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

	

function txtAdd(v){
	//alert(v);
	//var astxt = $("#bbCn").val();
	var astxt = oEditors.getById["bbCn"].getIR();
	//oEditors.getById["bbCn"].getIR()
	
	if(astxt == "<p><br></p>"){
		astxt = v;
		
	}else{
		//astxt = astxt + '\n'+v;
		astxt = '<br>'+v;
	}
	
	oEditors.getById["bbCn"].exec("PASTE_HTML", [astxt]);
	//$("#bbCn").val(astxt);
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



<!-- <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Forms /</span> Basic Inputs</h4> -->
<h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light"> PAGES /</span> 말씀 기록장</h4>











<form id="frm1" name="frm1" method="post" action="/bible/bibleSayRecord/insert.do">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="bbSeq" value="${empty result ? 0 : result.bbSeq}">

<div class="row">
	<div class="col-md-12">
      <div class="card mb-4">
        <!-- <h5 class="card-header">Default</h5> -->
        <div class="card-body">
          
          <div class="mb-3">
            <label for="bbSj" class="form-label">제목</label>
            <input
              type="text"
              class="form-control"
              id="bbSj"
              name="bbSj"
              placeholder="제목을 입력하세요."
              aria-describedby="defaultFormControlHelp"
              value="${result.bbSj}"
            />
            <div id="defaultFormControlHelp" class="form-text">
              <!-- We'll never share your details with anyone else. -->
            </div>
          </div>
          
          <!-- <div class="mb-3">
            <label for="abc" class="form-label">Read only</label>
            <input
              class="form-control"
              type="text"
              id="abc"
              placeholder="Readonly input here..."
              readonly
            />
          </div> -->
          
          <div class="mb-3">
			  <label for="bbCn" class="form-label">내용</label>
			  <!-- <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com"> -->
			  <textarea rows="20" cols="100" name="bbCn" id="bbCn" placeholder="내용을 입력하세요." style="width:100%;">${result.bbCn}</textarea>
			</div>
          
          <div style="text-align: right;">
				
				
				<c:choose>
					<c:when test="${not empty result}">
						<button type="button" class="btn btn-sm rounded-pill btn-primary" onclick="javascript:bibleUpdate();">수정</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-sm rounded-pill btn-primary" onclick="javascript:bibleInsert();">저장</button>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${not empty result}">
						<button type="button" class="btn btn-sm rounded-pill btn-primary" onclick="javascript:bibleCancle();">취소</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-sm rounded-pill btn-primary" onclick="javascript:bibleList();">목록</button>
					</c:otherwise>
				</c:choose>
				
			</div>
			
        </div>
      </div>
    </div>
</div>
</form>



<form id="search" name="search" method="post" action="/bible/main.do">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="row">
	<div class="col-md-12">
      <div class="card mb-4">
        <h5 class="card-header">[말씀 찾기]</h5>
        <div class="card-body">
          
          	<div>
				<div class="form-check form-check-inline mb-3">
		          <input
		            class="form-check-input"
		            type="radio"
		            name="btweenYn" id="btweenN" value="N" <c:if test="${btweenYn eq 'N' }">checked="checked"</c:if> <c:if test="${empty btweenYn}">checked="checked"</c:if>
		          />
		          <label class="form-check-label" for="btweenN">단일지정</label>
		        </div>
		        <div class="form-check form-check-inline">
		          <input
		            class="form-check-input"
		            type="radio"
		            name="btweenYn" id="btweenY" value="Y" <c:if test="${btweenYn eq 'Y' }">checked="checked"</c:if>
		          />
		          <label class="form-check-label" for="btweenY">범위지정</label>
		        </div>
	        	
        	</div>
        	
			
			
			<!-- <label for="exampleFormControlSelect1" class="form-label">Example select</label> -->
              <select class="form-select w-25 mx-1" name="bookAf" id="bookAf" onchange="bookOrdrListChange(this);" aria-label="Default select example" style="float: inline-start;">
                <c:forEach var="code" items="${selectBibleBookAfList }" varStatus="status">
					<option value="${code.bookAf }" <c:if test="${code.bookAf eq bookAf }">selected="selected"</c:if>>${code.bookAfNm }</option>
				</c:forEach>
              </select>
            
            
			<%-- <input type="text" name="chapter" value="${chapter}"> --%>
			<select class="form-select w-25 mx-1" name="bookSeq" id="bookSeq" aria-label="Default select example" style="float: inline-start;">
				<!-- <option value="">선택</option> -->
				<c:forEach var="code" items="${selectBibleBookOrdrList }" varStatus="status">
					<option value="${code.bookSeq }" <c:if test="${code.bookSeq eq bookSeq }">selected="selected"</c:if>>${code.bookNm }</option>
				</c:forEach>
			</select>
			
			
			<input class="form-control w-25 mx-1" type="text" placeholder="장" aria-label=".form-control-lg example" id="chapter" name="chapter" size="4" maxlength="4" value="${chapter}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');" style="float: inline-start;width: 5% !important;">
			<input class="form-control w-25 mx-1" type="text" placeholder="절" aria-label=".form-control-lg example" id="verse" name="verse" size="4" maxlength="4" value="${verse}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');" style="float: inline-start;width: 5% !important;">
					
			
			<div id="d1" style="display: none;">
				<input class="form-control w-25 mx-1" type="text" placeholder="장" aria-label=".form-control-lg example" id="chapter2" name="chapter2" size="4" maxlength="4" value="${chapter2}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');" style="float: inline-start;width: 5% !important;">
				<input class="form-control w-25 mx-1" type="text" placeholder="절" aria-label=".form-control-lg example" id="verse2" name="verse2" size="4" maxlength="4" value="${verse2}" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');" style="float: inline-start;width: 5% !important;">
			</div>
			
			<input class="form-control w-25 mx-1" type="text" placeholder="검색어" aria-label=".form-control-lg example" id="searchKeyword" name="searchKeyword" size="4" maxlength="4" value="${searchKeyword}" style="float: inline-start;width: 10% !important;">
			<!-- <a href="javascript:void(0);" onclick="bibleSearch();" class="btn btn-outline-primary" style="float: inline-start;">조회</a> -->
			<button type="button" class="btn btn-sm rounded-pill btn-primary" onclick="javascript:bibleSearch();" style="margin-top: 5px;">조회</button>
			
			
			
			
			<p><div id="bibleList"></div></p>
			
        </div>
      </div>
    </div>
	
</div>
</form>








<script type="text/javascript" src="/se2823/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
var oEditors = [];
smartEditor = function(){
	nhn.husky.EZCreator.createInIFrame({
	 oAppRef: oEditors,
	 elPlaceHolder: "bbCn",
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
}

function bibleUpdate(){
	var frm = document.frm1;
	var txt = oEditors.getById["bbCn"].getIR();
	oEditors.getById["bbCn"].exec("UPDATE_CONTENTS_FIELD", []);
	if (oEditors.getById["bbCn"].getIR() == "<p><br></p>") {
		alert('내용을 입력해 주세요.');
		oEditors.getById["bbCn"].exec("FOCUS", []);
	    return;
	}
	
	if (confirm("수정 하시겠습니까?")) {
		frm.action = "<c:url value='/bible/bibleSayRecord/update.do'/>";
		frm.submit();
		
	} else {
		return false;
	}
	
}

function bibleInsert(){
	
	var frm = document.frm1;
	var txt = oEditors.getById["bbCn"].getIR();
	oEditors.getById["bbCn"].exec("UPDATE_CONTENTS_FIELD", []);
	
	if (oEditors.getById["bbCn"].getIR() == "<p><br></p>") {
		alert('내용을 입력해 주세요.');
		oEditors.getById["bbCn"].exec("FOCUS", []);
	    return;
	}
	
	// 에디터의 내용에 대한 값 검증은 이곳에서
	// document.getElementById("ir1").value를 이용해서 처리한다.
	//document.getElementById("bbCn").value = oEditors.getById["bbCn"].getIR();
	//oEditors.getById["content"].exec("SET_IR", [""]); //내용초기화
	//oEditors.getById["content"].exec("PASTE_HTML", ["내용 내용"]); //내용밀어넣기
	
	if (confirm("저장 하시겠습니까?")) {
		frm.action = "<c:url value='/bible/bibleSayRecord/insert.do'/>";
		frm.submit();
		
	} else {
		return false;
	}
}








//‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
function submitContents(elClickedObj) {
 // 에디터의 내용이 textarea에 적용된다.
 oEditors.getById["bbCn"].exec("UPDATE_CONTENTS_FIELD", []);

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


<script type="text/javascript">

$(document).ready(function(){
	
	smartEditor();
	
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
</script>























