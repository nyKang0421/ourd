<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<div class="inner">
	<h1> 다이어리 뷰어</h1>
	<div class="diaryviewer">
		<div class="selectViewerClub">
			<label>우리선택하기</label>
			<select name="choiceViewerClub" id="choiceViewerClub">
				<option value="-1">우리를 선택하세요</option>
				<c:forEach var="cl" items="${memberclublist}">
					<option value='${cl.getNum()}'>${cl.getName()}</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="diarylist">
			<c:choose>
				
				<c:when test="${diarylist ne null }">
					<div class="dlClubName">${dlClubName}</div>
					
					<h2 class="diaryviewerboard"> ${dlpage+1}/${dllastpage+1}</h2>
					
					<div class="diarylistsection">
						<div class="dlpre-btn">
							<c:if test="${dlpage eq 0}">
								<input type="button" value="첫 페이지">
							</c:if>
							<c:if test="${dlpage ne 0}">
								<input type="button" onclick="dlmovepre()" value="이전">
							</c:if>
						</div>
					
					
					<div class="dllistinfo">
						<div class="diarywriter">
							<c:forEach var="dlw" items="${writerlist}">
								<div class="diarywriterinfo">${dlw}</div>
							</c:forEach>
						</div>
						<div class="diarytitle">
							<c:forEach var="dlt" items="${diarylist}">
								<div class="diarytitleinfo">${dlt.getTitle()}</div>
							</c:forEach>
						</div>
						<div class="diarydeletebtn">
							<c:forEach var="dld" items="${diarylist}">
								<c:choose>
									<c:when test="${dld.getWriter() eq lognum }">
										<button onclick="deletediary(${dld.getNum()})">삭제하기</button>
									</c:when>
									<c:otherwise>
										<input type="hidden">
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
						<div class="diarydeletebtn">
							<c:forEach var="dlv" items="${diarylist}">
										<button onclick="viewdiary(${dlv.getNum()})">보기</button>
							</c:forEach>
						</div>
					</div>
					
						
						<div class="dlpost-btn">
							<c:if test="${dlpage eq dllastpage}">
								<input type="button" value="마지막페이지">
							</c:if>
							<c:if test="${dlpage ne dllastpage}">
								<input type="button" onclick="dlmovepost()" value="다음">
							</c:if>
						</div>
					</div>
					
				</c:when>
				<c:otherwise>
					우리 글이 없어요
				</c:otherwise>
			</c:choose>
		</div>
		
	</div>



</div>

<div class="overlay"></div>

<script type="text/javascript" src="script/diaryviewer.js" defer></script>
<%@ include file="../parts/footer.jsp"%>
<%@ include file="../parts/viewModal.jsp" %>