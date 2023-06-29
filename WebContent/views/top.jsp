<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/ShoppingSite/css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="../views/menu.jsp" method="post">
	<h1 style="text-align:center">Styley</h1>
	<li style="text-align: right; display: flex; justify-content: flex-start; align-items: center; list-style: none;"><a href="../views/menu.jsp" style="font-size: 1.8em;">ログアウト</a></li>
	</form>
	<ul style="text-align: right; display: flex; justify-content: flex-end; align-items: center; list-style: none;"> 
   <li style="border-right: #ddd 1px solid; padding: 0 10px;"><a href="/ShoppingSite/views/main.jsp" style="font-size: 1.5em;">TOP</a></li>
   <li style="border-right: #ddd 1px solid; padding: 0 10px;"><a href="#bicycle" style="font-size: 1.5em;">購入</a></li>
   <li style="padding: 0 10px;"><a href="/ShoppingSite/views/cart.jsp"><img src="../img/cart.png" style="width: 50px;"></a>
	</ul>
	<hr style="height:3; background-color:#000ff" />
	<br>
	<br>
	<div class="slide"></div>
        <img src="../img/01.jpg" alt="">
        <img src="../img/02.jpg" alt="">
        <img src="../img/03.jpg" alt="">
      </div>
</body>
</html>