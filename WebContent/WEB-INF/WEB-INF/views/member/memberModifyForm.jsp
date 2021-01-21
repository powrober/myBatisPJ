<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	#updateForm{
		width:600px;
		margin-left:auto;
		margin-right:auto;
	}
</style>
<script>
	$(function(){
		$("#upUser").on("click",function(){
			$("#updateForm").attr("action","mUpdate.do");
		});
		
		$("#deUser").on("click",function(){
			$("#updateForm").attr("action","mDelete.do");
		});
	});

</script>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>
	
	<br>
	
	<h1 align="center">회원정보 수정</h1>
	
	<br>
	
	<form method="post" id="updateForm">
		  <div class="form-group row">
		    <label for="userId" class="col-sm-3 col-form-label">* ID</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" name="userId" id="userId" value="${ loginUser.userId }">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="userPwd" class="col-sm-3 col-form-label">* Password</label>
		    <div class="col-sm-8">
		      <input type="password" class="form-control" name="userPwd" id="userPwd" value="${ loginUser.userPwd }">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="userPwd2" class="col-sm-3 col-form-label">* Confirm</label>
		    <div class="col-sm-8">
		      <input type="password" class="form-control" name="userPwd2" id="userPwd2">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="userName" class="col-sm-3 col-form-label">* Name</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" name="userName" id="userName" value="${ loginUser.userName }">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="email" class="col-sm-3 col-form-label">&nbsp;&nbsp;Email</label>
		    <div class="col-sm-8">
		      <input type="email" class="form-control" name="email" id="email" value="${ loginUser.email }">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="birthDay" class="col-sm-3 col-form-label">&nbsp;&nbsp;BirthDay</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" name="birthDay" id="birthDay" value="${ loginUser.birthDay }">
		    </div>
		  </div>
		  
		  <fieldset class="form-group">
		    <div class="row">
		      <legend class="col-form-label col-sm-3 pt-0">&nbsp;&nbsp;Gender</legend>
		      <div class="col-sm-8">
		      <c:if test="${ loginUser.gender eq 'M' }">
		        <div class="form-check">
		          <input class="form-check-input" type="radio" name="gender" id="M" value="M" checked="checked">
		          <label class="form-check-label" for="M">Male</label>
		        </div>
		        <div class="form-check">
		          <input class="form-check-input" type="radio" name="gender" id="F" value="F">
		          <label class="form-check-label" for="F">Female</label>
		        </div>
		      </c:if>
		      <c:if test="${ loginUser.gender eq 'F' }">
		        <div class="form-check">
		          <input class="form-check-input" type="radio" name="gender" id="M" value="M" >
		          <label class="form-check-label" for="M">Male</label>
		        </div>
		        <div class="form-check">
		          <input class="form-check-input" type="radio" name="gender" id="F" value="F" checked="checked">
		          <label class="form-check-label" for="F">Female</label>
		        </div>
		      </c:if>
		      </div>
		    </div>
		  </fieldset>
		  
		  <div class="form-group row">
		    <label for="phone" class="col-sm-3 col-form-label">&nbsp;&nbsp;Phone</label>
		    <div class="col-sm-8">
		      <input type="tel" class="form-control" name="phone" id="phone" value="${ loginUser.phone }">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="address" class="col-sm-3 col-form-label">&nbsp;&nbsp;Address</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" name="address" id="address" value="${ loginUser.address }">
		    </div>
		  </div>
		  
		  <div class="form-group row" align="center">
		    <div class="col-sm-10">
		    	<input type="submit" id="upUser" class="btn btn-outline-secondary" value="회원정보수정"> <!-- mUpdate.do -->
		    	<input type="submit" id="deUser" class="btn btn-outline-secondary" value="회원탈퇴"> <!-- mdelete.do -->
		    	<button type="reset" class="btn btn-outline-secondary">Reset</button>
		    </div>
		  </div>
	</form>
</body>
</html>