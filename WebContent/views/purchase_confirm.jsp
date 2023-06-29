<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="item_bean" scope="request" class="jp.co.aforce.beans.ItemBean" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url(../img/siro.jpg); background-size: 100% 100%;">
	<header>
		<h1 style="text-align:center">Styley</h1>
	</header>
	<form action="../views/menu.jsp" method="post">
	<li style="text-align: right; display: flex; justify-content: flex-start; align-items: center; list-style: none;"><a href="../views/menu.jsp" style="font-size: 1.8em;">ログアウト</a></li>
	</form>
	<ul style="text-align: right; display: flex; justify-content: flex-end; align-items: center; list-style: none;"> 
   <li style="border-right: #ddd 1px solid; padding: 0 10px;"><a href="/ShoppingSite/servlet/shoppingservlet" style="font-size: 1.5em;">TOP</a></li>
   <li style="padding: 0 10px;"><a href="/ShoppingSite/views/cart.jsp"><img src="../img/cart.png" style="width: 50px;"></a>
	</ul>
	<hr style="height:3; background-color:#000ff" />
	<br>
	<br>
		<h1 style="text-align: center;">購入確認</h1>
		<p style="text-align: center;">次の商品を購入しますか</p>
		
		<form action="../servlet/ResultServlet" method="post" style="padding: 32px 2.4%; text-align: center;">
			<table  style="width: 100%;" class="shopping_table">
				<tbody>
					<tr>
						<th style="width: 30%; ">商品名</th>
						<th style="width: 10%; ">価格</th>
						<th style="width: 10%; ">在庫数</th>
						<th style="width: 10%; ">購入数</th>
					</tr>
					<tr>
						<td style="text-align: center;"><jsp:getProperty property="name" name="item_bean"/></td>
						<td style="text-align: center;" class="int"><jsp:getProperty property="price" name="item_bean"/></td>
						<td style="text-align: center;" class="int"><jsp:getProperty property="quantity" name="item_bean"/></td>
						<td style="text-align: center;" class="int"><%=request.getAttribute("purchased_num") %></td>
						<td class="button">
							<input class="common_button" type="submit" value="購入する">
							
							<input type="hidden" name="product_id" value="<jsp:getProperty property="product_Id" name="item_bean"/>">	
							<input type="hidden" name="quantity" value="<%= request.getAttribute("purchased_num") %>">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<form action="../servlet/shoppingservlet" method="post" style="text-align: center;">
			<input class="common_button" type="submit" value="商品一覧へ">
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