<%@ page language="java" import="java.util.*" contentType = "text/html;
charset = gb2312" pageEncoding = "GBK" %>
<% String username = (String)session.getAttribute("username"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	 	<a href="home.jsp" target="_parent">�˳�</a>
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
				<img src="../image/ico_site.jpg"  id="ico_site"/>
				��վ·����<a href="home.jsp">��ҳ</a>&gt;&gt;<a href="">�鿴��Ʒ����</a>
			</div>
		
		</div>
		<div id="sendnote">
			<div id="sendnotehead"><strong>����2������</strong></div>
			<div id="sendnotecontent">
				<table id="creditquery">
					<tr>
					<td class="commentr1color"> ��Ա��</td>
					<td class="commentr1color"> zhangtong123@163.com</td>
					<td class="commentr1color"> ����ʱ�䣺</td>
					<td class="commentr1color"> 2007-10-05 22:12:30</td>
					<td class="commentr1color"> ��֣�</td>
					<td class="commentr1color"> <img src="../image/4star.JPG" alt="ϲ��"></td>
					</tr>
					<tr>
					<td class="commentr2color">���ۣ�</td>
	     			<td colspan="5" class="commentr2color"><span class="red">�ܲ����һ���飬ͨ���׶����Ǵ�ѧ����̲��еľ���֮����</span> </td>
	 			   </tr>
				   	<tr>
					<td class="commentr1color"> ��Ա��</td>
					<td class="commentr1color"> wangqd456@126.com</td>
					<td class="commentr1color"> ����ʱ�䣺</td>
					<td class="commentr1color"> 2007-10-20 17:23:16</td>
					<td class="commentr1color"> ��֣�</td>
					<td class="commentr1color"> <img src="../image/4star.JPG" alt="ϲ��"></td>
					</tr>
					<tr>
					<td class="commentr2color">���ۣ�</td>
	     			<td colspan="5" class="commentr2color"><span class="red">�����ˣ�ȷʵ����</span></td>
	 			   </tr>
            </table>	
			</div>
		</div>
		
	<div id="footer">
		<span id="footerleft"> &nbsp;��˽Ȩ | ��Ȩ | �������� | �����ʼ���admin@163.com </span>
		<span id="footerright"> B2C�̳�  Power by IBM &nbsp;</span>
	</div>
</div>

</body>
</html>
