<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.bean.Item"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<title>商品一覧</title>
<link rel="stylesheet" type="text/css" href="../css/splash.css">
<link rel="stylesheet" type="text/css" href="../css/all.css">
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
		<div id="splash-logo">ips細胞のiは「iPod」のように普及してほしいとの願いが込められている</div>
		<!--/splash-->
	</div>
	<div class="splashbg"></div>
	<!---画面遷移用-->
	<div id="containers">
		<header><%@ include file="header.jsp"%></header>

		<main>
			<div class="itemhome">
				<marquee scrollamount="7">
					<strong>ITEM</strong> <strong>ITEM</strong> <strong>ITEM</strong>
				</marquee>
			</div>

			<div class="search">
				<form action="../search/search" method="post">
					検索<input type="text" name="keyword"> <img alt="虫眼鏡"
						src="/ShoppingSite/img/search.png"> <input type="submit"
						value="検索">
				</form>
			</div>

			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

			<c:if test="${error1 != null}">
    ${error1}
</c:if>
			<c:remove var="error1" />

			<p class="first">
				<a href="item-category.jsp">カテゴリー別に見る</a>
				<a href="cart.jsp">カートを見る</a>
			</p>

			<%-- Sessionからlistを取得 --%>
			<%
			HttpSession sessionObj = request.getSession();
			%>
			<%
			List<Item> list = (List<Item>) sessionObj.getAttribute("list");
			%>

			<%-- listのデータを表示（全商品）--%>
			<ul class="all">
				<c:forEach var="i" items="${list }">

					<li><img src="/ShoppingSite/${i.getIMG()}" alt=""
						width="200px" height="200px"> <br>

						<h2>${i.getITEM_NAME()}</h2>
						<br> 英名<br>
					<a>${i.getENGLISH()}</a><br> カテゴリー<br>
					<a>${i.getCATEGORY()}</a><br> <a>${i.getDERIVATION()}</a>由来<br>
						お値段(税込み)<a>${i.getPRICE() }円</a> <br> <a
						href="${i.getDATASHEET()}">データシート</a>

						<div class="cart">
							<form action="../cartAdd/cartAdd" method="post">
								<input type="hidden" name="NO" value="${i.getNO()}"> <input
									type="image" src="../img/cart.png" value="カートに追加" width="100px"
									height="100px">
							</form>
						</div></li>

				</c:forEach>
			</ul>

			<%-- listが空の時 --%>
			<c:if test="${empty list}">
				<tr>
					<td colspan="8"><h2>No items found.</h2></td>
				</tr>
			</c:if>
			<div class="top">
			<p id="page-top"><a href="#">Topに戻る</a></p>
			</div>
		</main>
		<footer><%@ include file="footer.jsp"%></footer>
	</div>
	
	
	<script src="../js/jquery-3.6.4.min.js"></script>
	<script src="../js/splash.js"></script>
	<script src="../js/toppage.js"></script>
</body>
</html>
