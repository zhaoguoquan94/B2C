<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java"contentType = "text/html;
charset = gb2312" pageEncoding = "GBK"%>
<% String username = (String)session.getAttribute("username"); %>
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
	 	<a href="home.html" target="_parent">�˳�</a>
		</div>
	</div>
	<div id="globallink">
		<ul>
			<li><a href="home.html">��ҳ</a></li>
			<li><a href="category_list.html">��Ʒ����</a></li>
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
				��վ·����<a href=""> ��Ա����</a>
			</div>
		</div>
		<div id="double1">
			<div id="doublehead1"><strong>��Ա��������</strong></div>
			<div id="doublecontent1">
			<form action="" method="post" enctype="multipart/form-data" name="form1">
				<table id="xialabiao">
				<tr>
				<td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">��Ա����&nbsp;&nbsp;</td>
              <td align="center" class="inputContent ">��������</td>
              <td width="18%" align="center" class="inputContent ">���ֱ���</td>
              <td width="33%" align="center" class="inputContent ">��ע</td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">��ͨ��Ա&nbsp;&nbsp;</td>
              <td align="center" class="inputContent">0</td>
              <td align="center" class="inputContent">100%</td>
              <td align="center" class="inputContent"><font color="#CC0000">ֻ��ע�ἴ�ɳ�Ϊ��ͨ��Ա</font></td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;</td>
              <td align="center" class="inputContent">3000</td>
              <td align="center" class="inputContent">120%</td>
              <td align="left" class="inputContent">&nbsp;</td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;</td>
              <td align="center" class="inputContent">8000</td>
              <td align="center" class="inputContent">130%</td>
              <td align="left" class="inputContent">&nbsp;</td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">��&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;</td>
              <td align="center" class="inputContent">15000</td>
              <td align="center" class="inputContent">140%</td>
              <td align="left" class="inputContent">&nbsp;</td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="6" class="titlegrey">&nbsp;</td>
            </tr>
            <tr>
              <td width="4%" class="inputHeader">&nbsp;</td>
              <td width="12%" align="center" class="inputHeader">��Ա����</td>
              <td width="25%" align="left" class="inputContent">
			  
			  <select name="userlevel">
                <option value="4">��ͨ��Ա</option>
                <option value="1">����</option>
                <option value="2">��</option>
                <option value="3">�׽�</option>
              </select></td>
              <td colspan="2" align="center" class="inputContent"><font color="#CC0000">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</font></td>
              <td width="8%" align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader"><label></label></td>
              <td align="center" class="inputHeader">�������ޣ�</td>
              <td align="left" class="inputContent">
                <input type="text" class="inputtext" name="credit" onFocus="nextfield='credit'" maxlength="25">
              </td>
              <td colspan="2" align="left" class="inputContent"><font color="#CC0000">����Ա���ִ�����Ӧ�ȼ��Ļ�������ʱ����Ա���Զ�����</font></td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">���ֱ�����</td>
              <td align="left" class="inputContent"><input type="text" size="6" name="ratio" onFocus="nextfield='ratio'" maxlength="6">
                % </td>
              <td colspan="2" align="left" class="inputContent"><font color="#CC0000">��Ա������Ʒʱ��õĻ���ռ������ı���</font></td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="2" class="inputHeader">&nbsp;</td>
              <td colspan="3" align="left" class="inputContent">
                <input type="button" class="bt2" name="button22" value="�ύ" onClick="checkusersetform()">&nbsp;
                &nbsp;<input type="reset" class="bt2" name="button12" value="����""></td>
              <td align="center" class="inputContent">&nbsp;</td>
				</tr>
            </table>
			</div>
			</div>
			
			
			
			<div id="double2">
			<div id="doublehead2"><strong>��Ա��ѯ</strong></div>
			<div id="doublecontent2">
				<table width="100%">
				   <tr>
					  <td width="3%" class="inputHeader">&nbsp;</td>
              <td width="16%" class="inputHeader">��Ա�ţ�</td>
              <td width="39%" class="inputContent"><input type="text" name="name" onFocus="nextfield='password'" value="" maxlength="15" size="15">              </td>
              <td width="42%" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td class="inputHeader">��Ա����</td>
              <td class="inputContent"><select name="select">
                <option value="5">���л�Ա</option>
				<option value="4">��ͨ��Ա</option>
                <option value="1">����</option>
                <option value="2">��</option>
                <option value="3">�׽�</option>
              </select></td>
              <td class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td width="16%" class="inputHeader">ע����ʼʱ�䣺</td>
              <td width="39%" class="inputContent"><select name="year">
                  <option>2007</option>
                  <option>2006</option>
                </select>
                &nbsp;&nbsp;��&nbsp;&nbsp;
                <select name="month">
                  <option>01</option>
                  <option>02</option>
                  <option>03</option>
                  <option>04</option>
                  <option>05</option>
                  <option>06</option>
                </select>
                &nbsp;&nbsp;
                ��&nbsp;&nbsp;
              <select name="day">
                <option>01</option>
                <option>02</option>
                <option>03</option>
                <option>04</option>
                <option>05</option>
                <option>06</option>
              </select>
              &nbsp;&nbsp;�� </td>
              <td class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td class="inputHeader">ע�����ʱ�䣺</td>
              <td class="inputContent"><select name="year">
                  <option>2007</option>
                  <option>2006</option>
                </select>
                &nbsp;&nbsp;��&nbsp;&nbsp;
                <select name="month">
                  <option>01</option>
                  <option>02</option>
                  <option>03</option>
                  <option>04</option>
                  <option>05</option>
                  <option>06</option>
                </select>
                &nbsp;&nbsp;
                ��&nbsp;&nbsp;
              <select name="day">
                <option>01</option>
                <option>02</option>
                <option>03</option>
                <option>04</option>
                <option>05</option>
                <option>06</option>
              </select>
                &nbsp;&nbsp;�� </td>
              <td class="inputContent">&nbsp;</td>
            </tr>
          </table>
                <table width="100%" border="0" cellspacing="1" cellpadding="0">
                  <tr>
                    <td width="4%" class="inputContent">&nbsp;</td>
                    <td width="17%" class="inputHeader">&nbsp;</td>
                    <td width="39%" class="inputContent">
                      <strong> <input type="button" class="bt2" name="button222" value="��ѯ" onClick="javascript:window.location.href='user_list.html'"></strong>&nbsp;&nbsp;
                     <input type="reset" class="bt2" name="button1" value="����" onClick="clear()">
                      &nbsp; </td>
                    <td width="40%" class="inputContent">&nbsp;</td>
				 </tr>
        </table>
		</form>		
			</div>

</div>
	<div id="footer">
		<span id="footerleft"> &nbsp;��˽Ȩ | ��Ȩ | �������� | �����ʼ���admin@163.com </span>
		<span id="footerright"> B2C�̳�  Power by IBM &nbsp;</span>
	</div>
</body>
</html>