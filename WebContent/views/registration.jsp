<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>会員情報登録</title>
<link rel="stylesheet" type="text/css" href="../css/splash.css">
<link rel="stylesheet" type="text/css" href="../css/registration.css">
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
		<div id="splash-logo">人間は1秒間に約25万個の細胞を生産</div>
		<!--/splash-->
	</div>
	<div class="splashbg"></div>
	<!---画面遷移用-->
	<div id="containers">

	<%@page contentType="text/html; charset=UTF-8"%>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<header>
		<table>
			<td><img src="/ShoppingSite/img/header.png" alt="ロゴマーク"
				width="20px" height="20px"></td>
			<td>CellSell</td>
			<td><img src="/ShoppingSite/img/header.png" alt="ロゴマーク"
				width="20px" height="20px"></td>
		</table>
	</header>
	<main>
		<!--電話番号の桁違い -->
		<c:if test="${error1 != null }">
	${error1 }
	</c:if>
		<c:remove var="error1" />

		<!--郵便番号の桁が違う  -->
		<c:if test="${error2 != null }">
	${error2 }
	</c:if>
		<c:remove var="error2" />

		<!--  重複 -->
		<c:if test="${error3 != null }">
	${error3 }
	</c:if>
		<c:remove var="error3" />

		<!-- パスワードの重複 -->
		<c:if test="${errorpass != null }">
	${errorpass }
	</c:if>
		<c:remove var="errorpass" />





		<form action="../regist/regist" method="post">
			<h1>会員情報登録</h1>
			<p>
				ユーザー名<br> <input type="text" name="USER_NAME" required>
			</p>
			<p>
				パスワード<br> <input type="text" name="PASSWORD" required>
			</p>
			<p>
				氏名<br> <input type="text" name="NAME" required>
			</p>
			<p>
				生年月日<br> <input type="date" name="BIRTHDAY" required>
			</p>
			<p>
				メールアドレス <input type="email" name="MAIL" required>
			</p>
			<p>
				電話番号(ハイフンなし) <input type="text" name="TEL" required>
			</p>

			<p>
				郵便番号(ハイフンなし)<input type="text" name="POSTAL_CODE" required>
			</p>
			<p>
				住所（都道府県）<input type="text" name="ADDRESS1" required>
				住所（市区町村）<input type="text" name="ADDRESS2" required>
				住所（番地とそれ以降）<input type="text" name="ADDRESS3" required>
			</p>

			<input type="submit" name="regist" value="登録"> <input
				type="button"
				onClick="location.href='http://localhost:8080/ShoppingSite/views/index.jsp'"
				value="戻る">
		</form>
	</main>
	<footer><%@include file="footer.jsp"%></footer>
	</div>
<script src="../js/jquery-3.6.4.min.js"></script>
<script src="../js/splash.js"></script>

</body>

</html>