<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수고하셨습니다!</title>
</head>
<body>

<h1>지원서 작성 완료!</h1>

<h3>제출하시겠습니까?</h3>

Photo_url = ${m.getPhoto_url() } <br />

<input TYPE = "BUTTON" VALUE = "다시 작성" ONCLICK = "location.href = 'joinForm1.jsp'">
<input TYPE = "SUBMIT" VALUE = "제출!" />



</body>
</html>