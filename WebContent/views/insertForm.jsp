<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url(../img/siro.jpg); background-size: 100% 100%;">
<header>
	<div style="text-align:center">
	<h1 style="text-align:center">Styley</h1>
	<li style="text-align: right; display: flex; justify-content: flex-start; align-items: center; list-style: none;"><a href="../views/menu.jsp" style="font-size: 1.8em;">ログアウト</a></li>
</form>
<ul style="text-align: right; display: flex; justify-content: flex-end; align-items: center; list-style: none;"> 
   <li style="border-right: #ddd 1px solid; padding: 0 10px;"><a href="/ShoppingSite/servlet/shoppingservlet" style="font-size: 1.5em;">TOP</a></li>
   <li style="border-right: #ddd 1px solid; padding: 0 10px;"><a href="/ShoppingSite/views/insertForm.jsp" style="font-size: 1.5em;">追加</a></li>
</ul>
<hr style="height:3; background-color:#000ff" />
	<br>
	<br>
</header>	
	<h1 style="text-align: center;">商品登録</h1>
	<p style="text-align: center;">登録する情報を入力してください。</p>
	<form action="<%= request.getContextPath() %>/servlet/insertservlet">
	<table style="margin:0 auto">
		<tr>
			<td style="width:60">ID</td>
			<td><input type=text size="30" name="product_id"></input></td>
		</tr>	
		<tr>
			<td style="width:60">商品名</td>
			<td><input type=text size="30" name="name"></input></td>
		</tr>
		<tr>
			<td style="width:60">価格</td>
			<td><input type=text size="30" name="price"></input></td>
		</tr>
		<tr>
			<td style="width:60">在庫数</td>
			<td><input type=text size="30" name="quantity"></input></td>
		</tr>
		<tr>
			<td colsapan=2 style="text-align:center">
				<input type="submit" value="登録">
			</td>
		</tr>
	</table>
	</form>
	</div>	
	<br>
            <br>
            <br>
 <footer>
      <br>
      <p style="text-align: center;">&copy; 2023 ShoopingSite</p>
      <br>
    </footer> 				
</body>
</html>