<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="modal we-modal">
    <div class="modal-content">
      <div class="desc-header">
      	<c:if test="${resultClub.getName() eq null }">
	        <p class="msg" id="weMsg">찾는 우리가 없어요. 우리이름을 확인해 주세요</p>
      	</c:if>
      	<c:if test="${resultClub.getName() ne null }">
	        <p class="msg" id="weMsg">${resultClub.getName()}에 함께 요청을 할까요?</p>
      	</c:if>
      	<form class = "joinweform" action="${ctx}/sendjoinmsg.do">
      	<input type="hidden" id="joinClubNum" name="joinClubNum" value="${resultClub.getNum()}"/>
      	<input type="hidden" id="joinClubKeeper" name="joinClubKeeper" value="${resultClub.getKeeper()}"/>
      	<input type="hidden" id="joinSender" name="joinSender" value="${lognum}"/>
        
        <button class="btn-close msg-close" onclick="NonActiveWeModal()"> 취소하기 </button>
        <button class="btn-close msg-close" onclick="sendJoinMsg(form)"> 신청하기 </button>
      	</form>
      	
      </div>
    </div>
  </div>