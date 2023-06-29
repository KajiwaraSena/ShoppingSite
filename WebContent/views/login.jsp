<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url(../img/siro.jpg); background-size: 1300px 800px;">
<div style="text-align:center;">
<h2 style="text-align:center">Styley</h2>
<hr style="height:3; background-color:#000ff" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- エラーメッセージ -->
<c:if test="${errormsg != null }">${errormsg}</c:if>
<c:remove var="errormsg"/>
<br>
<br>
<br>
<br>
<br>
<!-- ログイン用フォーム -->
<form action="/ShoppingSite/servlet/loginServlet" method="post">
<p style="text-align:center">氏名<input type="text" name="name"></p>
<br>
<p style="text-align:center">パスワード<input type="password" name="password"></p>
<br>
<p style="text-align:center"><input type="submit" value="ログイン"></p>
</form>
</div>
</body>
</html>