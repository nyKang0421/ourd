<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OURD 우리끼리 쓰는 다이어리</title>
<link rel="stylesheet" type="text/css" href="${ctx }/css/style.css?ver=10">
<script type="text/javascript" src="script/base.js" defer></script>



</head>
<body onload ="">

	<div class="container">
		<header>
			<div class="header part1">
				<div class="logo">
					<img id="toplogo" src="/Uploads/OURDLOGO.jpg" alt="OURDLOGO.jpg"/>
				</div>
				<div class="slogan"></div>
				<div class="loginUser">
					<c:choose>
						<c:when test="${lognum eq null}">
							<div class="guest User">방문을 환영합니다!!</div>
						</c:when>
						<c:otherwise>
							<div class="loginName">${lognickname}</div>
							<input type="button" class="logout" onclick="location.href='${ctx}/userlogout.do'" value="로그아웃"/>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="header part2">
			
				<c:choose>
						<c:when test="${lognum eq null}">
							<div class="guest gnb">
							<input type="button" class="menu home" onclick="location.href='${ctx}/main.do'" value="홈"/>
							<input type="button" class="menu login" onclick="location.href='${ctx}/gologin.do'" value="로그인"/>
							<input type="button" class="menu join" onclick="location.href='${ctx}/gojoin.do'" value="가입하기"/>
							</div>
						</c:when>
						<c:otherwise>
							<div class="login gnb">
							<input type="button" class="menu home" onclick="location.href='${ctx}/main.do'" value="홈"/>
							<input type="button" class="menu write" onclick="location.href='${ctx}/godiarywrite.do'" value="일기쓰기"/>
							<input type="button" class="menu view" onclick="location.href='${ctx}/godiaryviewer.do'" value="일기읽기"/>
							<input type="button" class="menu we" onclick="location.href='${ctx}/gowe.do'" value="우리하기"/>
							<input type="button" class="menu message" onclick="location.href='${ctx}/gomessage.do'" value="쪽기보기"/>
							<input type="button" class="menu info" onclick="location.href='${ctx}/myinfo.do'" value="내정보"/>
							</div>
						</c:otherwise>
					</c:choose>
			
			</div>
		</header>
		
		<main>
			<div class="banner left" id="banner-left">
				<img src="/Uploads/coupang.jpg" alt="coupang.jpg"/>
			</div>
		
			
			
		