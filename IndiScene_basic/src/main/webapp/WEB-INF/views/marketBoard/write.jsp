<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<c:set var = "root" value="${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기</title>
<script type="text/javascript" src="${root }/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/css/style.css">
</head>
<body>
	<form class="form_style" action="${root}/fileBoard/write.do" method="post"
		onsubmit="return checkForm(this)" enctype="multipart/form-data">
		<input type="hidden" name="boardNumber" value="${boardNumber }" />
		<input type="hidden" name="groupNumber" value="${groupNumber }" />
		<input type="hidden" name="sequenceNumber" value="${sequenceNumber }" />
		<input type="hidden" name="sequenceLevel" value="${sequenceLevel }" />

		<div
			style="width: 598px; height: 15px; border-width: 2px; text-align: right; padding: 15px 0px 0px 0px; border-bottom-width: 0px;">
			글목록</div>

.		<div class="line">
			<label class="title">작성자</label> <span class="content"> 
			<input type="text" name="writer" />
			</span>
		</div>

		<div class="line">
			<label class="title">제목</label> 
			<c:if test="${boardNumber==0 }">
				<span class="content">
				<input type="text" size="50" name="subject"/></span>
			</c:if>
			<c:if test="${boardNumber!=0 }">
				<span class="content">
				<input type="text" size="50" name="subject" value="[답글]"/></span>
			</c:if>
		</div>

		<div class="line">
			<label class="title">이메일</label> <span class="content"> 
			<input
				type="text" size="50" name="email" />
			</span>
		</div>

		<div class="line" style="height: 230px;">
			<label class="title" style="height: 230px;">내용</label> 
			<span
				class="content" style="height: 230px;">
				 <textarea rows="14"
					cols="58" name="content"></textarea>
			</span>
		</div>

		<div class="line">
			<label class="title">비밀번호</label> 
			<span class="content"> 
			<input
				type="password" name="password" />
			</span>
		</div>
		<div class="line">
			<label class="title">파일명</label> 
			<span class="content"> 
			<input
				type="file" name="file" />
			</span>
		</div>

		<div class="line"
			style="width: 598px; border-width: 2px; text-align: center;">
			<input type="submit" value="글쓰기" /> <input type="reset" value="다시작성" />
			<input type="button" value="목록보기" onclick=" " />
		</div>
	</form>
</body>
</html>