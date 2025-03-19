<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<div class="inner"> 
	<div class="login">
		<form class="joinForm" action="${ctx}/userjoin.do">
			<div class="row">
				<div class="field">
					<label>이름</label>
					<input type="text" name="name" id="inputName" size="25" required placeholder="이름을 적어주세요">
				</div>
			</div>
			<div class="row">
				<div class="field">
					<label>생년월일</label>
					<input type="date" name="birth" id="birthChoice" size="25" required/>
				</div>
			</div>
			<div class="row">
				<div class="field">
					<label>아이디</label>
					<input type="text" name="id" id="inputId" required placeholder="ID를 입력해주세요">
					<input type="button" class="btn-send checkId-btn" onclick="checkId()" value="ID중복체크">
					<p class="guide"> 아이디는 4자리 이상 영문, 숫자만 사용해 주세요</p>
				</div>
			</div>
			
			<div class="row">
				<div class="field">
					<label>비밀번호</label>
					<input type="password" name="pw" id="inputPw" size="25" required placeholder="비밀번호를 입력해주세요">
					<p class="guide"> 비밀번호는 8글자 이상, 영문, 숫자 ,특수문자(@$!%*#?&)를 사용해주세요</p>
				</div>
			</div>
			<div class="row">
				<div class="field">
					<label>비밀번호확인</label>
					<input type="password" name="pw-retype" id="inputPw-retype" size="25" required placeholder="비밀번호를 한번더 입력해주세요">
				</div>
			</div>
			<div class="row">
				<div class="field">
					<label>이메일</label>
					<input type="email" name="email" id="inputEmail" size="25" required placeholder="E-MAIL을 입력해주세요">
				</div>
			</div><div class="row">
				<div class="field">
					<label>전화번호</label>
					<select name="telinit" id="telinit">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="019">019</option>
					</select>
					<input type="number" name="telmiddle" id="telmiddle" oninput="checkNumLength()" required >
					<input type="number" name="tellast" id="tellast"  required >
				</div>
			</div>
			<div class="row">
				<div class="field">
					<label>별명</label>
					<input type="text" name="nickname" id="inputNickname" size="25" required placeholder="NICKNAME을 입력해주세요">
					<input type="button" class="btn-send checkNickname-btn" onclick="checkNickname()" value="별명중복체크">
				</div>
			</div>
			<input type="button" class="btn-send join-btn" onclick="submitJoinForm(form)" value="회원가입">
			
		</form>
	</div>
</div>

<script type="text/javascript" src="script/join.js" defer></script>
<%@ include file="../parts/footer.jsp"%>