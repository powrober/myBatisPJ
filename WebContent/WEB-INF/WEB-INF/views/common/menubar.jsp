<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.login-area{height:100px;}
	.btn-login{height:50px;}
	.login-area a{text-decoration:none; color:black; font-size:0.8em;}
	
	.nav-area{
		background:black;
		height:50px;
	}
	.menu{
		display:table-cell;
		width:250px;
		height:50px;
		text-align:center;
		vertical-align:middle;
		font-size:20px;
		background:black;
		color:white;
	}
	.menu:hover{
		cursor:pointer;
		background:orangered;
	}
</style>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<h1 align="center">Welcome to MyBatis World!!</h1>
	<br>
	
	<!--  1. 회원 관련 서비스   -->
	<div class="login-area">
	
		<c:if test="${ empty sessionScope.loginUser }">
			<!-- 1_1. 로그인 관련 폼 만들기 -->
			<form action="${ contextPath }/login.me" method="post">
				<table align="center">
					<tr>
						<td>아이디 : </td>
						<td><input type="text" name="userId"></td>
						<td rowspan="2"><button id="login-btn" class="btn btn-login">로그인</button></td>
					</tr>
					<tr>
						<td>비밀번호 : </td>
						<td><input type="password" name="userPwd"></td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<a href="${ contextPath }/insertForm.me">회원가입</a> &nbsp;&nbsp;&nbsp;
							<a href="#">아이디/비밀번호 찾기</a>
						</td>
					</tr>	
				
				</table>
			</form>
		</c:if>
		
		<c:if test="${ !empty sessionScope.loginUser }">
			<table align="right">
				<tr>
					<td colspan="2">
						<h3>${ loginUser.userName }님 환영합니다.</h3>
					</td>
				</tr>
				<tr>
					<td><button onclick="location.href='${contextPath}/mUpdateForm.do';">회원정보 수정</button></td>
					<td><button onclick="location.href='${contextPath}/logout.me';">로그아웃</button></td>
				</tr>
			</table>
		</c:if>
	</div>
	
	<!-- ------------------------- 2. 게시물 관련 서비스 ---------------------- -->
	<div class="nav-area" align="center">
		<div class="menu" onclick="location.href='${contextPath}';">HOME</div>
		<div class="menu">공지사항</div>
		<div class="menu" onclick="location.href='${contextPath}/list.bo';">게시판</div>
		<div class="menu">etc</div>
	</div>
</body>
</html>