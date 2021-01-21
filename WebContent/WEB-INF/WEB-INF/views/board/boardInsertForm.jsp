<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style>
	.outer {
		width:900px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	table {
		padding: 15px;
		border:1px solid white;
	}

	.tableArea {
		width:500px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
</style>

</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<c:if test="${ empty loginUser }">
		<c:set var="msg" value="로그인이 필요한 서비스입니다." scope="request"/>
		<jsp:forward page="../common/errorPage.jsp"/>
	</c:if>
	
	<c:if test="${ !empty loginUser }">
		<div class="outer">
			<br>
			<h2 align="center">게시판 작성</h2>
			<div class="tableArea">
				<form action="${ contextPath }/bInsert.bo" method="post" >
					<table>
						<tr>
							<td>제목 </td>
							<td colspan="3"><input type="text" size="51" name="title"></td>
						</tr>
						<tr>
							<td>작성자 </td>
							<td colspan="3">${ loginUser.userName }
								<input type="hidden" name="userId" value="${ loginUser.userId }"/>
							</td>
						</tr>
						<tr>
							<td>내용 </td>
							<td colspan="3">
								<textarea name="content" cols="52" rows="15" style="resize:none;"></textarea>
							</td>
						</tr>
					</table>
					<br>
					<div align="center">
						<button type="reset">취소하기</button>
						<button type="submit">등록하기</button>
					</div>
				</form>
			</div>
		</div>
	</c:if>
	


</body>
</html>