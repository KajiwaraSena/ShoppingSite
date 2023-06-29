<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jp.co.aforce.cart.*,java.util.*"%>  
<%
Cart cart=(Cart)session.getAttribute("cart");
String err=(String)request.getAttribute("err");
String msg=(String)request.getAttribute("msg");
%>    
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
	<div class="container" style="margin-top:20px;">
<p style="text-align: center;">商品をカートに入れてください</p>
<% if(err !=null){%>
<div class="alert alert-danger" role="alert">
<%=err %>
</div>
<%} %>
<% if(msg !=null){%>
<div class="alert alert-success" role="alert">
<%=msg %>
</div>
<%} %>
<br>
<form action="../servlet/main" method="post" style="text-align: center; height: 150px;">
  <div class="form-group">
    <label for="name">商品名:</label>
    <input type="text" id="name" name="name" class="form-control" style="width:200px;">
  </div>
<br>
<br>
  <div class="form-group">
    <label for="price">価格:</label>
    <input type="number" id="price" name="price" class="form-control" style="width:200px;">
  </div>
 <br> 
  <button type="submit" class="btn btn-primary">カートに追加</button>
</form>
<form action="../views/result.jsp" style="text-align: center;">
		<input class="common_buton" type="submit" value="購入">
	</form>
<%if(cart != null){%>
<div class="alert alert-secondary float-right" role="alert">
 	<%=String.format("合計:%,d円",cart.getTotal()) %>
</div>
<br>
<br>
<table class="table table-striped mt-4">
<tr><th>商品名</th><th>価格</th></tr>
	<%for(CartItem v:cart.getList()) {%>
	<tr><th><%=v.getName() %></th><td><%=String.format("%,d円",v.getPrice()) %></td></tr>
	<%} %>
</table>
<%} %>
</div>
<br>
<br>

	<form action="../servlet/shoppingservlet" method="post" style="text-align: center;">
		<input class="common_buton" type="submit" value="商品一覧へ">
	</form>
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