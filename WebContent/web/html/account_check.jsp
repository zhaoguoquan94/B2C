<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page pageEncoding = "UTF-8"%>
<html>
<head>
<title>BC2商城</title>
<link href="../css/frame.css" rel="stylesheet" type="text/css"/>
<script language="javascript" src="../js/checkform.js"></script>
</head>

<body>
<%@ include file="header.jsp" %>
<div id="banner"></div>
	<div id="main">
		<div id="search2">
			<div id="searchleft">
				<img src="../image/ico_site.jpg"  id="ico_site"/>
				网站路径：<a href="home.jsp">首页</a>&gt;&gt;<a href="#">结帐</a>
			</div>
			<div id="searchright2">
			  <input type="text" name="product" id="textInput"/>
			  <input type="button" name="Submit" value="搜索" id="searchbutton" onClick="javascript:window.open('item_search_list.jsp','_parent','')">
			</div>
			<div id="searchright1">
			  <select name="category" id="searchrightcategory">
				<option value="5">所有类别</option>
                <option value="1">图书音像</option>
                <option value="2">时尚生活</option>
                <option value="3">饰品配件</option>
                <option value="4">数码产品</option>
              </select>
		  </div>
		</div>
		</div>
		<div id="double1">
			<div id="doublehead1"><strong><span class="red">已注册用户请登录</span></strong></div>
			<div id="doublecontent1">
				<form action="/B2C/LoginAction" method="get"  name="form1">
				<table id="itemsearch">
				   <tr>
					<th width="180" class="itemsearchth" >用户名：</th>
            		<td width="275" class="itemsearchtd1">
					<input type="text" class="inputtext" name="name" value="">
					</td>
					<td width="227" class="itemsearchtd2">					</td>
          		 </tr>
				 <tr>
				 <th class="itemsearchth">密&nbsp;&nbsp;&nbsp;码：</th>
            		<td class="itemsearchtd1">
					<input type="password" name="password" class="inputtext" value="">
					</td>
					<td class="itemsearchtd2"><a href="pwd_find.jsp" id="pwdfind"><span class="red">忘记密码？</span></a></td>
          		 </tr>
				
				 <tr>
				 <th></th>
				 	<td><input name="button3" class="bt2" type="submit" onClick="checkloginform_order()" value="登录">
						&nbsp;<input name="button4" class="bt2" type="reset" value="清空">
						&nbsp;
					</td>
				 </tr>
        </table>
			</div>
			</div>
			<div id="double2">
			<div id="doublehead2"><strong><span class="red">未注册用户请注册</span></strong></div>
			<div id="doublecontent2">
				<table id="itemsearch">
				   <tr>
					<th width="180" class="itemsearchth" >用&nbsp;户&nbsp;名：</th>
            		<td width="276" class="itemsearchtd1">
					<input type="text" class="inputtext" name="email" value="">
					</td>
					<td width="226" class="itemsearchtd2"><span class="red">请输入有效的邮箱</span>					</td>
          		 </tr>
				 <tr>
				 <th class="itemsearchth"><span class="inputHeader">昵&nbsp;&nbsp;&nbsp;&nbsp;称：</span></th>
            		<td class="itemsearchtd1">
				<input name="nickname" type="text" class="inputtext" value="">
					</td>
					<td class="itemsearchtd2">
					
					</td>
          		 </tr>
				 <tr>
				 <th class="itemsearchth"><span class="inputHeader">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span></th>
            		<td class="itemsearchtd1">
					<input name="password1" type="password" class="inputtext" value="">
					</td>
					<td class="itemsearchtd2">&nbsp;</td>
          		 </tr>
				 <tr>
				 <th class="itemsearchth"><span class="inputHeader">确认密码：</span></th>
            		<td class="itemsearchtd1">
	             <input type="password" name="passwordConfirm" class="inputtext" value="">
					</td>
					<td class="itemsearchtd2">&nbsp;</td>
          		 </tr>
				 <tr>
				 <th></th>
				 	<td><input name="button2" class="bt2" type="button" onClick="checkregform_order()" value="注册">
						&nbsp;<input name="button" class="bt2" type="reset" value="清空">
					</td>
				 </tr>
        </table>
		</form>		
			</div>

</div>
	<div id="footer">
		<span id="footerleft"> &nbsp;隐私权 | 版权 | 法律声明 | 电子邮件：admin@163.com </span>
		<span id="footerright"> B2C商城  Power by IBM &nbsp;</span>
	</div>
</body>
</html>
