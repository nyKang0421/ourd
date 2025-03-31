<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="modal we-modal">
    <div class="modal-content">
      <div class="desc-header">
      	<form class = "joinweform" action="${ctx}/sendjoinmsg.do">
      	<input type="hidden" id="joinClubNum" name="joinClubNum" value="${resultClub.getNum()}"/>
      	<input type="hidden" id="joinTaker" name="joinTaker" value="${resultClub.getKeeper()}"/>
      	<input type="hidden" id="joinSender" name="joinSender" value="${lognum}"/>
      	<input type="hidden" id="state" name="state" value="0"/>
      	<c:if test="${resultClub.getName() eq null }">
      		<div class="wemodalmsgarea">
	       		<p class="msg" id="weMsgno">찾는 우리가 없어요...<br> 우리이름을 확인해 주세요</p>
      		</div>
      		<div class="wemodalbtnarea">
        		<button class="btn-close msg-close" onclick="NonActiveWeModal()"> 다시찾기 </button>
      		</div>
      	</c:if>
      	<c:if test="${resultClub.getName() ne null }">
      		<div class="wemodalmsgarea">
	       		 <p class="msg" id="weMsgok">${resultClub.getName()}에 함께 요청을 할까요?</p>
      		</div>
      		<div class="wemodalbtnarea">
        		<button class="btn-close msg-close" onclick="NonActiveWeModal()"> 취소하기 </button>
        		<button class="btn-ok msg-ok" onclick="sendJoinMsg(form)"> 신청하기 </button>
      		</div>
      	</c:if>
        
      	</form>
      	
      </div>
    </div>
  </div>
