<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	.outer{
		width:900px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	.outer table{
		border:1px solid white;
		text-align:center;
	}
	.outer a{
		color:white;
		text-decoration:none;
	}
</style>
<script>
	$(function(){
		$("#btnSearchBoard").on("click",function(){
			$("#frm").attr("action","search.bo");
		});
		
		$("#btnInsertBoard").on("click",function(){
			$("#frm").attr("action","bInsertView.bo");
		});
	});

</script>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>
	
	<!-- 로그인한 회원만 게시물 보기를 하기 위해 다음과 같은 조건 추가 -->
	<c:if test="${ empty loginUser }">
		<c:set var="msg" value="로그인이 필요한 서비스입니다." scope="request"/>
		<jsp:forward page="../common/errorPage.jsp"/>
	</c:if>
	
	<c:if test="${ !empty loginUser }"> 
		<div class="outer">
			<br>
			
			<h1 align="center">게시판</h1>
			
			<!-- 3. 게시물 검색하기 -->
			<div id="searchArea" align="center">
				<form id="frm">
					<select id="searchCondition" name="condition">
						<option>-------</option>
						<option value="writer">작성자</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					
					<input type="search" name="search">
					<input type="submit" id="btnSearchBoard" value="검색하기">
					<input type="submit" id="btnInsertBoard" value="등록하기">
				</form>
			</div>
			<br>
			<br>
			
			<!-- 1. 게시물 리스트 보기  -->
			<table id="listArea" align="center">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
				
				<!-- forEach를 통해 request에 담겨있는 list를 하나씩 접근하여 출력 -->
				<c:forEach var="b" items="${ list }">
				<tr>
					<td>${ b.bId }</td>
					<td>${ b.bTitle }</td>
					<td>${ b.userName }</td>
					<td>${ b.bCount }</td>
					<td>${ b.bCreateDate }</td>
				</tr>
				</c:forEach>
			</table>
			
			<!-- 페이징 부분 -->
			<div id="pagingArea" align="center">
				<!-- [이전] -->
				<c:if test="${ pi.currentPage <= 1 }">
					[이전] &nbsp;
				</c:if>
				
				<c:if test="${ pi.currentPage > 1 }">
					<c:url var="blistBack" value="list.bo">
						<c:param name="currentPage" value="${ pi.currentPage - 1 }"/>
					</c:url>
					<a href="${ blistBack }">[이전]</a>
				</c:if>
				
				<!-- [번호들] -->
				<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
					<c:if test="${ p eq pi.currentPage }">
						<font color="red" size="4"><b>[${ p }]</b></font>
					</c:if>
					
					<c:if test="${ p ne pi.currentPage }">
						<c:if test="${ !empty sc }">
							<c:url var="blistPage" value="search.bo">
								<c:param name="currentPage" value="${ p }"/>
								<c:param name="condition" value="${ condition }"/>
								<c:param name="search" value="${ search }"/>
							</c:url>
						</c:if>
						<c:if test="${ empty sc }">
							<c:url var="blistPage" value="list.bo">
								<c:param name="currentPage" value="${ p }"/>
							</c:url>
						</c:if>
						<a href="${ blistPage }"> ${ p } </a>
					</c:if>
				</c:forEach>
				
				<!-- [다음] -->
				<c:if test="${ pi.currentPage >= pi.maxPage }">
					&nbsp;[다음]
				</c:if>
				
				<c:if test="${ pi.currentPage < pi.maxPage }">
					<c:url var="blistNext" value="list.bo">
						<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
					</c:url>
					<a href="${ blistNext }">[다음]</a>
				</c:if>
			</div>
		</div>
		
		<!-- 2. 상세보기 -->
		<script>
			$(function(){
				$("#listArea").find("td").mouseenter(function(){
					$(this).parents("tr").css({"background":"orangered","cursor":"pointer"});
				}).mouseout(function(){
					$(this).parents("tr").css({"background":"black"});
				}).click(function(){
					var bId = $(this).parents().children("td").eq(0).text();

					location.href = "detail.bo?bId="+ bId; // 게시판 상세보기를 할 수 있다.
				});
			});		
		
		</script>
	</c:if>
</body>
</html>













