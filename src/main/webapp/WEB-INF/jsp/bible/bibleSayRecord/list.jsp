<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>


<!-- <style> 

a:link { color: red; text-decoration: none;} 
a:visited { color: black; text-decoration: none;} 
a:hover { color: blue; text-decoration: underline;}

</style> -->


<script>
	function writ(){
		//alert('1');
		document.location.href = "/bible/bibleSayRecord/forInsert.do";
	}
	
	function fn_egov_select_Infs(pageNo){
		document.frm.pageIndex.value = pageNo;
		document.frm.action = "<c:url value='/bible/bibleSayRecord/list.do'/>";
		document.frm.submit();
	}

	function fn_egov_search_Infs(){
		document.frm.pageIndex.value = 1;
		document.frm.action = "<c:url value='/bible/bibleSayRecord/list.do'/>";
		document.frm.submit();
	}
	
	console.log('${menuId}');
	
</script>
<%-- 
<c:forEach var="data" items="${bibleSayRecordList }" varStatus="status">
	${data.bbSeq }/${data.bbSj }/${data.ntcrNm }/${data.church }/${data.churchGp }/${data.registDt }<br>
</c:forEach>
--%>


<h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light"> PAGES /</span> 말씀 기록장</h4>


<form name="frm" action="/bible/bibleSayRecord/list.do" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="pageIndex" value="<c:out value='${sayRecordVo.pageIndex}'/>">
<%-- <input type="hidden" name="adbkId" value = "'<c:out value="${searchVO.adbkId}" />'" > --%>

</form>
			<!-- Basic Bootstrap Table -->
              <div class="card">
                <!-- <h5 class="card-header">말씀 기록장</h5> -->
                <div class="table-responsive text-nowrap">
                  <table class="table">
                  	<colgroup>
						<col width="5%" />
						<col width="*" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
					</colgroup>
                  	
                    <thead>
                      <tr style="text-align: center;">
                        <th>등록번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>교회</th>
                        <th>목장</th>
                        <th>등록일자</th>
                      </tr>
                    </thead>
                    
                    <tbody class="table-border-bottom-0">
                    	<c:forEach var="data" items="${bibleSayRecordList }" varStatus="status">
                    		<tr>
		                        <td style="text-align: center;">${data.bbSeq }</td>
		                        <td style="text-align: left;"><a href="/bible/bibleSayRecord/view.do?bbSeq=${data.bbSeq}">${data.bbSj }</a></td>
		                        <td style="text-align: center;">${data.ntcrNm }</td>
		                        <td style="text-align: center;">${data.church }</td>
		                        <td style="text-align: center;">${data.churchGp }</td>
		                        <td style="text-align: center;">${data.registDt }</td>
		                      </tr>
                    	</c:forEach>
                      
                      
                    </tbody>
                  </table>
                </div>
              </div>
              <!--/ Basic Bootstrap Table -->
              
              
<br>
<div style="float: right;">
	<button type="button" class="btn btn-sm rounded-pill btn-primary" onclick="javascript:writ();">등록</button>
</div>


				<%-- <c:if test="${!empty sayRecordVo.pageIndex }">
					<!-- paging navigation -->
					<div class="pagination">
						<ul><ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_Infs"/></ul>
					</div>
				</c:if> --%>
				
				<div>
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_Infs"/>
					</ul>
				
				
				  <!-- <ul class="pagination justify-content-center">
				    <li class="page-item disabled">
				      <a class="page-link">Previous</a>
				    </li>
				    <li class="page-item"><a class="page-link" href="#">1</a></li>
				    <li class="page-item"><a class="page-link" href="#">2</a></li>
				    <li class="page-item"><a class="page-link" href="#">3</a></li>
				    <li class="page-item">
				      <a class="page-link" href="#">Next</a>
				    </li>
				  </ul> -->
				</nav>
				</div>
				
				
				
				
				
				
				
				
				
				
				
				<!-- Basic Pagination -->
                <!-- <nav aria-label="Page navigation">
                  <ul class="pagination">
                    <li class="page-item first">
                      <a class="page-link" href="javascript:void(0);"
                        ><i class="tf-icon bx bx-chevrons-left"></i
                      ></a>
                    </li>
                    <li class="page-item prev">
                      <a class="page-link" href="javascript:void(0);"
                        ><i class="tf-icon bx bx-chevron-left"></i
                      ></a>
                    </li>
                    <li class="page-item">
                      <a class="page-link" href="javascript:void(0);">1</a>
                    </li>
                    <li class="page-item">
                      <a class="page-link" href="javascript:void(0);">2</a>
                    </li>
                    <li class="page-item active">
                      <a class="page-link" href="javascript:void(0);">3</a>
                    </li>
                    <li class="page-item">
                      <a class="page-link" href="javascript:void(0);">4</a>
                    </li>
                    <li class="page-item">
                      <a class="page-link" href="javascript:void(0);">5</a>
                    </li>
                    <li class="page-item next">
                      <a class="page-link" href="javascript:void(0);"
                        ><i class="tf-icon bx bx-chevron-right"></i
                      ></a>
                    </li>
                    <li class="page-item last">
                      <a class="page-link" href="javascript:void(0);"
                        ><i class="tf-icon bx bx-chevrons-right"></i
                      ></a>
                    </li>
                  </ul>
                </nav> -->
                <!--/ Basic Pagination -->
				
				
				
				
				
				
				
				
				
				
