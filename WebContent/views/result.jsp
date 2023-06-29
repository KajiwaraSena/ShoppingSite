<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url(../img/siro.jpg); background-size: 100% 100%; color:">
<header>
		<h1 style="text-align:center">Styley</h1>
</header>
	<form action="../views/menu.jsp" method="post">
	<li style="text-align: right; display: flex; justify-content: flex-start; align-items: center; list-style: none;"><a href="../views/menu.jsp" style="font-size: 1.8em;">ログアウト</a></li>
	</form>
	<ul style="text-align: right; display: flex; justify-content: flex-end; align-items: center; list-style: none;"> 
   <li style="border-right: #ddd 1px solid; padding: 0 10px;"><a href="/ShoppingSite/views/main.jsp" style="font-size: 1.5em;">TOP</a></li>
   <li style="padding: 0 10px;"><a href="/ShoppingSite/views/cart.jsp"><img src="../img/cart.png" style="width: 50px;"></a>
	</ul>
	<hr style="height:3; background-color:#000ff" />
	<br>
	<br>
	<h1 style="text-align: center;">購入結果</h1>
	<p style="text-align: center;">購入しました。<img src="../img/thankyou.png" width="50%" height="50%" style="text-align: center;"/></p>
	<form action="../servlet/shoppingservlet" method="post" style="text-align: center;">
		<input class="common_buton" type="submit" value="商品一覧へ">
	</form>
			<br>
		<br>
		 <footer>
      <br>
      <p style="text-align: center;">&copy; 2023 ShoopingSite</p>
      <br>
    </footer> 
</body>
</html>