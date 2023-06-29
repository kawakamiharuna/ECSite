<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/splash.css">
<link rel="stylesheet" type="text/css" href="../css/item-cate.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Caprasimo&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@900&display=swap"
	rel="stylesheet">

<title>商品一覧</title>
</head>
<body>
	<div id="splash">
		<div id="splash-logo">人間のDNAの50％は「バナナ」と同じ</div>
		<!--/splash-->
	</div>
	<div class="splashbg"></div>
	<!---画面遷移用-->
	<div id="containers">
		<%@page contentType="text/html; charset=UTF-8"%>
		<header><%@include file="header.jsp"%></header>

		<main>
			<div class="catego">
				<marquee scrollamount="7">
					<strong>CATEGORY</strong> <strong>CATEGORY</strong> <strong>CATEGORY</strong>
				</marquee>
			</div>
			<a href="cart.jsp">カートを見る</a>
			<ul class="category">
				<li class="category1">
					<div class="icon">
						<a href="../heartitem/heartitem"><img
							src="../img/heart/hearthome.png" alt="心臓"></a>
					</div>
					<h2 class="title">心臓</h2>
				</li>

				<li class="category2">
					<div class="icon">
						<a href="../kidneyitem/kidneyitem"><img
							src="../img/kidney/kidneyhome.png" alt="腎臓"></a>
					</div>
					<h2 class="title">腎臓</h2>
				</li>

				<li class="category3">
					<div class="icon">
						<a href="../skinitem/skinitem"><img
							src="../img/skin/skinhome.png" alt="皮膚"></a>
					</div>
					<h2 class="title">皮膚</h2>
				</li>
			</ul>

			<ul class="category">
				<li class="category4">
					<div class="icon">
						<a href="../liveritem/liveritem"><img
							src="../img/liver/liverhome.png" alt="肝臓"></a>
					</div>
					<h2 class="title">肝臓</h2>
				</li>

				<li class="category5">
					<div class="icon">
						<a href="../muscleitem/muscleitem"><img
							src="../img/muscle/muscle22.png" alt="筋肉"></a>
					</div>
					<h2 class="title">筋肉</h2>
				</li>

				<li class="category6">
					<div class="icon">
						<a href="../blooditem/blooditem"><img
							src="../img/blood/bloodhome.png" alt="血管"></a>
					</div>
					<h2 class="title">血管</h2>
				</li>
			</ul>
	</div>
	<script src="../js/jquery-3.6.4.min.js"></script>
	<script src="../js/splash.js"></script>
	</main>

	<%@page contentType="text/html; charset=UTF-8"%>
	<footer><%@include file="footer.jsp"%></footer>
</body>
</html>