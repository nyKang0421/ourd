<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<div class="inner">
	<c:if test="${memberclublist eq null }">
		<h1>우리가 없어요.. 먼저 우리를 만들어 주세요</h1>
	</c:if>
	<c:if test="${memberclublist ne null }">
	<div class="diarywrite">
		<h1> 다이어리 작성창 입니다</h1>
		
		
			<div class="textarea-write">
			<form class="diarywriteForm" id="diarywriteForm" action="${ctx}/adddiary.do">
				<div class="row">
					<div class="field">
						<label>우리선택하기</label>
							<select name="choiceClub" id="choiceClub">
								<option value="-1">우리를 선택하세요</option>
								<c:forEach var="cl" items="${memberclublist}">
									<option value='${cl.getNum()}'>${cl.getName()}</option>
								</c:forEach>
							</select>
					</div>
				</div>
				
				<div class="row">
					<div class="field">
						<label>날짜선택</label>
						<input type="date" name="diarydate" id="diarydate" size="25" required/>
						
						
						<label>지역선택(날씨)</label>
							<select name="choiceweather" id="choiceweather">
								<option value="-1">날씨선택(지역)</option>
								<option value='2'>서울경기</option>
								<option value='33'>강원도</option>
								<option value='43'>충청북도</option>
								<option value='41'>충청남도</option>
								<option value='63'>전라북도</option>
								<option value='61'>전라남도</option>
								<option value='54'>경상북도</option>
								<option value='55'>경상남도</option>
								<option value='64'>제주도</option>
								
							</select>
					</div>
				</div>
				
				<div class="row">
					<div class="field">
						<label>일기쓰는 기분은?</label>
						<input type="text" name="inputfeel" id="inputfeel" size="25" required placeholder="기분을 적을까요?">
					</div>
				</div>
				
				<div class="row">
					<div class="field">
						<label>일기 제목</label>
						<input type="text" name="inputtitle" id="inputtitle" size="25" required placeholder="제목을 적어주세요">
					</div>
				</div>
				
				<div class="row">
					<div class="field">
						<label>일기 내용</label>
						<textarea class="inputcontent" id="inputcontent" name="info" maxlength="250" style="width: 300px; height: 100px;" required placeholder="내용을 적어주세요"></textarea>
					</div>
				</div>
				<input class="imgVal" id="imgVal" type="hidden" name="img" value="" />
				<input class="weatherresult" id="weatherresult" type="hidden" name="weatherresult" value="" />
			</form>	
			</div>
			
			
			
			<div class="imgarea-write">
				<div class="row">
					<div class="field">
						<label>일기사진</label>
						<img name="img" id="inputImg"
                     		 src="https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg" style="width: 300px; height: 400px;"/>
                     		<form id="imguploadform" action ="uploadDiaryImg.do" method="post" enctype="multipart/form-data">
                     			<input type="file" id="formfile" name="uploadfile" accept="image/*">
                     		</form>
                     		<input type="button" class="btn-imgupload" onclick="uploadImg()" value="사진업로드"/>
					</div>
				</div>
			</div>
			
			
	</div>
	
	<div class="diarysubmit">
		<input type="button" class="btn-submitdiary" onclick="submitdiary()" value="일기등록"/>
	</div>
	</c:if>
	
</div>

<script type="text/javascript" src="script/diarywrite.js" defer></script>
<%@ include file="../parts/footer.jsp"%>