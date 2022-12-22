<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/board.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
a{
text-decoration: none;
}
#col {
	transform: scale(1);
	transition: all 0.3s ease-in-out;
	padding: 0px;
	width: 1020px;
	margin: 0px auto;
}

#col:hover {
	transform: scale(1);
}

#comment {
	width: 618px;
	margin: 5px 15px;
	color: #585858;
	font-size: 14px;
	display: inline-block;
}
#down_img {
	transform: rotate(180deg);
}

#edit_update {
	 text-decoration: none; text-shadow: 0 0 24px; margin : 40px;
	 font-size : 20px;
	 }
	 
a:visited { text-decoration: none; text-shadow: 0 0 24px; }

</style>
</head>
<%-- <script type="text/javascript">
	$(document).ready(function() {
		$("#logoutBtn").on("click", function() {
			location.href = "/member/logout";
		})
<%if (session.getAttribute("member") == null) {%>
	$("#logoutBtn").hide();
<%} else {%>
	$("#logoutBtn").show();
<%}%>
	})
</script> --%>

<%
String session_id =(String) session.getAttribute("id");
%>
<body>
<c:url value="/board/board_write?&residence=${residence}"
			var="url" />
<div class="btn-group-vertical" role="group" aria-label="..." id="minibar">
	
	<p><a href="${url}" id="minibar"><img src="../resources/image/edit.png"><br>글쓰기</a></p><hr>

	<p><a href="#" id="minibar" onclick="$('html, body').stop().animate( { scrollTop : '0' } )"><img src="../resources/image/up_arrow.png"><br>상단으로 이동</a></p><hr>
	
	<p><a href="#" id="minibar" onclick="$('html, body').stop().animate( {scrollTop: $(document).height() + $(window).height()})"><img src="../resources/image/up_arrow.png"id = "down_img"><br>하단으로 이동</a></p><hr>

	<p><a id="minibar" onclick = "location.href='/member/logout'"><img src="../resources/image/logout.png"><br>로그아웃</a></p><hr>
</div>
	<div align=center>
		<h1>
			<header>${residence} ${residenceGu} 커뮤니티에 오신 걸 환영합니다  </header>
		</h1>
		<br>
<!-- 		<table> -->
		<!--  <tr>
		    <th>ID</th>
		  </tr> -->
		
		<c:forEach var="board" items="${board}">
				<input type="hidden" name="id" value="${board.id}">
					<input type="hidden" name="num" value="${board.num}">
					<input type="hidden" name="residence" value="${board.residence}">
				<c:set var = "board_content" value="${board.image}" />
			<div class="row">
				<div class="col-sm-6 col-md-4" id="col">
					<div class="thumbnail">
				<c:if test = "${board.image ne null}"> 
							<div id="cm_img_div">
							<img id="cm_img" src="/resources/imgUpload/${board.image}">

							</div>
				</c:if>
						<div class="caption">
					
							<p id="content">
								<a id="content_detail">${board.content} </a>
							</p>
						
							<hr style="margin: 0px;">
					
						</div>
						
						<c:set var = "idx" value="${board.id}" />
						<c:set var = "iid" value="<%=session_id %>" />
						<c:if test="${idx eq iid}">
						
							<a href="/board/modify?num=${board.num}"id = 'edit_update' >글 수정</a>
							<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="/board/delete?num=${board.num}" id = 'edit_update' class="bt">삭제</a>
						</c:if>
			<hr style="margin: 0px;">
			<c:forEach var = "comments" items="${comment}"> 
			<c:set var = "board_num" value="${board.num}" />
			<c:set var = "usercomment" value="${comments.comment}" />
			<c:set var = "residence" value="${comments.residence}" />
				<c:set var = "residenceGu" value="${comments.residenceGu}" />
			<c:set var = "comment_num" value="${comments.comment_num}" />
			<c:set var = "sessionId" value="<%=session_id %>" />
			<c:set var = "comment_board_num" value="${comments.boardnum}" />
				<c:if test = "${board_num eq comment_board_num}">
					<p id="comment">${comments.userid} | ${comments.comment}</p>
	     					<c:if test = "${sessionId eq comments.userid}">
	     						<a style="color: darkorchid; font-size: 13px;" href="/board/commentdelete?comment_num=${comment_num}&userid=${sessionId}&residence=${residence}&residenceGu=${residenceGu}">삭제하기</a>
	     					</c:if>	 
	     		</c:if>    
			</c:forEach>	
				<form method = "post" action = "/board/comment">
	    		<input type="text" name="comment" id="comment" class="form-control" placeholder="댓글쓰기">
	    		<input type="hidden" name="boardnum" id="boardnum" value="${board.num}">
	    		<input type="hidden" name="userid" id="userid" value="${id}">
	    		<input type="hidden" name="residence" id="residence" value="${residence}">
					<input type="hidden" name="residenceGu" id="residenceGu" value="${residenceGu}">
	    		<button id="comment_b" type="submit">게시</button>
				</form>
				
					</div>
				</div>
		</c:forEach>
		</div>
</div>
</body>
</html>