<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OURD 우리끼리 쓰는 다이어리</title>
<link rel="stylesheet" type="text/css" href="${ctx }/css/style.css?ver=1">
<script type="text/javascript" src="script/base.js" defer></script>



</head>
<body onload ="">

	<div class="container">
		<header>
			<div class="header part1">
				<div class="logo">
					<p>이미지 자리
				</div>
				<div class="slogan"> 우리만의 비밀일기 OURD</div>
				<div class="loginUser">
					<div class="guest User"> guest</div>
					<div class="login User">
					<div class="loginName">test111</div>
					<input type="button" class="logout" value="로그아웃"/>
				</div>
				</div>
				
			</div>
			<div class="header part2">
				<div class="guest gnb">
				<input type="button" class="menu login" value="로그인"/>
				<input type="button" class="menu join" value="가입하기"/>
				</div>
				<div class="login gnb">
					<input type="button" class="menu write" value="일기쓰기"/>
					<input type="button" class="menu view" value="일기읽기"/>
					<input type="button" class="menu we" value="우리하기"/>
					<input type="button" class="menu message" value="쪽기보기"/>
					<input type="button" class="menu info" value="내정보"/>
				</div>
			</div>
		</header>
		
		<main>
			<div class="banner left">좌측배너</div>
		
			
			
		