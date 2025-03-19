<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<div class="inner"> 
	<div class="login">
		<form class="loginForm" action="${ctx}/userlogin.do">
			<div class="row">
				<div class="field">
					<label>아이디</label>
					<input type="text" name="id" required placeholder="ID를 입력해주세요">
				</div>
			</div>
			
			<div class="row">
				<div class="field">
					<label>비밀번호</label>
					<input type="password" name="pw" required placeholder="PW를 입력해주세요">
				</div>
			</div>
			
			<input type="submit" class="btn-send login-btn" value="로그인">
			
		</form>
	</div>
</div>

<%@ include file="../parts/footer.jsp"%>