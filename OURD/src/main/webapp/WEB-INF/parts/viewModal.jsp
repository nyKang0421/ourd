<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="modal diaryview-modal">
    <div class="modal-diaryview">
      <div class="diaryviewer-header">
      	
        <c:if test="${viewdiary eq null }">
	        <p class="viewmessage" id="viewmessage">다이어리를 읽는데 실패했어요...</p>
      	</c:if>
      	<c:if test="${viewdiary ne null }">
	        <div class="viewer-img">
	        	<img name="viewerimg" id="viewerimg" 
	        		src="/Uploads/${viewdiary.getImg()}"
	        		style="width: 300px; height: 400px;"/>
	        </div>
	        <div class="viewer-contents">
	        	<div class="viewer-header">
	        		<div class="viewer-date">날짜 : ${viewdiary.getDate()}</div>
	        		<div class="viewer-weather">날씨 : ${viewdiary.getWeather()}</div>
	        	</div>
	        	<div class="viewer-feel">기분 : ${viewdiary.getFeel()}</div>
	        	<div class="viewer-writer">글쓴이 : ${viewdiary.getWriter()}</div>
	        	<div class="viewer-title">제목 : ${viewdiary.getTitle()}</div>
	        	<div class="viewer-content">${viewdiary.getContent()}</div>
	        </div>
      	</c:if>
      	
      	<button class="btn-close viewer-close" onclick="closediary()"> 닫기 </button>
      	
      </div>
    </div>
  </div>