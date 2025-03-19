<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<div class="inner"> 
	<div class="makeWe">
		<form class="makeWeForm" action="${ctx}/makewe.do">
			<div class="row">
				<div class="field">
					<label>우리는</label>
					<input type="text" name="we" id="inputWe" required placeholder="우리이름을 입력해주세요">
					<input type="button" class="btn-send checkWe-btn" onclick="checkWe()" value="우리이름체크">
					<input type="hidden" name="keeperNum" class="clubkeeper" value="${lognum}"/>
					<p class="guide"> 모임명은 20자 이내로 해주세요</p>
				</div>
			</div>
		
			<input type="button" class="btn-send makeWe-btn" onclick="submitMakeWeForm(form)" value="우리만들기">
			
		</form>
	</div>
</div>

<script type="text/javascript" src="script/makewe.js" defer></script>
<%@ include file="../parts/footer.jsp"%>