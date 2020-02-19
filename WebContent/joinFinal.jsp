<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "model.Model"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<%
	//Model m = (Model) request.getAttribute("m");
	//session.setAttribute("m", m);
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수고하셨습니다!</title>
</head>
<body>

	<h1>지원서 작성 완료!</h1>

	<h3>제출하시겠습니까?</h3>

	name_ko =__${m.getName_ko() }__ <br />
	birthdate =__${m.getBirth() }__<br />
	photo_url = ${m.getPhoto_url() }
	<br />

	<form action="finalapply" method="POST">
		<input TYPE="BUTTON" VALUE="다시 작성" ONCLICK="location.href = 'joinForm1.jsp'">
		<input TYPE="SUBMIT" VALUE="제출!" />
	</form>

</body>
</html>