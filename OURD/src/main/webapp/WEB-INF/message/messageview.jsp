<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<div class="inner"> 
	<div class="messageview">
		<div class="takemessage">
			<h1>받은 메세지 표현</h1>
			<c:choose>
				<c:when test="${logTakeMsg ne null }">
				<div class="prebutton-take">
					<c:choose>
						<c:when test="${takePage eq 0 }">
							<input type="button" class="btn-first-takemessage" onclick="" value="첫 페이지에요"/>
						</c:when>
						<c:otherwise>
							<input type="button" class="btn-pre-takemessage" onclick="location.href='${ctx}/movetakepage.do?move=pre'" value="이전"/>
						</c:otherwise>
					</c:choose>
				</div>
				
				<div class="takemassagebox">
					<div class="taketext">
						<c:forEach var="ttl" items="${takeText }">
						<div class ="takemessage">
						<span class ="msgUserName">${ttl }</span>
						</div>
						</c:forEach>
					
					</div>
					
					<div class ="takebutton">
					
						<c:forEach var="ttl" items="${logTakeMsg }">
							<input type="button" class="btn-agree" onclick="agreeMsg(${ttl.getNum()})" value="우리하기"/>
							<input type="button" class="btn-disagree" onclick="disagreeMsg(${ttl.getNum()})" value="거절하기"/>
						</c:forEach>
					
					</div>
					
				</div>
				
				<div class="postbutton-take">
					<c:choose>
						<c:when test="${takePage eq takeLast }">
							<input type="button" class="btn-last-takemessage" onclick="" value="마지막 페이지에요"/>
						</c:when>
						<c:otherwise>
							<input type="button" class="btn-post-takemessage" onclick="location.href='${ctx}/movetakepage.do?move=post'" value="다음"/>
						</c:otherwise>
					</c:choose>
				</div>
				</c:when>
				
				<c:otherwise>
					<h3>받은 메시지가 없어요...</h3>
				</c:otherwise>
			
			</c:choose>
			
		</div>
		
		<div class="sendmessage">
			
			<h1>보낸 메세지 표현</h1>
			<c:choose>
				<c:when test="${logSendMsg ne null }">
				<div class="prebutton-send">
					<c:choose>
						<c:when test="${sendPage eq 0 }">
							<input type="button" class="btn-first-sendmessage" onclick="" value="첫 페이지에요"/>
						</c:when>
						<c:otherwise>
							<input type="button" class="btn-pre-sendmessage" onclick="location.href='${ctx}/movesendpage.do?move=pre'" value="이전"/>
						</c:otherwise>
					</c:choose>
				
				</div>
					
			<div class="sendmessagebox">
				<div class="sendtext">
					<c:forEach var="stl" items="${sendText }">
						<div class ="takemessage">
						<span class ="msgUserName">${stl }</span>
						</div>
					</c:forEach>
				</div>
				<div class ="sendbutton">
					<c:forEach var="stl" items="${logSendMsg }">
						<c:if test="${stl.getState() < 5 }">
							<input type="button" class="btn-check-stay" onclick="" value="기다려 주세요"/>
						</c:if>
						<c:if test="${stl.getState() > 4 }">
							<input type="button" class="btn-check-pro" onclick="checkMsg(${stl.getNum()})" value="확인"/>
						</c:if>
					</c:forEach>
				</div>
			</div>
			
			<div class="postbutton-send">
					<c:choose>
						<c:when test="${sendPage eq sendLast }">
							<input type="button" class="btn-last-sendmessage" onclick="" value="마지막 페이지에요"/>
						</c:when>
						<c:otherwise>
							<input type="button" class="btn-post-sendessage" onclick="location.href='${ctx}/movesendpage.do?move=post'" value="다음"/>
						</c:otherwise>
					</c:choose>
			</div>
			
				</c:when>
				<c:otherwise>
					<h3>보낸 메시지가 없어요...</h3>
				</c:otherwise>
			</c:choose>
			
		</div>
		
	</div>
</div>

<script type="text/javascript" src="script/message.js" defer></script>

<%@ include file="../parts/footer.jsp"%>