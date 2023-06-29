<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${noitem != null }">	
${noitem }
</c:if>
<c:remove var="noitem"/>

<c:if test="${fail != null }">	
${fail }
</c:if>
<c:remove var="fail"/>



<%@page contentType="text/html; charset=UTF-8"%>
<p>削除したい商品の名称を入力してください
<form action="../../itemdeletesearch/itemdeletesearch" method="post">
<input type="text" name="ITEM_NAME">
<input type="submit" name="ITEM_NAME" value="検索">
</form></p>
</body>
</html>