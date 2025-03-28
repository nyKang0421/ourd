<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<link rel="stylesheet" type="text/css" href="${ctx }/css/joinwestyle.css?ver=1">

<div class="inner"> 
	<div class="joinWe">
	
		<form class="searchWeForm">
			<div class="searchClub">
			<label>어떤 우리를 찾을까요?</label>
			<input type="text" class="findClub" id="findClub" name="findClub" required placeholder="찾는 우리는? (우리 이름은 20자 이하에요)" >
			<input type="button" class="btn-send findWe-btn" onclick="serchClub()" value="우리찾기">
			</div>
		</form>
	</div>
</div>


<script type="text/javascript" src="script/joinwe.js" defer></script>
<%@ include file="../parts/footer.jsp"%>
<%@ include file="../parts/joinweModal.jsp" %>