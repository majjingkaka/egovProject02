<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>





<!DOCTYPE html>

<!-- =========================================================
* Sneat - Bootstrap 5 HTML Admin Template - Pro | v1.0.0
==============================================================

* Product Page: https://themeselection.com/products/sneat-bootstrap-html-admin-template/
* Created by: ThemeSelection
* License: You must have a valid license purchased in order to legally use the theme for your project.
* Copyright ThemeSelection (https://themeselection.com)

=========================================================
 -->
<!-- beautify ignore:start -->
<html
  lang="en"
  class="light-style layout-menu-fixed"
  dir="ltr"
  data-theme="theme-default"
  data-assets-path="/static/sneat/assets/"
  data-template="vertical-menu-template-free"
>
<head>
    <%-- <tiles:insertAttribute name="loadFile"/> --%>
    
    <meta charset="utf-8" />
    <meta name="_csrf" id="_csrf" content="${_csrf.token}" />
	<meta name="_csrf_header" id="_csrf_header" content="${_csrf.headerName}" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
	<meta name="description" content="" />
	
	<title>소울링크유</title><!-- HeartStory -->
	
	
    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="/static/bible/img/favicon/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet" />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="/static/sneat/assets/vendor/fonts/boxicons.css" />
	
	<link type="text/css" href="/static/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
	
    <!-- Core CSS -->
    <link rel="stylesheet" href="/static/sneat/assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="/static/sneat/assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="/static/sneat/assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="/static/sneat/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

    <link rel="stylesheet" href="/static/sneat/assets/vendor/libs/apex-charts/apex-charts.css" />

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="/static/sneat/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="/static/sneat/assets/js/config.js"></script>
    
    <script src="/js/egovframework/com/cmm/jquery.js"></script>
    <script src="/js/egovframework/com/cmm/jqueryui.js"></script>
    <script src="/static/Bootstrap/js/bootstrap.bundle.min.js" ></script>
    
    
    
    
    
</head>






<body>
	<!-- Layout wrapper -->
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
	 
		    <%-- <div id="nav"><tiles:insertAttribute name="header"/></div> --%>
		    <div id="left"><tiles:insertAttribute name="left"/></div>
		    
		    <!-- Layout page -->
		    <div class="layout-page">
		    
		    	<div id="nav"><tiles:insertAttribute name="header"/></div>
		    	
		    	<!-- Content wrapper -->
          		<div class="content-wrapper">
          		
          			<!-- Content -->
          			<div class="container-xxl flex-grow-1 container-p-y">
              			<div id="body"><tiles:insertAttribute name="body"/></div>
            		</div>
		    		<!-- / Content -->
		    		
		    		<!-- Footer -->
		    		<div id="footer"><tiles:insertAttribute name="footer"/></div>
		    		<!-- / Footer -->
		    		
		    		<div class="content-backdrop fade"></div>
		    	</div>
		    	<!-- / Content wrapper -->
          
		    </div>
		    <!-- / Layout page -->
	 	
	 		
	 	</div>
	 	
	 	
	 	<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	
	<!-- / Layout wrapper -->
	
	
	
	<!-- 
    <div class="buy-now">
      <a
        href="https://themeselection.com/products/sneat-bootstrap-html-admin-template/"
        target="_blank"
        class="btn btn-danger btn-buy-now"
        >Upgrade to Pro</a
      >
    </div>
    -->
	
	<!-- Core JS -->
    <!-- build:js assets/vendor/js/core.js -->
    <script src="/static/sneat/assets/vendor/libs/jquery/jquery.js"></script>
    
    
    
    <script src="/static/sneat/assets/vendor/libs/popper/popper.js"></script>
    <script src="/static/sneat/assets/vendor/js/bootstrap.js"></script>
    <script src="/static/sneat/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

    <script src="/static/sneat/assets/vendor/js/menu.js"></script>
    <!-- endbuild -->

    <!-- Vendors JS -->
    <script src="/static/sneat/assets/vendor/libs/apex-charts/apexcharts.js"></script>

    <!-- Main JS -->
    <script src="/static/sneat/assets/js/main.js"></script>

    <!-- Page JS -->
    <script src="/static/sneat/assets/js/dashboards-analytics.js"></script>

    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>
    
    
    <script type="text/javascript">
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
</body>
</html>
