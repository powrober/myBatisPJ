<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	#joinForm{
		width:600px;
		margin-left:auto;
		margin-right:auto;
	}
</style>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>
	
	<br>
	
	<h1 align="center">회원가입</h1>
	
	<br>
	
	
	<form action="insert.me" method="post" id="joinForm">
		  <div class="form-group row">
		    <label for="userId" class="col-sm-3 col-form-label">* ID</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" name="userId" id="userId" placeholder="아이디를 입력하시오" required>
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="userPwd" class="col-sm-3 col-form-label">* Password</label>
		    <div class="col-sm-8">
		      <input type="password" class="form-control" name="userPwd" id="userPwd" placeholder="비밀번호를 입력하시오" required>
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="userPwd2" class="col-sm-3 col-form-label">* Confirm</label>
		    <div class="col-sm-8">
		      <input type="password" class="form-control" name="userPwd2" id="userPwd2" placeholder="다시 비밀번호를 입력하시오" required>
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="userName" class="col-sm-3 col-form-label">* Name</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" name="userName" id="userName" placeholder="이름을 입력하시오" required>
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="email" class="col-sm-3 col-form-label">&nbsp;&nbsp;Email</label>
		    <div class="col-sm-8">
		      <input type="email" class="form-control" name="email" id="email" placeholder="이메일을 입력하시오">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="birthDay" class="col-sm-3 col-form-label">&nbsp;&nbsp;BirthDay</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" name="birthDay" id="birthDay" placeholder="생년월일을 입력하시오(6자리)">
		    </div>
		  </div>
		  
		  <fieldset class="form-group">
		    <div class="row">
		      <legend class="col-form-label col-sm-3 pt-0">&nbsp;&nbsp;Gender</legend>
		      <div class="col-sm-8">
		        <div class="form-check">
		          <input class="form-check-input" type="radio" name="gender" id="M" value="M">
		          <label class="form-check-label" for="M">Male</label>
		        </div>
		        <div class="form-check">
		          <input class="form-check-input" type="radio" name="gender" id="F" value="F">
		          <label class="form-check-label" for="F">Female</label>
		        </div>
		      </div>
		    </div>
		  </fieldset>
		  
		  <div class="form-group row">
		    <label for="phone" class="col-sm-3 col-form-label">&nbsp;&nbsp;Phone</label>
		    <div class="col-sm-8">
		      <input type="tel" class="form-control" name="phone" id="phone" placeholder="전화번호를 입력하시오(-포함)">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="address" class="col-sm-3 col-form-label">&nbsp;&nbsp;Address</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" name="address" id="address" placeholder="주소를 입력하시오">
		    </div>
		  </div>
		  
		  <div class="form-group row" align="center">
		    <div class="col-sm-10">
		    	<button type="reset" class="btn btn-outline-secondary">Reset</button>
		        <button type="submit" class="btn btn-outline-success">Sign in</button>
		    </div>
		  </div>
	</form>
</body>
</html>