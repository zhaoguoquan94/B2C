<%@ page language="java" import="java.util.*" contentType = "text/html;
charset = gb2312" pageEncoding = "GBK" %>
<% String username = (String)session.getAttribute("username"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>BC2�̳�</title>
<link href="../css/frame.css" rel="stylesheet" type="text/css"/>
<script language="javascript" src="../js/checkform.js">
</script>
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
			<li><a href="order_admin.html">��������</a></li>
			<li><a href="salesdata_admin.html">������ͳ��</a></li>
			<li><a href="user_admin.html">��Ա����</a></li>
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
				��վ·����<a href="home.jsp">��ҳ</a>&gt;&gt;<a href="c_l.jsp">��ƷĿ¼</a>&gt;&gt;<a href="">��ƷĿ¼�༭</a>
			</div>
		</div>
		<div id="sendnote">
			<div id="sendnotehead"><strong>�༭��ƷĿ¼</strong></div>
			<div id="sendnotecontent">
			<form action="" method="post" enctype="multipart/form-data" name="form1">
				<table id="itemsearch">
				   <tr>
					<th width="180">Ŀ¼���ƣ�</th>
            		<td width="360">
					 <input type="text" name="name" class="inputtext" onFocus="nextfield='password'" value="ͼ������" maxlength="25">					</td><td width="142"><span class="red">*������</span></td>
          		 </tr>
				 <tr>
				 <th>��Ŀ¼��</th>
            		<td>
					<select>
              			<option value="">��ѡ��</option>
						<option value="tsyx">ͼ������</option>
						<option value="sssh">ʱ������</option>
						<option value="smcp">�����Ʒ</option>
						<option value="xhsd">�ʻ��ٵ�</option>
            	    </select>
					</td>
          		 </tr>
				 <tr>
				 <th>Ŀ¼������</th>
				 <td>
				 <textarea name="textarea" class="textAreaStyle">��Ŀ¼�°���ͼ�顢������Ʒ������ͼ�麭���˼�������顢�����鼮���̿��顢��������ȣ�������ȫ��</textarea>
				 </td>
          		 </tr>
				 <tr>
				 <th>Ŀ¼ͼƬ��</th>
					<td><img src="../image/tsyx.gif" /><br>
         	 	    <input type="file" name="file">&nbsp;<input type="submit" name="Submit" value="�ϴ�"></td>
          		 </tr>
				 <tr>
				 <th></th>
			 	  <td>
				  <input type="button" name="button2" value="�ύ" onClick="Category_edit">
				  <input type="reset" name="button1" value="����" onClick="clear()">
				  <input type="button" name="button22" value="����" onClick="c_l.jsp'">				  
				  </td> </tr>
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
