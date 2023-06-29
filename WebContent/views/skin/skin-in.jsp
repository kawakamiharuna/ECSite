<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.bean.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果(皮膚)</title>
<link rel="stylesheet" type="text/css" href="../../css/liver/liver.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Caprasimo&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../../css/splash.css">


<link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@900&display=swap" rel="stylesheet">
</head>
<body>
<div id="splash">
		<div id="splash-logo">人間の皮膚は毎月生まれ変わり生涯で20kgも捨てている</div>
		<!--/splash-->
	</div>
	<div class="splashbg"></div>
	<!---画面遷移用-->
	<div id="containers">
<header><%@ include file="header.jsp" %></header>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="../item-category.jsp">カテゴリー選択に戻る</a>
	<div class="liverhome">
		<marquee scrollamount="7">
			<strong>SKIN</strong> <strong>SKIN</strong> <strong>SKIN</strong>
		</marquee>
	</div>

    <%-- Sessionからlistを取得 --%>
    <% HttpSession sessionObj = request.getSession(); %>
    <% List<Item> list = (List<Item>) sessionObj.getAttribute("list"); %>

    <%-- listのデータを表示（全商品）--%>
   <c:forEach var="item" items="${list}">
		<div class="liver">
			<figure class="image">
				<img src="/ShoppingSite/${item.getIMG()}" alt="">
				
			</figure>
			<div class="fount">
				<p>
				<a>${item.getITEM_NAME()}</a><br> 英名<br> <a>${item.getENGLISH()}</a><br>
					カテゴリー<br> <a>${item.getCATEGORY()}</a><br> 由来<br> <a>${item.getDERIVATION()}</a><br>

					お値段(税込み)<br>
					<a>${item.getPRICE()}</a> <br> <a
						href="${item.getDATASHEET()}">データシート</a>
				</p>
			</div>
			<form action="../../cartAdd/cartAdd" method="post">
					<input type="hidden" name="NO" value="${item.getNO()}"> <input
						type="image" src="../../img/cart.png" value="カートに追加" width="200px"height="200px">
				</form>
		</div>

	</c:forEach>


    <%-- listが空の時 --%>
    <c:if test="${empty list}">
        <tr>
            <td colspan="8"><h2>No items found.</h2></td>
        </tr>
    </c:if>
</table>

<footer><%@ include file="footer.jsp" %></footer>
</div>
<script src="../../js/jquery-3.6.4.min.js"></script>
<script src="../../js/splash.js"></script>
</body>
</html>