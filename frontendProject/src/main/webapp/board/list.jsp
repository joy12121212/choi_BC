<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- 반응형 동작 코드 : viewport -->
<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 부트스트랩에서 만든 css 적용 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<!-- 부트 스트랩 : 미리 만들어진 css / js 빠르게 적용
	- 설치 /
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>	
		
		그리드		: 구역 마다 12 조각을 쪼개서 사용 한다
		.row		: 하위 요소 가로 배치
		.col		: 하위 요소 세로 배치
		.col-조각수	: 열-그리드 수(몇칸 먹을거냐 1칸 2칸 3칸~~12칸)
		.justify-content-md-center	: 가로배치 가로 정렬
		.g-여백수		: 열마다 자동여백[24px] g-0[딱붙음]
		
		.container	: 반응형 구역
		.table 		: 테이블 기본 css
		.table-striped	: 홀/짝 행 색상 구별
		.table-hover	: 행에 마우스 올렸을때
		.table-bordered	: 테이블 테두리
		
		.text-center	: 텍스트 가운데
		.nanigation		: 페이징 처리 버튼
		.form-select	: 셀렉트 상자 꾸미기
		.form-control	: input 상자 꾸미기
		
	 -->






	<%@include file="../header.jsp" %>
	<!-- CSS/JS 관련 라이브러리 ( 미리 민들어진 CSS/JS ) 제공 -->
	
		
		<div class="container"> <!-- 현재 게시물 출력 전체 구역 -->

			<a href="write.jsp"><button type="button" class="btn btn-outline-secondary m-3"> 글쓰기</button></a>
			<table class="table table-hover table-striped table-dark text-center"> <!-- 테이블 -->
				<thead class="table-Light">		
				<tr> <!-- 제목 -->
					<th width="5%">번호</th> <th width="60%">제목</th> <th width="10%">작성자</th>
					<th width="15%">작성일</th> <th width="5%">조회수</th>  <th width="5%">추천수</th>				
				</tr>
				</thead>
				<tbody>
				<tr> <!-- 게시물 -->
					<td> 1 </td> <td> 게시물 제목 </td> <td> 공공공 </td>
					<td> 2023-07-06 </td> <td> 312 </td> <td> 2 </td>				
				</tr>			

				<tr> <!-- 게시물 -->
					<td> 2 </td> <td> 게시물 제목2 </td> <td> 공공공 </td>
					<td> 2023-07-06 </td> <td> 312 </td> <td> 2 </td>				
				</tr>			

				<tr> <!-- 게시물 -->
					<td> 3 </td> <td> 게시물 제목3 </td> <td> 공공공 </td>
					<td> 2023-07-06 </td> <td> 312 </td> <td> 2 </td>				
				</tr>	
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="6" class="text-end">total : 3</td>
					</tr>
				
				</tfoot>			
			</table> <!-- 테이블 -->
			
			<!-- 페이징 처리 구역 -->
			<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-center">
			    <li class="page-item disabled">
			      <a class="page-link">이전</a>
			    </li>
			    <li class="page-item"><a class="page-link" href="#">1</a></li>
			    <li class="page-item"><a class="page-link" href="#">2</a></li>
			    <li class="page-item"><a class="page-link" href="#">3</a></li>
			    <li class="page-item">
			      <a class="page-link" href="#">다음</a>
			    </li>
			  </ul>
			</nav>		
			<!-- 페이징 처리 구역 -->				
		
			<!-- 검색 창 구역 -->
			
			<div class="row justify-content-md-center gx-3">
				<div class="col-2">
				<select class="form-select" >
					<option>키워드</option><option>번호</option><option>제목</option><option>작성자</option>
				</select>
				</div>
				<div class="col-4">
				<input type="text" class="form-control">
				</div>
				<div class="col-1">
				<button class="form-control">검색</button>
				</div>
			</div>
		</div> <!-- 현재 게시물 출력 전체 구역 -->
		
	<%@include file="../footer.jsp" %>
	
	<!-- 부트스트랩 스크립트 적용 -->	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>	
</body>
</html>