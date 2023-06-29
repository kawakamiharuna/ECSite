<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除情報</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ include file="header.jsp"%>

	<h1>下記の製品を削除しますか？</h1>

	<table>
		<tr>
			<th>製品イメージ</th>
			<th>製品名</th>
			<th>英語表記</th>
			<th>カテゴリー</th>
			<th>お値段</th>
			<th>データシート</th>
			<th>削除</th>
			<th>戻る</th>
		</tr>

		<c:forEach var="i" items="${result }">
			<tr>
				<td><img src="/ShoppingSite/${i.getIMG()}"></td>
				<td>${i.getITEM_NAME()}</td>
				<td>${i.getENGLISH()}</td>
				<td>${i.getCATEGORY()}</td>
				<td>${i.getDERIVATION()}</td>
				<td>${i.getPRICE() }</td>
				<td><a href="${i.getDATASHEET()}">データシート</a></td>
				<td><form action="../../itemdel/itemdel" method="post">
						<input type="hidden" name="deleteitem" value="${keyword}">
						<input type="submit" value="削除">
					</form></td>
				<td><input type="button"
					onClick="location.href='http://localhost:8080/ShoppingSite/views/master/master.jsp'"
					value="戻る"></td>
			</tr>
		</c:forEach>

	</table>




	<%@ include file="footer.jsp"%>

</body>
</html>
