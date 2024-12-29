<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>








<script type="text/javascript">

function bibleMemberInsert(){
	
	var frm = document.frm;
	
	//var form = $("#frm")[0];
	var v = new MiyaValidator(frm);
	
	v.add("userId", {
        required: true,
        message : "아이디를 입력하세요"
    });
	
	if($('#idCheckYn').val() == 'N'){
		alert("중복체크하세요");
		$('#userId').focus();
		return;
	}
	
	v.add("password", {
		required : true,
		message : "비밀번호를 입력하세요"
	});
	
	v.add("password", {
		//pattern : "/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^*+=-]).{9,16}$/",
		pattern : "(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$)(?=.*[!@#$%^*+=-]).{5,16}$",
		message : "5자~16자 이하 영문 대소문자, 숫자, 특수문자 조합으로 입력가능 합니다."
	});
	
	v.add("passwordCheck", {
		required : true,
		message : "비밀번호 확인 입력 하십시오"
	});
	
	v.add("passwordCheck", {
		match : "password",
		message : "비밀번호가 일치하지 않습니다."
	});
	
	v.add("userNm", {
        required: true,
        message : "닉네임을 입력하세요"
    });
	
	v.add("mberAge", {
        required: true,
        message : "나이를 입력하세요"
    });
	
	v.add("dutyCd", {
        required: true,
        message : "직분을 선택하세요"
    });
	
	v.add("email", {
        required: true,
        message : "이메일을 입력하세요"
    });
	
	v.add("emailDomain", {
        required: true,
        message : "이메일 도메인을 입력하세요"
    });
	
	v.add("middleTelno", {
        required: true,
        message : "전화번호 중간자리 입력하세요"
    });
	
	v.add("endTelno", {
        required: true,
        message : "전화번호 끝자리 입력하세요"
    });
	
	v.add("churchNm", {
        required: true,
        message : "교회이름을 입력하세요"
    });
	
	v.add("zip", {
        required: true,
        message : "우편번호를 입력하세요"
    });
	
	
	v.add("adres", {
        required: true,
        message : "주소를 입력하세요"
    });
	
	v.add("detailAdres", {
        required: true,
        message : "주소 상세를 입력하세요"
    });
	
	var result = v.validate();
	if (!result) {
		alert(v.getErrorMessage());
		v.getErrorElement().focus();
		return;
	}
	
	
	
	//var txt = oEditors.getById["bbCn"].getIR();
	//oEditors.getById["bbCn"].exec("UPDATE_CONTENTS_FIELD", []);
	
	//if (oEditors.getById["bbCn"].getIR() == "<p><br></p>") {
	//	alert('내용을 입력해 주세요.');
	//	oEditors.getById["bbCn"].exec("FOCUS", []);
	//    return;
	//}
	
	// 에디터의 내용에 대한 값 검증은 이곳에서
	// document.getElementById("ir1").value를 이용해서 처리한다.
	//document.getElementById("bbCn").value = oEditors.getById["bbCn"].getIR();
	//oEditors.getById["content"].exec("SET_IR", [""]); //내용초기화
	//oEditors.getById["content"].exec("PASTE_HTML", ["내용 내용"]); //내용밀어넣기
	
	
	
	if (confirm("저장 하시겠습니까?")) {
		frm.action = "<c:url value='/bible/bibleMember/insert.do'/>";
		frm.submit();
		
	} else {
		return false;
	}
}


function addrSearch() {
	new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            
        	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
			
         	// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if(roadAddr !== ''){
            	roadAddr += extraRoadAddr;
            }
         	
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zip').value = data.zonecode;
            document.getElementById("adres").value = roadAddr;
            //document.getElementById("churchAddress").value = data.jibunAddress;
            //document.getElementById("churchAddressInc").value = extraRoadAddr;
            
            console.log(data.zonecode);
            console.log(roadAddr);
            //console.log(extraRoadAddr);
            
            
        }
    }).open();
}

function f_changeMail(val){
	
	var frm = document.frm;

	if(frm.emailMore.value != 'direct'){
		//frm.userEmad2.disabled = true;
		frm.emailDomain.value = val;
	}else{
		frm.emailDomain.value = "";
		//frm.userEmad2.disabled = false;
	}
}

function fn_id_check(){
	
	var userId = $("#userId").val();
	if(userId == ''){
		alert('아이디를 입력하세요');
		$("#userId").focus();
		return;
	}
	
	
	$.ajax({
		type:"POST",
		url:"<c:url value='/bible/bibleMember/bibleIdDplctCnfirmAjax.do' />",
		data:{
			"checkId": userId			
		},
		dataType:'json',
		timeout:(1000*30),
		success:function(returnData, status){
			if(status == "success") {
				
				if(returnData.usedCnt > 0 ){
					$('#idCheckYn').val('N');
					//사용할수 없는 아이디입니다.
					//$("#divModalResult").html("<font color='red'><spring:message code="comUssUmt.userManageRegistModal.result" /> : ["+returnData.checkId+"]<spring:message code="comUssUmt.userManageRegistModal.useMsg" /></font>");
					alert('사용할수 없는 아이디입니다.');
				}else{
					$('#idCheckYn').val('Y');
					//사용가능한 아이디입니다.
					//$("#divModalResult").html("<font color='blue'><spring:message code="comUssUmt.userManageRegistModal.result" /> : ["+returnData.checkId+"]<spring:message code="comUssUmt.userManageRegistModal.notUseMsg" /></font>");
					alert('사용가능한 아이디입니다.');
				}
			}else{ alert("ERROR!");return;} 
		}
		});
}


</script>


<h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light"> PAGES /</span> 계정 신청</h4>










<form:form id="frm" name="frm" method="post" action="${pageContext.request.contextPath}/bible/bibleMember/insert.do">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="idCheckYn" id="idCheckYn" value="N" />

<div class="row">
  <div class="col-md-6">
    <div class="card mb-4">
      <!-- <h5 class="card-header">Default</h5> -->
     <div class="card-body">
     	
       <div class="mb-3">
         <label for="userId" class="form-label" style="text-transform: none;">User ID</label>
         <button type="button" class="btn btn-xs btn-primary" onclick="javascript:fn_id_check();">check!</button>
         
         <input
           type="text" id="userId" name="userId"
           class="form-control"
           placeholder=""
           aria-describedby="defaultFormControlHelp"
         />
         <!-- <div id="defaultFormControlHelp" class="form-text">
           We'll never share your details with anyone else.
         </div> -->
       </div>
       
       <div class="mb-3">
         <label for="password" class="form-label" style="text-transform: none;">Password & PasswordCheck</label>
         
         
         
         
         
         <div class="row g-1 mb-1">
         
	         <div class="col-sm-6">
	         	<input
		           id="password" name="password" value="" type="password"
		           class="form-control"
		           placeholder="password"
		           aria-describedby="password"
		           autocomplete="off"
		         />
	         </div>
	         
	         <div class="col-sm-6">
	         	<input
		           id="passwordCheck" name="passwordCheck" value="" type="password"
		           class="form-control"
		           placeholder="passwordCheck"
		           aria-describedby="passwordCheck"
		           autocomplete="off"
		         />
	         </div>
	         
         </div>
         
         
         <!-- <div id="defaultFormControlHelp" class="form-text">
           We'll never share your details with anyone else.
         </div> -->
       </div>
       
       <!-- <div class="mb-3">
         <label for="passwordCheck" class="form-label" style="text-transform: none;">Password Check</label>
         <input
           id="passwordCheck" name="passwordCheck" value="" type="password"
           class="form-control"
           placeholder="password"
           aria-describedby="passwordCheck"
           autocomplete="off"
         />
         <div id="defaultFormControlHelp" class="form-text">
           We'll never share your details with anyone else.
         </div>
       </div> -->
       
       
       
       
       
       
       <div class="mb-3">
         <label for="userNm" class="form-label" style="text-transform: none;">Nick Name & Age & Duty</label>
         
         
         
         <div class="row g-1 mb-1">
	         <div class="col-sm-7">
	         	<input type="text" id="userNm" name="userNm" value="" class="form-control" placeholder="hong gir dong" aria-describedby="defaultFormControlHelp"/>
	         </div>
	         
	         <div class="col-sm-2">
	         	<input type="text" id="mberAge" name="mberAge" value="" class="form-control" placeholder="Age" aria-describedby="defaultFormControlHelp" size="3" maxlength="3" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');" />
	         </div>
	         
	         <div class="col-sm-3">
	         	<select name="dutyCd" id="dutyCd" class="form-select" aria-label="Default select example">
	         	  <option value="" <c:if test="${empty result}">selected="selected"</c:if>>직분 선택</option>
	         	  <option value="001" <c:if test="${result.dutyCd eq '001'}">selected="selected"</c:if>>청년</option>
				  <option value="002" <c:if test="${result.dutyCd eq '002'}">selected="selected"</c:if>>형제</option>
                  <option value="003" <c:if test="${result.dutyCd eq '003'}">selected="selected"</c:if>>자매</option>
                  <option value="004" <c:if test="${result.dutyCd eq '004'}">selected="selected"</c:if>>집사</option>
                  <option value="005" <c:if test="${result.dutyCd eq '005'}">selected="selected"</c:if>>권사</option>
                  <option value="006" <c:if test="${result.dutyCd eq '006'}">selected="selected"</c:if>>목사</option>
				</select>
				
	         </div>
         </div>
         
         
         
         
         <!-- <div id="defaultFormControlHelp" class="form-text">
           We'll never share your details with anyone else.
         </div> -->
       </div>
       
       <!-- <div class="mb-3">
         <label for="age" class="form-label" style="text-transform: none;">Age</label>
         <input
           type="number" id="age" name="age"
           class="form-control"
           placeholder="18"
           aria-describedby="defaultFormControlHelp"
         />
         <div id="defaultFormControlHelp" class="form-text">
           We'll never share your details with anyone else.
         </div>
       </div> -->
       
       
       
       
       
       
       
       
       
       
       
       <div class="mb-3">
          <label class="form-label" for="email" style="text-transform: none;">Email</label>
          <div class="input-group">
            <!-- <span class="input-group-text"><i class="bx bx-envelope"></i></span> -->
            <!-- <input
              type="text"
              id="email" name="email"
              class="form-control"
              placeholder="john.doe"
              aria-label="john.doe"
              aria-describedby="basic-icon-default-email2"
            /> -->
            
            
                        
            <input type="text" name="email" id="email" class="form-control" placeholder="email" aria-label="email">
			  <span class="input-group-text">@</span>
			  <input type="text" name="emailDomain" id="emailDomain" class="form-control" placeholder="emailDomain" aria-label="emailDomain">
			  
			  <select name="emailMore" id="emailMore" class="form-select" aria-label="Default select example" onchange="f_changeMail(this.value);">
				  <option value="direct" <c:if test="${'direct' eq ''}">selected="selected"</c:if>>직접 입력</option>
                  <option value="naver.com" <c:if test="${'naver.com' eq ''}">selected="selected"</c:if>>naver.com</option>
                  <option value="gmail.com" <c:if test="${'gmail.com' eq ''}">selected="selected"</c:if>>gmail.com</option>
                  <option value="hanmail.net" <c:if test="${'hanmail.net' eq ''}">selected="selected"</c:if>>hanmail.net</option>
                  <option value="nate.com" <c:if test="${'nate.com' eq ''}">selected="selected"</c:if>>nate.com</option>
                  <option value="kakao.com" <c:if test="${'kakao.com' eq ''}">selected="selected"</c:if>>kakao.com</option>
                  <option value="empas.com" <c:if test="${'empas.com' eq ''}">selected="selected"</c:if>>empas.com</option>
                  <option value="lycos.co.kr" <c:if test="${'lycos.co.kr' eq ''}">selected="selected"</c:if>>lycos.co.kr</option>
                  <option value="netsgo.com" <c:if test="${'netsgo.com' eq ''}">selected="selected"</c:if>>netsgo.com</option>
                  <option value="chol.com" <c:if test="${'chol.com' eq ''}">selected="selected"</c:if>>chol.com</option>
                  <option value="dreamwiz.com" <c:if test="${'dreamwiz.com' eq ''}">selected="selected"</c:if>>dreamwiz.com</option>
                  <option value="freechal.com" <c:if test="${'freechal.com' eq ''}">selected="selected"</c:if>>freechal.com</option>
                  <option value="hanafos.com" <c:if test="${'hanafos.com' eq ''}">selected="selected"</c:if>>hanafos.com</option>
                  <option value="hanmir.com" <c:if test="${'hanmir.com' eq ''}">selected="selected"</c:if>>hanmir.com</option>
                  <option value="hitel.net" <c:if test="${'hitel.net' eq ''}">selected="selected"</c:if>>hitel.net</option>
                  <option value="hotmail.com" <c:if test="${'hotmail.com' eq ''}">selected="selected"</c:if>>hotmail.com</option>
                  <option value="korea.com" <c:if test="${'korea.com' eq ''}">selected="selected"</c:if>>korea.com</option>
                  <option value="netian.com" <c:if test="${'netian.com' eq ''}">selected="selected"</c:if>>netian.com</option>
                  <option value="paran.com" <c:if test="${'paran.com' eq ''}">selected="selected"</c:if>>paran.com</option>
                  <option value="yahoo.co.kr" <c:if test="${'yahoo.co.kr' eq ''}">selected="selected"</c:if>>yahoo.co.kr</option>
                  <option value="yahoo.com" <c:if test="${'yahoo.com' eq ''}">selected="selected"</c:if>>yahoo.com</option>
				</select>
			              
               
				  
				  
				  
            <!-- <span id="basic-icon-default-email2" class="input-group-text">@example.com</span> -->
          </div>
          <!-- <div class="form-text">You can use letters, numbers & periods</div> -->
        </div>
        
        <!-- <div class="input-group mb-3">
        <span class="input-group-text"><i class="bx bx-envelope"></i></span>
		  <input type="text" class="form-control" placeholder="Username" aria-label="Username">
		  <span class="input-group-text">@</span>
		  <input type="text" class="form-control" placeholder="Server" aria-label="Server">
		</div> -->
		
		           

















       <div class="mb-3">
         <label for="areaNo" class="form-label" style="text-transform: none;">Phone</label>
         <!-- <input
           type="text" id="phone" name="phone" value=""
           class="form-control"
           placeholder="01011112222"
           aria-describedby="defaultFormControlHelp"
           oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');"
         /> -->
         <!-- <div id="defaultFormControlHelp" class="form-text">
           We'll never share your details with anyone else.
         </div> -->
         
         
         <div class="row g-1 mb-1">
	         <div class="col-sm-4">
	         	<input type="text" id="areaNo" name="areaNo" value="010" class="form-control" placeholder="010" aria-describedby="defaultFormControlHelp" size="3" maxlength="3" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');" readonly="readonly"/>
	         </div>
	         
	         <div class="col-sm-4">
	         	<input type="text" id="middleTelno" name="middleTelno" value="" class="form-control" placeholder="4자리" aria-describedby="defaultFormControlHelp" size="4" maxlength="4" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');" />
	         </div>
	         
	         <div class="col-sm-4">
	         	<input type="text" id="endTelno" name="endTelno" value="" class="form-control" placeholder="4자리" aria-describedby="defaultFormControlHelp" size="4" maxlength="4" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');" />
	         </div>
         </div>
         
         
       </div>
       
       
       <!-- <select name="userTelno1" id="userTelno1" class="select-box">
         <option value="02">02</option>
         <option value="051">051</option>
         <option value="053">053</option>
         <option value="032">032</option>
         <option value="062">062</option>
         <option value="042">042</option>
         <option value="052">052</option>
         <option value="044">044</option>
         <option value="031">031</option>
         <option value="033">033</option>
         <option value="043">043</option>
         <option value="041">041</option>
         <option value="063">063</option>
         <option value="061">061</option>
         <option value="054">054</option>
         <option value="055">055</option>
         <option value="064">064</option>
         <option value="070">070</option>
       </select> -->
                                
                                
                        
       <!-- <div class="mb-3">
         <label for="churchName" class="form-label" style="text-transform: none;">Church Name</label>
         <input
           type="text" id="churchName" name="churchName" value=""
           class="form-control"
           placeholder="Church Name"
           aria-describedby="defaultFormControlHelp"
         />
         <div id="defaultFormControlHelp" class="form-text">
           We'll never share your details with anyone else.
         </div>
       </div> -->
       
       
       
       
       
       <div class="mb-3">
         <label for="churchAddress" class="form-label" style="text-transform: none;">Church Name & Church Address</label>
         <button type="button" class="btn btn-xs btn-primary" onclick="javascript:addrSearch();">search</button>
         
         <div class="row g-1 mb-1">
	         
	         <div class="col-sm-9">
	         	<input
		           type="text" id="churchNm" name="churchNm" value=""
		           class="form-control"
		           placeholder="churchNm"
		           aria-describedby="defaultFormControlHelp"
		         />
	         </div>
	         <div class="col-sm-3">
	         	<input type="text" id="zip" name="zip" value="" class="form-control" placeholder="zipCode" aria-describedby="defaultFormControlHelp" oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1');" />
	         </div>
         </div>
         
         <div class="row g-1 mb-1">
	         <div class="col-sm-12">
	         	<input type="text" id="adres" name="adres" value="" class="form-control" placeholder="address" aria-describedby="defaultFormControlHelp" />
	         </div>
	         
	         <!-- <div class="col-sm-6">
	         	<input type="text" id="addr3" name="addr3" value="" class="form-control" placeholder="inc" aria-describedby="defaultFormControlHelp" />
	         </div> -->
         </div>
         
         <div class="row g-1">
	         <div class="col-sm-12">
	         	<input type="text" id="detailAdres" name="detailAdres" value="" class="form-control" placeholder="addressDetail" aria-describedby="defaultFormControlHelp" />
	         </div>
         </div>
         
         
         <!-- <div id="defaultFormControlHelp" class="form-text">
           We'll never share your details with anyone else.
         </div> -->
       </div>
       
       
       
       
       
       
       
       
       
       
       
       
       
       
     </div>
   </div>
 </div>
</div>

</form:form>






<div class="row">
<div class="col-md-6">
	<button type="button" class="btn btn-sm rounded-pill btn-primary" onclick="javascript:bibleMemberInsert();" style="float: right;">등록</button>
</div>
</div>

<!-- https://postcode.map.daum.net/guide -->