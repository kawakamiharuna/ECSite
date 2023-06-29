<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="header.jsp"%>

<form action="pay" method="post">
<p>決算方法を選択してください<br>
<input type="radio" name="pay" value="クレジット" required>クレジット
<input type="radio" name="pay" value="コンビニ" required>コンビニ
<input type="radio" name="pay" value="代引き" required>代引き
</p>

<p>お届け先の住所<br>
<input type="radio" name="old" value="会員情報にご登録の住所">会員情報にご登録の住所<br>
別の住所をご希望の方は下記にご記入ください<br>
郵便番号<input type="text" name="new">
住所<input type="text" name="newaddress">
</p>
<p>

<input type="submit" name="next" value="確認画面へ進む">
<input type="button" onClick="/ShoppingSite/views/home.jsp" value="最初からやり直す">
</p>
</form>
<%@include file="footer.jsp"%>
</body>
</html>