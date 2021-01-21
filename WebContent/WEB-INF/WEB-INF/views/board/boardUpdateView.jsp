<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
	.outer{
		width:900px;
		height:auto;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	td {
		border:1px solid white;
	}
	.tableArea {
		border:1px solid white;
		width:650px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
	.btnArea{
		width:400px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
		margin-top:15px
	}
</style>
<script>
$(function(){
	$("#btnListView").on("click",function(){
		$("#frm").attr("action","list.bo");
	});
	
	var bId = <%= request.getParameter("bId")%>
	$("#btnModfyList").on("click",function(){
		$("#frm").attr("action","bUpdate.bo?bId="+bId);
	});
});
</script>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<form id="frm" method="post">
	<div class="outer">
		<br>
		
		<h1 align="center">게시판 상세보기</h1>
		<table align="center" class="tableArea">
			<tr>
				<td width="100">글번호</td>
				<td><b>${ b.bId }</b>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${ b.bTitle }"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><b>${ b.userName }</b></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><b>${ b.bCount }</b></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><b>${ b.bCreateDate }</b></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea style="width:540px; height:100px;" name="content">${ b.bContent }</textarea></td>
			</tr>
		</table>
		
		<!-- 댓글 등록 부분 -->
		<table align="center">
			<tr>
				<td>
					<textarea cols="80" rows="2"></textarea>
				</td>
				<td>
					<button class="btn btn-outline-secondary">등록</button>
				</td>
			</tr>
			<tr>
				<td colspan="2"><b>댓글(${ rCount })</b></td>
			</tr>
			<c:if test="${ rCount <= 0 }">
			<tr>
				<td align="center">등록된 댓글이 없습니다.</td>
			</tr>
			</c:if>
		</table>
		
		<c:if test="${ rCount > 0 }">
		<table align="center">
			<c:forEach var="r" items="${ b.replyList }">
			<tr>
				<td width="100px">${ r.userName }</td>
				<td width="400px">${ r.rContent }</td>
				<td width="150px">${ r.rCreateDate }</td>
			</tr>
			</c:forEach>
		</table>
		</c:if>
		
	</div>
	<div class="btnArea">
		<button id="btnModfyList" class="btn btn-outline-secondary">수정하기</button>
		<button id="btnDeleteList" class="btn btn-outline-secondary">삭제하기</button>
		<button id="btnListView" class="btn btn-outline-secondary">목록보기</button>
	</div>
	</form>
</body>
</html>