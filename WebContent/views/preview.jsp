<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>最終確認</title>
<link rel="stylesheet" type="text/css" href="../css/preview.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Caprasimo&display=swap" rel="stylesheet">
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header><%@ include file="header.jsp"%></header>
<main>
<c:choose>
<c:when test="${cart.size() > 0 }">
<p>${cart.size() }items</p>
</c:when>
<c:otherwise>
<p>No items found.</p>
<form action="../all/all" method="post">
</form>
</c:otherwise>
</c:choose>
<div class="item">
<table>

<tr class="title">
<td>製品イメージ</td>
<td>名称</td>
<td>小計（税込み）</td>
<td>個数</td>
</tr>

<c:set var="totalPrice" value="0" />
<c:forEach var="i" items="${cart }" >
<tr>
<td><img src="/ShoppingSite/${i.getIMG()}"width="100px" height="100px"></td>
<td>${i.getITEM_NAME()}</td>
<td>${i.getPRICE() * i.getQuantity() }円</td>
<td>${i.getQuantity() }個</td>
</tr>

<c:set var="subtotal" value="${i.getPRICE() * i.getQuantity()}" />
<c:set var="totalPrice" value="${totalPrice + subtotal}" />

</c:forEach>

<tr>
    <td colspan="3"></td>
    <td>合計金額：</td>
    <td>${totalPrice}円</td>
</tr>
</table>
</div>
<c:if test="${nologin != null }">	
${nologin }
</c:if>
<c:remove var="nologin"/>
	
	
<!-- ログイン用フォーム -->
<form action="../login/login" method="post">
<p>ユーザ名<input type="text" name="USER_NAME" required></p>
<p>パスワード<input type="password" name="PASSWORD" required></p>
<p>お支払方法を選択してください<br>
<input type="radio" name="pay" value="クレジット" required>クレジット
<input type="radio" name="pay" value="コンビニ" required>コンビニ
<input type="radio" name="pay" value="代引き" required>代引き
</p>
<p><input type="submit" value="送信">
<input type="reset" name="reset" value="リセット"> 
</form>
</main>
<footer><%@include file="footer.jsp"%></footer>
</body>
</html>