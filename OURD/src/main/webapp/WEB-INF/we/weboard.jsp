<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<div class="inner"> 
	<div class="weboard">
		<div class="webtn">
			<input type="button" class="btn-send makewe-btn" onclick="location.href='${ctx}/gomakewe.do'" value="우리만들기">
			<input type="button" class="btn-send joinwe-btn" onclick="location.href='${ctx}/gojoinwe.do'" value="우리들어가기">
			<input type="button" class="btn-send invitewe-btn" onclick="location.href='${ctx}/goinvitewe.do'" value="우리초대하기">
		</div>
	
		
	</div>
</div>

<%@ include file="../parts/footer.jsp"%>