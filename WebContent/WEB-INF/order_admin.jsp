<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" contentType = "text/html;
charset = gb2312" pageEncoding = "GBK" %>
<% String username = (String)session.getAttribute("username"); %>
<html>
<head>
<title>BC2�̳�</title>
<link href="../css/frame.css" rel="stylesheet" type="text/css">
   </head>

<body>
<div id="container">
	<div id="logalleft">
		<div id="logalright">
		<a href="" target="_parent">[<%= username %>] �ѵ�¼|</a>
	 	<a href="home.html" target="_parent">�˳�</a>
		</div>
	</div>
	<div id="globallink">
		<ul>
			<li><a href="home.jsp">��ҳ</a></li>
			<li><a href="category_list.jsp">��Ʒ����</a></li>
			<li><a href="order_admin.jsp">��������</a></li>
			<li><a href="salesdata_admin.jsp">������ͳ��</a></li>
			<li><a href="user_admin.jsp">��Ա����</a></li>
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
				��վ·������������
			</div>	
		</div>
		<div id="sendnote">
			<div id="sendnotehead"><strong>������ѯ</strong></div>
			<div id="sendnotecontent">
			<form action="" method="post" enctype="multipart/form-data" name="form1">
				<table id="tradequery">
					<tr>
					<th>��&nbsp;&nbsp;��&nbsp;&nbsp;�ţ�	</th>
					<td><input type="text" class="inputtext" name="webUserEntity.order" onFocus="nextfield='webUserEntity.order'" maxlength="25"></td>
					</tr>
					<tr>
					<th>��&nbsp;&nbsp;��&nbsp;&nbsp;�ţ�</th>
					<td><input type="text" class="inputtext" name="webUserEntity.user" onFocus="nextfield='webUserEntity.order'" maxlength="25"></td>
					</tr>
				   <tr>
					<th>��ʼʱ�䣺&nbsp;</th>
            		<td>
						<select name="year">
              				<option>2007</option>
              				<option>2006</option>
              			</select>
						&nbsp;��&nbsp;
						<select name="month">
              				<option>01</option>
             				<option>02</option>
              				<option>03</option>
              				<option>04</option>
			  				<option>05</option>
              				<option>06</option>
            			</select>
						&nbsp;��&nbsp;
						<select name="day">
              				<option>01</option>
              				<option>02</option>
              				<option>03</option>
              				<option>04</option>
			  				<option>05</option>
              				<option>06</option>              
            			</select>
						&nbsp;��
					</td>
          		 </tr>
				 <tr>
				 <th>����ʱ�䣺&nbsp;</th>
            		<td>
						<select name="year">
              				<option>2007</option>
              				<option>2006</option>
              			</select>
						&nbsp;��&nbsp;
						<select name="month">
              				<option>01</option>
             				<option>02</option>
              				<option>03</option>
              				<option>04</option>
			  				<option>05</option>
              				<option>06</option>
            			</select>
						&nbsp;��&nbsp;
						<select name="day">
              				<option>01</option>
              				<option>02</option>
              				<option>03</option>
              				<option>04</option>
			  				<option>05</option>
              				<option>06</option>              
            			</select>
						&nbsp;��
					</td>
          		 </tr>
				 <tr>
				 <th></th>
				 	<td><input type="button" name="button22" value="��ѯ" onClick="javascript:window.location.href='order_list.html'">
					<input type="reset" class="bt2" name="button2" value="����"><td>
				 </tr>
        </table>
		</form>  		
			</div>
		</div>
		
	<div id="footer">
		<span id="footerleft"> &nbsp;��˽Ȩ | ��Ȩ | �������� | �����ʼ���admin@163.com </span>
		<span id="footerright"> B2C�̳�  Power by IBM &nbsp;</span>
	</div>
</div>

</body>
</html>