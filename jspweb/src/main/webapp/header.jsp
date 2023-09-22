<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link href="/jspweb/css/header.css" rel="stylesheet">

</head>
<body>


		<!-- 헤더 -->
		
		<div id="header">
		
			<div class="mainlogo">
				<!-- 로고 -->
				<a href="/jspweb/index.jsp">
					<img alt="" src="/jspweb/img/logo2.png"/>
				</a>
			</div>
		
			<ul class="mainmenu">
					<!--본메뉴  -->
				<li> <a href="/jspweb/visitlog/visitlog.jsp">방문록</a> </li>	
				<li> <a href="/jspweb/board/list.jsp">게시판</a> </li>
				<li> <a href="/jspweb/datago/datago.jsp">공공데이터</a> </li>
				<li> <a href="/jspweb/chatting/chatting.jsp">채팅</a> </li>				
				<li> <a href="/jspweb/product/register.jsp">제품등록</a> </li>				
				<li> <a href="/jspweb/product/list.jsp">제품찾기</a> </li>				
				<li> <a href="/jspweb/accountbook/accountbook.jsp">가계부</a> </li>						
				<li> <a href="#">과제2</a> </li>						
				<li> <a href="/jspweb/member/hrm.jsp">인사관리</a> </li>						
			
			</ul>
			
			<ul class="submenu">
				<!--서브메뉴  -->		 
					
			</ul>
			
		</div>
		
		
		
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
		
	<!-- jquery 호출 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspweb/js/header.js"></script>	

</body>
</html>