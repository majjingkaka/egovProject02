<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>


<h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light"> PAGES /</span> 로그인</h4>

<div class="card" style="max-width: 400px;">
	<div class="card-body">
            
			<!-- <form id="formAuthentication" class="mb-3" action="index.html" method="POST"> -->
			<%-- <form name="loginForm" id="loginForm" action="<c:url value='/uat/uia/actionLogin.do'/>" method="post"> --%>
			
			
			<form name="loginForm" id="loginForm" action="<c:url value='/uat/uia/actionLogin.do'/>" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input name="userSe" type="hidden" value="GNR"/>
			<input name="j_username" type="hidden"/>
			
                <div class="mb-3">
                  <label for="id" class="form-label">ID</label><!-- Email or Username -->
                  <input
                    type="text"
                    class="form-control"
                    id="id"
                    name="id"
                    placeholder="Enter your email or username"
                    autofocus
                  />
                </div>
                <div class="mb-3 form-password-toggle">
                  <div class="d-flex justify-content-between">
                    <label class="form-label" for="password">Password</label>
                    <a href="javascript:void(0);">
                      <small>Forgot Password?</small>
                    </a>
                  </div>
                  <div class="input-group input-group-merge">
                    <input
                      type="password"
                      id="password"
                      class="form-control"
                      name="password"
                      placeholder="&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;"
                      aria-describedby="password"
                    />
                    <span class="input-group-text cursor-pointer"><i class="bx bx-hide"></i></span>
                  </div>
                </div>
                <div class="mb-3">
                  <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="remember-me" />
                    <label class="form-check-label" for="remember-me"> Remember Me </label>
                  </div>
                </div>
                <div class="mb-3">
                  <button class="btn btn-primary d-grid w-100" type="submit">Sign in</button>
                </div>
              </form>
              
</div>
</div>

