<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>腎臓</title>
<link rel="stylesheet" type="text/css" href="../../css/liver/liveritem.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Caprasimo&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../../css/splash.css">
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@900&display=swap" rel="stylesheet">
</head>
<body>
<div id="splash">
		<div id="splash-logo">腎臓は我慢強い臓器</div>
		<!--/splash-->
	</div>
	<div class="splashbg"></div>
	<!---画面遷移用-->
	<div id="containers">
<%@page contentType="text/html; charset=UTF-8"%>

	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header><%@include file="header.jsp"%></header>
	<main>
	<div class="liverhome">
		<marquee scrollamount="7">
			<strong>KIDNEY</strong> <strong>KIDNEY</strong> <strong>KIDNEY</strong>
		</marquee>
	</div>
	
<div class="search">
	<form action="../../kidneysearch/kidneysearch" method="post">
	検索<input type="text" name="keywordKidney">
	<img alt="虫眼鏡" src="/ShoppingSite/img/search.png">
	<input type="submit" value="検索">
	</form>
	</div>

<ul class="item">
<c:forEach var="i" items="${list }" >

<li><img src="/ShoppingSite/${i.getIMG()}" width="200px" height="200px"><br>
<h2>${i.getITEM_NAME()}<br></h2>
${i.getENGLISH()}<br>
${i.getDERIVATION()}由来<br>
<a>${i.getPRICE() }円<br></a>
<a href="${i.getDATASHEET()}">データシート</a><br>
<p class="cart">
<form action="../../cartAdd/cartAdd" method="post">
  <input type="hidden" name="NO" value="${i.getNO()}">
  <input type="image" src="../../img/cart.png" value="カートに追加" width="200px" height="150px">
</form>
</p>
</li>

</c:forEach> 
</ul>

<p class="cate">
<a href="/ShoppingSite/views/item-category.jsp">カテゴリー別に見る</a></p>
</main>
	<footer><%@include file="footer.jsp"%></footer>	
	</div>
<script src="../../js/jquery-3.6.4.min.js"></script>
<script src="../../js/splash.js"></script>

</body>
</html>