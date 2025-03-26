<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="modal we-modal">
    <div class="modal-content">
      <div class="desc-header">
      	
        <c:if test="${resultUser.getNickname() eq null }">
	        <p class="msg" id="weMsg">찾는 사람이 없어요. 이름을 확인해 주세요</p>
      	</c:if>
      	<c:if test="${resultUser.getNickname() ne null }">
	        <p class="msg" id="weMsg">${resultUser.getNickname()}에 함께 요청을 할까요?</p>
      	</c:if>
      	<form class = "joinweform" action="${ctx}/sendjoinmsg.do">
      	<input type="hidden" id="joinClubNum" name="joinClubNum" value="${inviteClubNum}"/>
      	<input type="hidden" id="joinTaker" name="joinTaker" value="${resultUser.getNum()}"/>
      	<input type="hidden" id="joinSender" name="joinSender" value="${lognum}"/>
      	<input type="hidden" id="state" name="state" value="1"/>
        
        <button class="btn-close msg-close" onclick="NonActiveWeModal()"> 취소하기 </button>
        <button class="btn-close msg-close" onclick="sendinviteMsg(form)"> 초대하기 </button>
      	</form>
      </div>
    </div>
  </div>