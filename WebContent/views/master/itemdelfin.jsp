<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除最後</title>
</head>
<body>

<%@ include file="header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty finish }">	
    ${finish }
</c:if>


<c:if test="${fail != null }">	
${fail }
</c:if>

<%@ include file="footer.jsp"%>
</body>
</html>

<