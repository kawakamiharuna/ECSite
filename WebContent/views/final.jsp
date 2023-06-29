<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>最終確認</title>
<link rel="stylesheet" type="text/css" href="../css/final.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Caprasimo&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/splash.css">
</head>
</head>
<body>
<div id="splash">
		<div id="splash-logo">涙の成分は感情で変わる</div>
		<!--/splash-->
	</div>
	<div class="splashbg"></div>
	<!---画面遷移用-->
	<div id="containers">

<header><%@include file="header.jsp"%></header>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
<a>購入商品</a>
<table>
<tr>
<td>製品イメージ</td>
<td>名称</td>
<td>小計（税込み）</td>
<td>個数</td>

<c:set var="totalPrice" value="0" />

<c:forEach var="i" items="${cart }" >
<tr>
<td><img src="/ShoppingSite/${i.getIMG()}" width="70px" height="70px"></td>
<td>${i.getITEM_NAME()}</td>
<td>${i.getPRICE() * i.getQuantity() }円</td>
<td>${i.getQuantity() }個</td>
</tr>

<c:set var="subtotal" value="${i.getPRICE() * i.getQuantity()}" />
<c:set var="totalPrice" value="${totalPrice + subtotal}" />

</c:forEach>

<tr>
    <td colspan="2"></td>
    <td>合計金額：</td>
    <td>${totalPrice}円</td>
</tr>
</table>

<div><a>お客様情報</a><br>
<div class="custamer">
お名前：${i.getNAME() }様<br>
ご連絡先：${i.getTEL() }<br>
住所：${i.getADDRESS1() }${i.getADDRESS2() }${i.getADDRESS3() }<br>
お支払方法:${param.pay }</p></div></div>


<p>上記の内容で確定しますか？</p>
<a href="/ShoppingSite/views/end.jsp">確定</a>
<a href="/ShoppingSite/views/home.jsp">やめる</a>

</main>
<footer><%@include file="footer.jsp" %></footer>
</div>
<script src="../js/jquery-3.6.4.min.js"></script>
<script src="../js/splash.js"></script>
</body>
</html>