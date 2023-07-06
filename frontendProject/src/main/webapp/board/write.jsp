<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
	<!-- 뷰포트 - 반응형 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 부트스트랩 css 적용 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 썸머노트 css 적용 --> <!-- 부트 스트랩 기반으로 만들어졌기에 버전을 맞춰줘야 한다 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-bs5.min.css" rel="stylesheet">

</head>
<body>
	<%@include file="../header.jsp" %>
	
	
	
	<div class="container">
		<input class="form-control m-3" type="text" placeholder="제목">
		
		<textarea  id="summernote" class="form-control m-3" rows="10" cols=""></textarea>
		
		<input class="form-control m-3 " type="file">
		
		<div class="row justify-content-center gx-3 m-3">
			<div class="col-1 "> <input class="form-control btn btn-dark" type="button" value="등록"></div>
			<div class="col-1"> <input class="form-control btn btn-warning" type="button" value="목록"></div>
			<div class="col-1 "> <input class="form-control btn btn-warning" type="button" value="다시쓰기"></div>

		</div>
		
	</div>
		
		
	<%@include file="../footer.jsp" %>
	<!-- 부트스트랩 스크립트 적용 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>	

	<!-- jquery : js 라이브러리 -->   
	
	<!-- ★★★★★★★★★★★★★★<script src="https://code.jquery.com/jquery-latest.min.js"> ★★★★★★★★★★ 최신버전 -->

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	
	<!-- 썸머노트 스크립트 적용 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-bs5.min.js""></script>
	
	<!-- 썸머노트 스크립트 한글 버전 -->
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	  $('#summernote').summernote();
	});
</script>


</body>
</html>