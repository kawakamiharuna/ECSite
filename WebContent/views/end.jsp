<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お買い上げありがとうございました</title>
<link rel="stylesheet" type="text/css" href="../css/end.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Caprasimo&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Rampart+One&display=swap" rel="stylesheet">


</head>
<body>
<header><%@include file="header.jsp" %></header>



<div class="thankyou">
		<marquee scrollamount="7">
			<strong>お買い上げありがとうございました</strong> <strong>Thank you</strong> <strong>Thank you</strong>
		</marquee>
	</div>
	<p>
<img alt="thankyou" src="../img/finish1.png" class="keyframe1 animation"width="100px" height="100px"></p>
	<div class="human"><a href="logout.jsp">ログアウト</a></div>
	<footer><%@include file="footer.jsp" %></footer>
</body>
</html>