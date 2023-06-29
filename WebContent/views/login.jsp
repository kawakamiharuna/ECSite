<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<c:if test="${nologin != null }">	
${nologin }
</c:if>
<c:remove var="nologin"/>
	
	
<!-- ログイン用フォーム -->
<form action="../logins/logins" method="post">
<p>ユーザ名<input type="text" name="USER_NAME"></p>
<p>パスワード<input type="password" name="PASSWORD"></p>
<p><input type="submit" value="ログイン">
<input type="reset" name="reset" value="リセット"> 
</form>

<%@include file="footer.jsp"%>
</body>
</html>