<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/frontendProject/css/kiosk.css" rel="stylesheet">

</head>
<body>
<%@include file="../header.jsp" %>



		
	<div class="kioskwrap"> <!-- 전체 -->
	
<!------------------------------헤더---------------------------------->	
		<div> <!--  광고 이미지가 표시되는 구역 -->
			<!--광고 이미지 -->
			<img class="himg" src="../img/himg1.png">

			<!-- 카테고리 -->
			<ul class="categorymenu">

			</ul>
		</div> <!-- 광고 이미지가 표시되는 구역 끝-->
<!------------------------------헤더---------------------------------->	

<!------------------------------본문---------------------------------->	
		<div class="kioskcontent"> 
			<div class="productbox"> <!-- 제품 구역 -->

	
			</div> <!-- 제품 구역 -->
		

			<div class="cartbox"> <!-- 카트 구역 -->
				<div class="cartcontent"> <!-- 제품 개수, 총가격 -->

					<div class="carttop"> <!-- 위 -->
						<div> 카트 <span class="ccount">0</span></div>
						<div>총 주문금액 <span class="ctotal">0</span></div>
					</div><!-- 위 -->

					<div class="cartbot"><!-- 아래 -->
						<!-- 카트내 제품 1개 -->

					</div><!-- 아래 -->

				</div><!-- 제품 개수, 총가격 -->


				
				<div class="cartbtn">
					<button onclick="cartCancel()" class="cancelbtn">취소하기</button>
					<button onclick="productorder()" class="oderbtn">주문하기</button>
				</div>
			
			</div> <!-- 카트 구역 -->
		</div><!-- 본문 : 카테고리, 제품, 장바구니 출력 구역-->
<!------------------------------본문---------------------------------->	

	</div> <!-- 전체 -->

			
<%@include file="../footer.jsp" %>
	
	
	
	<script src="/frontendProject/js/kiosk.js" type="text/javascript"></script>
</body>
</html>