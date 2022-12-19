<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript">
		//이미지 미리보기 스크립트
		var InputImage = (function loadImageFile() {
			if (window.FileReader) {
				var ImagePre;
				var ImgReader = new window.FileReader();
				var fileType = /^(?:image\/mp4|image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i;

				ImgReader.onload = function(Event) {
					if (!ImagePre) {
						var newPreview = document
								.getElementById("imagePreview");
						ImagePre = new Image();
						ImagePre.style.width = "20%";
						ImagePre.style.height = "20%";
						newPreview.appendChild(ImagePre);
					}
					ImagePre.src = Event.target.result;

				};

				return function() {
					var img = document.getElementById("image").files;
					ImgReader.readAsDataURL(img[0]);
				}
			}
			document.getElementById("imagePreview").src = document
					.getElementById("image").value;

		})();
		
	</script>
<head>
<meta charset="UTF-8">
<title>게시판 글 작성</title>

</head>
<body>
	<form method="post"
		action="/board/board_write" enctype="multipart/form-data">
		<h2>글쓰기</h2>
		<input id="id" name="id" value=${id} type="hidden" />
		 <input id="residence" name="residence" value=${residence} type="hidden" />
		<table class="table table-hover">
			<tbody>

				<tr>
					<th style="line-height: 60px;">사진 첨부</th>
					<td><input id="image" type="file" onchange="InputImage();"
						name=imagefile><a style="color: red; margin: 6px 0;">사진첨부는 자유입니다 :)</a></td>
				</tr>
				<tr>
					<th style="line-height: 380px;">내용</th>
					<td><textarea type="text" id="content" class="form-control"
							placeholder="글 내용을 작성하세요." name="content" maxlength="1024"
							style="height: 400px;" required="required"></textarea></td>
				</tr>
				
				<tr>
					<th style="line-height: 50px;">사진 미리보기</th>
					<td><div id="imagePreview"></div></td>
				</tr>

			</tbody>
		</table>

		<br> <input type="submit" class="write" value="글쓰기">
		</div>
	</form>
	<hr>

</body>
</html>