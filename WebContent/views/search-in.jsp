<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.bean.Item"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link rel="stylesheet" type="text/css" href="../css/splash.css">
<link rel="stylesheet" type="text/css" href="../css/allsearch.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Caprasimo&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@900&display=swap"
	rel="stylesheet">

</head>
<body>
<div id="splash">
		<div id="splash-logo">人の体温は30分ほどで約4Lの水を蒸発させる</div>
		<!--/splash-->
	</div>
	<div class="splashbg"></div>
	<!---画面遷移用-->
	<div id="containers">
	<header><%@ include file="header.jsp"%></header>
	<main>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


		<div class="searchhome">
			<marquee scrollamount="7">
				<strong>ITEM</strong> <strong>ITEM</strong> <strong>ITEM</strong>
			</marquee>
		</div>


		<a href="item-category.jsp">カテゴリー別に見る</a><br>



		<%-- Sessionからlistを取得 --%>
		<%
		HttpSession sessionObj = request.getSession();
		%>
		<%
		List<Item> list = (List<Item>) sessionObj.getAttribute("list");
		%>


		<c:forEach var="i" items="${list }">
			<div class="search">
				<div class="img">
					<img src="/ShoppingSite/${i.getIMG()}" width="200px" height="200px">
										
				</div>
				<div class="fount">
					<p>
						<a>${i.getITEM_NAME()}</a><br> 英名<br>
						<a>${i.getENGLISH()}</a><br> カテゴリー<br>
						<a>${i.getCATEGORY()}</a><br> 由来<br>
						<a>${i.getDERIVATION()}</a><br> <a>${i.getPRICE() }円</a><br>
						<a href="${i.getDATASHEET()}">データシート</a>
					</p>
				</div>
			<form action="../cartAdd/cartAdd" method="post">
  <input type="hidden" name="NO" value="${i.getNO()}">
  <input type="image" src="../img/cart.png" value="カートに追加" width="200px" height="150px">
</form>
			</div>
		</c:forEach>
		<%-- listが空の時 --%>
		<c:if test="${empty list}">
			<tr>
				<td colspan="8"><h2>No items found.</h2></td>
			</tr>
		</c:if>

	</main>
	<footer><%@ include file="footer.jsp"%></footer>
	</div>
<script src="../js/jquery-3.6.4.min.js"></script>
<script src="../js/splash.js"></script>
</body>
</html>