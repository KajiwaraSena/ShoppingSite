<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer count = (Integer)request.getAttribute("count");
String error = (String)request.getAttribute("error");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center; background-image: url(../img/siro.jpg); background-size: 100% 100%; ">
	<header>
		<h1 style="text-align:center">Styley</h1>
	</header>
	<li style="text-align: right; display: flex; justify-content: flex-start; align-items: center; list-style: none;"><a href="../views/menu.jsp" style="font-size: 1.8em;">ログアウト</a></li>
</form>
<ul style="text-align: right; display: flex; justify-content: flex-end; align-items: center; list-style: none;"> 
   <li style="border-right: #ddd 1px solid; padding: 0 10px;"><a href="/ShoppingSite/servlet/shoppingservlet" style="font-size: 1.5em;">TOP</a></li>
   <li style="border-right: #ddd 1px solid; padding: 0 10px;"><a href="/ShoppingSite/views/insertForm.jsp" style="font-size: 1.5em;">追加</a></li>
</ul>
<hr style="height:3; background-color:#000ff" />
<br>
<br>
		<h1>登録完了</h1>
		<%= error %>
		<% if(count != null){ %>
			<%= count %>件のデータを登録しました
		<% } %>
		</br>
		<p><a href="/ShoppingSite/servlet/shoppingservlet">TOP</a></p>
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