<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<div class="inner"> 
	<div class="inviteWe">
	
		<c:if test="${logclublist ne null }">
			<form class="searchUserForm">
			<div class="choiceClub">
				<label>전화번호</label>
					<select name="selectClub" id="slectClub">
						<c:forEach var="cl" items="${logclublist}">
							<option value="${cl.getNum}">${cl.getName}</option>
						</c:forEach>
					</select>
			</div>
			<div class="searchUser">
			<label>찾고싶은 멤버</label>
			<input type="text" class="findUser" id="findUser" name="findUser" required placeholder="찾는 친구는?" >
			<input type="button" class="btn-send findUser-btn" onclick="serchUser()" value="친구찾기">
			</div>
		</form>
		</c:if>
		<c:if test="${logclublist eq null }">
			<h1>모임 장을 하고 있는 우리가 없어요...</h1>
		</c:if>
	</div>
</div>


<script type="text/javascript" src="script/invitewe.js" defer></script>
<%@ include file="../parts/footer.jsp"%>
<%@ include file="../parts/inviteweModal.jsp" %>