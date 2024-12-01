<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>



<%-- 
<div class="row">
<div class="col-md-12">
	<div class="card mb-4">
	<h5 class="card-header">Default</h5>
		<div class="card-body">
			
		${result.bbSeq}
		</div>
	</div>
</div>
</div>
 --%>

<script>
function bibleDelete(){
	
	if (confirm("삭제 하시겠습니까?")) {
		document.frm.action = "<c:url value='/bible/bibleSayRecord/delete.do'/>";
		document.frm.submit();
		
	} else {
		return false;
	}
	
	
	
}

function bibleModify(){
	//document.location.href = "/bible/bibleSayRecord/list.do";
	document.frm.action = "<c:url value='/bible/bibleSayRecord/forUpdate.do'/>";
	document.frm.submit();
	
}

function bibleList(){
	document.location.href = "/bible/bibleSayRecord/list.do";
}

</script>



<h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light"> PAGES /</span> 말씀 기록장</h4>



<form id="frm" name="frm" method="post" action="/bible/bibleSayRecord/forUpdate.do">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="bbSeq" value="${empty result ? 0 : result.bbSeq}">

<div class="col-sm-12 col-lg-12 mb-4">
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">${result.bbSj}</h5>
      <hr>
      <p class="card-text">
        ${result.bbCn}
      </p>
      <!-- <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p> -->
    
    
    <hr>
    <div style="float: right;">
    	
	    <button type="button" class="btn btn-sm rounded-pill btn-primary" onclick="javascript:bibleModify();" style="margin-top: 5px;">수정</button>
	    <button type="button" class="btn btn-sm rounded-pill btn-primary" onclick="javascript:bibleDelete();" style="margin-top: 5px;">삭제</button>
	    <button type="button" class="btn btn-sm rounded-pill btn-primary" onclick="javascript:bibleList();" style="margin-top: 5px;">목록</button>
    </div>
    </div>
  </div>
</div>

</form>




