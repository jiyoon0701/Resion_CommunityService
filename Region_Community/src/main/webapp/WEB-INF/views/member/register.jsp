<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 <link rel="stylesheet" href="../resources/css/register.css"/> 
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>회원가입</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				location.href = "";
						    
			})
		})
	</script>
	<body>
	<div class="container">
		<form action="/member/register" method="post">
        <div class="py-5 text-center">            
            <img class="d-block mx-auto mb-4 " src="../resources/image/signup.png" alt="" width="72" height="72">
            <h2>회원가입</h2>
            <p class="lead">경기도에 오신것을 환영합니다.</p>
        </div>

        <div class="col-md-12 order-md-1">
            <h4 class="mb-3">회원정보 입력</h4>
			<hr>
				<div class="mb-3">
                    <label for="user_name">이름</label> 
                    <input type="text" class="form-control"  id="name" name = "name" placeholder="이름을 입력하세요." required name="user-real-name">
                </div>
                
                <div class="mb-3">
                    <label for="user_id">아이디</label>
               
                        <input type="text" class="form-control" id="id" name = "id"  placeholder="아이디를 입력하세요.">
                      <!--   <span id="result"></span> -->
               
                </div>
                <div class="mb-3">
                    <label for="password">비밀번호</label> 
                    <input type="password" class="form-control" id="passwd" name = "passwd" placeholder="비밀번호를 입력하세요">
                 <!--    <div class="invalid-feedback">유효한 비밀번호가 필요합니다.</div> -->
                </div>
                <div class="form-group has-feedback">
					<label class="control-label" for="residence">지역</label>
					<!-- <input class="form-control" type="text" id="residence" name="residence" /> -->
				<div class = "residence" >
				<select name = "residence">
					<option value='' selected>-- 선택 --</option>
					<option value='Siheung'>시흥시</option>
					<option value='Ansan'>안산시</option>
					<option value='Suwon'>수원시</option>
					<option value="gapyeong">가평군</option>
					<option value="gapyeong">과천시</option>
				</select>
				</div>
			</div>
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit">회원가입</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
				</div>

				<br><br>
               
        </div>
</form>
    </div>
		
	</body>
	
</html>