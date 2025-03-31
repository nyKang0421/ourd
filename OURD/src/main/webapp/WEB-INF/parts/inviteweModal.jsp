<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="modal we-modal">
    <div class="modal-content">
      <div class="desc-header">
      	
      	<form class = "joinweform" action="${ctx}/sendjoinmsg.do">
      	<input type="hidden" id="joinClubNum" name="joinClubNum" value="${inviteClubNum}"/>
      	<input type="hidden" id="joinTaker" name="joinTaker" value="${resultUser.getNum()}"/>
      	<input type="hidden" id="joinSender" name="joinSender" value="${lognum}"/>
      	<input type="hidden" id="state" name="state" value="1"/>
        <c:if test="${resultUser.getNickname() eq null }">
        	<div class="wemodalmsgarea">
	        <p class="msg" id="weMsgno">찾는 사람이 없어요. 이름을 확인해 주세요</p>
      		</div>
      		<div class="wemodalbtnarea">
       		<button class="btn-close msg-close" onclick="NonActiveWeModal()"> 다시찾기 </button>
      		</div>
      	</c:if>
      	<c:if test="${resultUser.getNickname() ne null }">
      		<div class="wemodalmsgarea">
	        <p class="msg" id="weMsgok">${resultUser.getNickname()}에 함께 요청을 할까요?</p>
      		</div>
      		<div class="wemodalbtnarea">
	        	<button class="btn-close msg-close" onclick="NonActiveWeModal()"> 취소하기 </button>
       			<button class="btn-ok msg-ok" onclick="sendinviteMsg(form)"> 초대하기 </button>
      		</div>
      	</c:if>
        
      	</form>
      </div>
    </div>
  </div>
