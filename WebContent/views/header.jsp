<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<%@page contentType="text/html; charset=UTF-8"%>

	<div class="header">
		<table>
			<td><img src="/ShoppingSite/img/header.png" alt="ロゴマーク" width="20px" height="20px"></td>
			<td>CellSell</td>
			<td><img src="/ShoppingSite/img/header.png" alt="ロゴマーク" width="20px" height="20px"></td>
			<td><a href="../all/all"
				onclick="event.preventDefault(); document.getElementById('myForm').submit();">商品一覧を見る</a></td>
			<td><a href="/ShoppingSite/views/home.jsp">ホームへ戻る</a></td>
			<td><a href="master/master.jsp">管理者</a></td>
		</table>











		<script>
			document.getElementById('submitButton').addEventListener('click',
					function(event) {
						event.preventDefault();
						document.getElementById('myForm').submit();
					});
		</script>
		<form action="../all/all" method="get" id="myForm">
			<!-- フォームの中身 -->
			<input type="submit" name="itemcontents" value="商品一覧を見る"
				style="display: none;">
		</form>
	</div>
</body>
</body>
</html>