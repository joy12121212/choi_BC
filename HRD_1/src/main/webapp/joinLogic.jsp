<%@page import="model.dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 여기서부터 
		// 여기까지 자바를 입력할 수 있는 태그 [ 스크립트 태그 ]
	%>


	<%
		request.setCharacterEncoding("utf-8");	
	
		String custno = request.getParameter("custno");
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
	

	
		// dao 처리
		Dao dao = new Dao();
		dao.join(custno, custname , phone , address , joindate , grade , city);
		
		// 화면 전환  [response.sendRedirect("경로");]
		response.sendRedirect("join.jsp");
		
	%>

</body>
</html>