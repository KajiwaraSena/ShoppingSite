<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.beans.ItemBean" %>    
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>    
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
   <li style="border-right: #ddd 1px solid; padding: 0 10px;"><a href="/ShoppingSite/views/insertForm.jsp" style="font-size: 1.5em;">追加</a></li>
</ul>
<hr style="height:3; background-color:#000ff" />
<br>
<br>
	<% ArrayList<ItemBean> itemList = (ArrayList<ItemBean>) request.getAttribute("itemList"); %>

	<form action="../servlet/buyitemservlet" style="padding: 32px 25%;">
                <table style="width: 100%;" class="shopping_table">
                    <tbody>
                        <tr>
                        
        					<th style="width: 20%; ">商品画像</th>
                            <th style="width: 10%; ">ID</th>
                            <th style="width: 30%; ">商品名</th>
                            <th style="width: 10%; ">価格</th>
                            <th style="width: 10%; ">在庫数</th>
                        </tr>

                        <%-- Beanの要素数分（商品の種類分）テーブルを作成 --%>
                        <% for (ItemBean bean : itemList) {%>
                        <tr>
                        	<td style="text-align: center;"><img style="width:100px; height:100px;" src="/ShoppingSite/img/<%= bean.getProduct_Id() %>.jpg"></td>
                            <%-- 商品ID --%>
                            <td style="text-align: center;"><%= bean.getProduct_Id()%></td>
                            <%-- 商品名 --%>
                            <td style="text-align: center;"><%= bean.getName()%></td>
                            <%-- 価格 --%>
                            <td class="int" style="text-align: center;"><%= bean.getPrice()%></td>
                            <%-- 数量（在庫） --%>
                            <td class="int" style="text-align: center;"><%= bean.getQuantity()%></td>
                            <% } %>
                    </tbody>
                </table>
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