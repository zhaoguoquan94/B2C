<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" contentType = "text/html;
charset = gb2312" pageEncoding = "UTF-8" %>
<% String username = (String)session.getAttribute("username"); %>
<html>
<head>
<title>BC2商城</title>
<link href="../css/frame.css" rel="stylesheet" type="text/css">
   </head>

<body>
<div id="container">
	<div id="logalleft">
		<div id="logalright">
		<a href="" target="_parent">[<%= username %>] 已登录|</a>
	 	<a href="home.html" target="_parent">退出</a>
		</div>
	</div>
	<div id="globallink">
		<ul>
			<li><a href="home.jsp">首页</a></li>
			<li><a href="category_list.jsp">商品管理</a></li>
			<li><a href="order_admin.jsp">订单管理</a></li>
			<li><a href="salesdata_admin.jsp">销售量统计</a></li>
			<li><a href="user_admin.jsp">会员管理</a></li>
			<li><a href="" class="nouseful">&nbsp;</a></li>
			<li><a href="" class="nouseful">&nbsp;</a></li>
			<li><a href="" class="nouseful">&nbsp;</a></li>
		</ul>
	</div>
	<div id="banner"></div>
	<div id="main">
		<div id="search2">
			<div id="searchleft">
				<img src="../image/ico_site.jpg" id="ico_site"/>
				网站路径：订单管理
			</div>	
		</div>
		<div id="sendnote">
			<div id="sendnotehead"><strong>订单查询</strong></div>
			<div id="sendnotecontent">
			<form action="" method="post" enctype="multipart/form-data" name="form1">
				<table id="tradequery">
					<tr>
					<th>订&nbsp;&nbsp;单&nbsp;&nbsp;号：	</th>
					<td><input type="text" class="inputtext" name="webUserEntity.order" onFocus="nextfield='webUserEntity.order'" maxlength="25"></td>
					</tr>
					<tr>
					<th>客&nbsp;&nbsp;户&nbsp;&nbsp;号：</th>
					<td><input type="text" class="inputtext" name="webUserEntity.user" onFocus="nextfield='webUserEntity.order'" maxlength="25"></td>
					</tr>
				   <tr>
					<th>起始时间：&nbsp;</th>
            		<td>
						<select name="year">
              				<option>2007</option>
              				<option>2006</option>
              			</select>
						&nbsp;年&nbsp;
						<select name="month">
              				<option>01</option>
             				<option>02</option>
              				<option>03</option>
              				<option>04</option>
			  				<option>05</option>
              				<option>06</option>
            			</select>
						&nbsp;月&nbsp;
						<select name="day">
              				<option>01</option>
              				<option>02</option>
              				<option>03</option>
              				<option>04</option>
			  				<option>05</option>
              				<option>06</option>              
            			</select>
						&nbsp;日
					</td>
          		 </tr>
				 <tr>
				 <th>结束时间：&nbsp;</th>
            		<td>
						<select name="year">
              				<option>2007</option>
              				<option>2006</option>
              			</select>
						&nbsp;年&nbsp;
						<select name="month">
              				<option>01</option>
             				<option>02</option>
              				<option>03</option>
              				<option>04</option>
			  				<option>05</option>
              				<option>06</option>
            			</select>
						&nbsp;月&nbsp;
						<select name="day">
              				<option>01</option>
              				<option>02</option>
              				<option>03</option>
              				<option>04</option>
			  				<option>05</option>
              				<option>06</option>              
            			</select>
						&nbsp;日
					</td>
          		 </tr>
				 <tr>
				 <th></th>
				 	<td><input type="button" name="button22" value="查询" onClick="javascript:window.location.href='order_list.html'">
					<input type="reset" class="bt2" name="button2" value="重填"><td>
				 </tr>
        </table>
		</form>  		
			</div>
		</div>
		
	<div id="footer">
		<span id="footerleft"> &nbsp;隐私权 | 版权 | 法律声明 | 电子邮件：admin@163.com </span>
		<span id="footerright"> B2C商城  Power by IBM &nbsp;</span>
	</div>
</div>

</body>
</html>