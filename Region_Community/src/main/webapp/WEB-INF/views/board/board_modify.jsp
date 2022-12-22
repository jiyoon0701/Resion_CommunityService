<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>


<style type="text/css">
#th {
	width: 130px;		
}

.container {    
	margin : 40px;

    font-family: 'Cafe24Oneprettynight';
    font-size: 18px;
    }
.h2, h2 {
    font-size: 30px;
    font-weight: bold;
}

.bt{
	border: 1px solid white;
    padding: 10px;
    border-radius: 5px;
    box-shadow: 1px 1px 3px grey;
    font-weight: bold;
}
.bt:hover {
	border: 1px solid #D8D8D8;
	background-color: #FAFAFA;
}
#cm_img{
	width: 30%;
	height: 50%;
}

.submit {
	box-shadow:inset 0px 1px 0px 0px #dcecfb;
	background:linear-gradient(to bottom, #bddbfa 5%, #80b5ea 100%);
	background-color:#bddbfa;
	border-radius:17px;
	border:1px solid #84bbf3;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:17px;
	font-weight:bold;
	padding:13px 27px;
	text-decoration:none;
	text-shadow:0px 1px 0px #528ecc;
}
.submit:hover {
	background:linear-gradient(to bottom, #80b5ea 5%, #bddbfa 100%);
	background-color:#80b5ea;
}
.submit:active {
	position:relative;
	top:1px;
}
</style>

</head>
<body>

<div class="container">
	<h2>게시물 상세보기</h2>          
	<form name=form1 action="/board/modify" method="post">
	<table class="table table-hover">
    	<tbody>
     		<tr>
      			<th id="th">LoginID</th>
      			<!-- 출력 시 공백이나 < > 줄바꿈 우리 눈에 보여주기 하기 위해서(html 태그로 인식해서 안되기 때매) -->
        		<td><p name="id"/>${board.id}</td>
      		</tr>
      		<tr>
      			<th id="th">Content</th>
      			<!-- 출력 시 공백이나 < > 줄바꿈 우리 눈에 보여주기 하기 위해서(html 태그로 인식해서 안되기 때매) -->
        		<td><textarea cols = "100" rows = "5" name="content">${board.content}</textarea></td>
      		</tr>
      		<tr>
      			<!-- 출력 시 공백이나 < > 줄바꿈 우리 눈에 보여주기 하기 위해서(html 태그로 인식해서 안되기 때매) -->
        		<th id="th">사진</th>
        		<td><div ><img id="cm_img" src="../resources/imgUpload/${board.image}" value = "${board.image}"></div></td>        		      			
      		</tr>     
		</tbody>
	
	</table>
	<input type="hidden" name="id" value="${board.id}">
		<input type="hidden" name="residence" value="${board.residence}">
		<input type="hidden" name="residenceGu" value="${board.residenceGu}">
		<input type="hidden" name="num" value="${board.num}">
		<input type="submit" class = "submit" value="수정">
	   <input type="reset" class = "submit" name="reset" value="다시작성">
	</form>
	</div>

</body>
</html>