<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<link rel="stylesheet" type="text/css" href="${ctx }/css/diaryviewerstyle.css?ver=2">

<div class="inner">
	<div class="diaryviewer">
	<h1> 어떤 우리의 일기를 볼까요?</h1>
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
					<div class="dlClubName">현재 우리는 ${dlClubName}</div>
					
					
					
					<div class="diarylistsection">
						<div class="dlpre-btn">
							<c:if test="${dlpage eq 0}">
								<input class="prebtnno" type="button" value="X">
							</c:if>
							<c:if test="${dlpage ne 0}">
								<input class="prebtnok"  type="button" onclick="dlmovepre()" value="◀">
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
									<div class="ddbtn">
										<button class="deletediarybutton" onclick="deletediary(${dld.getNum()})">삭제</button>
									</div>
									</c:when>
									<c:otherwise>
									<div class="ddbtn">
										<button class="hiddenbutton" value=""></button>
									</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
						<div class="diaryshowbtn">
							<c:forEach var="dlv" items="${diarylist}">
							<div class="dsbtn">
										<button onclick="viewdiary(${dlv.getNum()})">읽기</button>
							</div>
							</c:forEach>
						</div>
					</div>
					
						
						<div class="dlpost-btn">
							<c:if test="${dlpage eq dllastpage}">
								<input class="postbtnno" type="button" value="X">
							</c:if>
							<c:if test="${dlpage ne dllastpage}">
								<input class="postbtnok" type="button" onclick="dlmovepost()" value="▶">
							</c:if>
						</div>
					</div>
					
					<h2 class="diaryviewerboard"> ${dlpage+1}&ensp;/&ensp;${dllastpage+1}</h2>
					
				</c:when>
				<c:otherwise>
					<h2>우리 글이 없어요...
					<br><br>먼저 우리를 선택해 주세요!
					<br><br>우리일기가 없으면...
					<br><br>제일 처음 작성해 보시는건 어때요?</h2>
				</c:otherwise>
			</c:choose>
		</div>
		
	</div>



</div>


<script type="text/javascript" src="script/diaryviewer.js" defer></script>
<%@ include file="../parts/footer.jsp"%>
