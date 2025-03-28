<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<link rel="stylesheet" type="text/css" href="${ctx }/css/loginstyle.css?ver=2">

<div class="inner"> 
	<div class="login">
		<form class="loginForm" action="${ctx}/userlogin.do">
			<div class="row">
				<div class="field1">
					<label>아이디</label>
				</div>
				<div class="field2">
					<input type="text" name="id" id="loginInputId" required placeholder="ID를 입력해주세요">
				</div>
			</div>
			
			<div class="row">
				<div class="field1">
					<label>비밀번호</label>
				</div>
				<div class="field2">
					<input type="password" name="pw" id="loginInputPw" required placeholder="PW를 입력해주세요">
				</div>
			</div>
			
			<input type="submit" class="btn-send login-btn" value="로그인">
			
		</form>
	</div>
</div>

<script type="text/javascript" src="script/login.js" defer></script>
<%@ include file="../parts/footer.jsp"%>