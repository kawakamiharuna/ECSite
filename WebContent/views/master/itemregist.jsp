<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@page contentType="text/html; charset=UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${erroritem1 != null }">	
${erroritem1 }
</c:if>
<c:remove var="erroritem1"/>

<c:if test="${erroritem2 != null }">	
${erroritem2 }
</c:if>
<c:remove var="erroritem2"/>


<form action="../../itemRegist/itemReagist" method="post">
新規商品登録
<p>商品名<input type="text" name="ITEM_NAME" required><br>
英語表記<input type="text" name="ENGLISH" required><br>
由来<input type="text" name="DERIVATION" required><br>
価格<input type="text" name="PRICE" required><br>
データシート<input type="text" name="DATASHEET"><br>
カテゴリー<select name="CATEGORY" required>
				<option value="">カテゴリーを選択</option>
				<option value="心臓">心臓</option>
				<option value="肝臓">肝臓</option>
				<option value="腎臓">腎臓</option>
				<option value="血管">血管</option>
				<option value="筋肉">筋肉</option>
				<option value="皮膚">皮膚</option>
				</select><br>
商品写真データ<input type="text" name="IMG">		
		
	<input type="submit" name="item-regist" value="登録">
	<input type="button" onClick="location.href='http://localhost:8080/ShoppingSite/views/master/master.jsp'" value="戻る">			
				
</form>
	<%@include file="../footer.jsp" %>

</body>
</html>