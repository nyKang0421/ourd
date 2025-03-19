<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<div class="inner"> 
	<div class="info">
		<form class="infoboard" action="${ctx}/userupdate.do">
		
			<table class="infotable">
				<tr>
					<td> 나는 </td>
					<td>${vo.getNickname()}</td>
				</tr>
				<tr>
					<td> 이메일 </td>
					<td><input value="${vo.getEmail()}"></td>
				</tr>
				<tr>
					<td> 전화번호 </td>
					<td><input value="${vo.getTel()}"></td>
				</tr>
			</table>
						
			
			<input type="button" class="btn-send changePw-btn" value="비밀번호 바꾸기">
			<input type="submit" class="btn-send update-btn" value="내정보 수정">
			
		</form>
	</div>
</div>

<%@ include file="../parts/footer.jsp"%>