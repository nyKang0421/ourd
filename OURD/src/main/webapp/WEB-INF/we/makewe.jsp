<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<link rel="stylesheet" type="text/css" href="${ctx }/css/makewestyle.css?ver=1">

<div class="inner"> 
	<div class="makeWe">
		<form class="makeWeForm" action="${ctx}/makewe.do">
			<div class="row">
					<label>어떤 우리를 만들까요?</label>
				<div class="field">
					<input type="text" name="we" class="wemakeinput" id="inputWe" required placeholder="우리이름을 입력해주세요">
					<input type="button" class="btn-send checkWe-btn" onclick="checkWe()" value="우리이름체크">
					<input type="hidden" name="keeperNum" class="clubkeeper" value="${lognum}"/>
				</div>
					<p class="guide">!! 모임명은 20자 이내로 해주세요 !!</p>
			</div>
		
			<input type="button" class="btn-send makeWe-btn" onclick="submitMakeWeForm(form)" value="우리만들기">
			
		</form>
	</div>
</div>

<script type="text/javascript" src="script/makewe.js" defer></script>
<%@ include file="../parts/footer.jsp"%>