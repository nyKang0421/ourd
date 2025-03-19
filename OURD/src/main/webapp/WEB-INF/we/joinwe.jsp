<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>


<div class="inner"> 
	<div class="joinWe">
	
		<form class="searchWeForm">
			<div class="searchClub">
			<label>찾고싶은 우리</label>
			<input type="text" class="findClub" id="findClub" name="findClub" required placeholder="찾는 우리는?" >
			<input type="button" class="btn-send findWe-btn" onclick="serchClub()" value="우리찾기">
			</div>
		</form>
	</div>
</div>


<script type="text/javascript" src="script/joinwe.js" defer></script>
<%@ include file="../parts/footer.jsp"%>
<%@ include file="../parts/joinweModal.jsp" %>