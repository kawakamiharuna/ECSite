<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
<link rel="stylesheet" type="text/css" href="../css/cart.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Caprasimo&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@900&display=swap" rel="stylesheet">

</head>
<body>

<header><%@include file="header.jsp"%></header>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
	<div class="itemhome">
		<marquee scrollamount="7">
			<strong>CART</strong> <strong>CART</strong> <strong>CART</strong>
		</marquee>
	</div>
<div class="count">
<c:choose>
<c:when test="${cart.size() > 0 }">
<p>${cart.size() }items</p>
</c:when>
<c:otherwise>
<h2>No items found.</h2>
</div>
<form action="../all/all" method="post">
 
</form>
</c:otherwise>
</c:choose>

<ul class="all">
<c:forEach var="i" items="${cart }" >
<li><img src="/ShoppingSite/${i.getIMG()}"alt="" width="200px" height="200px"><br>
<a>${i.getITEM_NAME()}</a><br>
小計 <a>${i.getPRICE() * i.getQuantity() }</a>
<br>${i.getQuantity() }<br>

<div class="cart"><form action="../cartDelete/cartDelete" method="post">
  <input type="hidden" name="delete" value="${i.getNO()}">
  <input type="image" src="../img/cartremove.png" value="カートから削除" width="100px"
									height="100px">
</form></div>
</li>
</c:forEach> 
</ul>

<a href="preview.jsp">購入の手続きに進む</a> 
</main>
<footer><%@include file="footer.jsp"%></footer>


</body>
</html>