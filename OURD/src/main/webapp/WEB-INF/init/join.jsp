<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<div class="inner"> 
	<div class="login">
		<form class="joinForm">
			<div class="row">
				<div class="field">
					<label>이름</label>
					<input type="text" name="name" required placeholder="NAME을 입력해주세요">
				</div>
			</div>
			<div class="row">
				<div class="field">
					<label>생년월일</label>
					<input type="date" name="birth" id="birthChoice" required/>
				</div>
			</div>
			<div class="row">
				<div class="field">
					<label>아이디</label>
					<input type="text" name="id" id="inputId" required placeholder="ID를 입력해주세요">
					<input type="button" class="btn-send checkId-btn" onclick="checkId()" value="ID중복체크">
				</div>
			</div>
			
			<div class="row">
				<div class="field">
					<label>비밀번호</label>
					<input type="text" name="pw" required placeholder="PW를 입력해주세요">
				</div>
			</div>
			<div class="row">
				<div class="field">
					<label>이메일</label>
					<input type="text" name="email" required placeholder="E-MAIL을 입력해주세요">
				</div>
			</div><div class="row">
				<div class="field">
					<label>전화번호</label>
					<select name="telinit" id="telinit">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
						<option value="019">019</option>
					</select>
					<input type="number" name="telmiddle" id="telmiddle" oninput="checkNumLength()" required >
					<input type="number" name="tellast" id="tellast"  required >
				</div>
			</div>
			<div class="row">
				<div class="field">
					<label>별명</label>
					<input type="text" name="name" id="inputNickname" required placeholder="NICKNAME을 입력해주세요">
					<input type="button" class="btn-send checkNickname-btn" onclick="" value="별명중복체크">
				</div>
			</div>
			<input type="button" class="btn-send join-btn" onclick="" value="회원가입">
			
		</form>
	</div>
</div>

<script type="text/javascript" src="script/join.js" defer></script>
<%@ include file="../parts/footer.jsp"%>