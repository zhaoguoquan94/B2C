<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java"contentType = "text/html;
charset = gb2312" pageEncoding = "GBK"%>
<% String username = (String)session.getAttribute("username"); %>
<html>
<head>
<title>BC2�̳�</title>
<link href="../css/frame.css" rel="stylesheet" type="text/css">
<script language="javascript">
function clear(){
document.form1.webUserEntity.user="";
document.form1.webUserEntity.order="";
}
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
				��վ·����<a href="">������ͳ��</a>
			</div>
		</div>
		<div id="sendnote">
			<div id="sendnotehead"><strong>��������ѯ</strong></div>
			<div id="sendnotecontent">
				<form action="" method="post" enctype="multipart/form-data" name="form1">
				<table id="tradequery">
				   <tr>
					<th>��ʼʱ��:&nbsp;</th>
            		<td>
						<select name="year">
							<option>2014</option>
							<option>2013</option>
              				<option>2012</option>
              				<option>2011</option>
              				<option>2010</option>
              				<option>2009</option>
              				<option>2008</option>
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
              				<option>07</option>
              				<option>08</option>
              				<option>09</option>
              				<option>10</option>
              				<option>11</option>
              				<option>12</option>
            			</select>
						&nbsp;��&nbsp;
						<select name="day">
              				<option>01</option>
              				<option>02</option>
              				<option>03</option>
              				<option>04</option>
			  				<option>05</option>
              				<option>06</option>
              				<option>07</option>
              				<option>08</option>
              				<option>09</option>
              				<option>10</option>
              				<option>11</option>
              				<option>12</option>
              				<option>13</option>
              				<option>14</option>
              				<option>15</option>
              				<option>16</option>
              				<option>17</option>
              				<option>18</option>
              				<option>19</option>
              				<option>20</option>
              				<option>21</option>
              				<option>22</option>
              				<option>23</option>
              				<option>24</option>
              				<option>25</option>
              				<option>26</option>
              				<option>27</option>
              				<option>28</option>
              				<option>29</option>
              				<option>30</option>
              				<option>31</option>
              				
              				
              				               
            			</select>
						&nbsp;��
					</td>
          		 </tr>
				 <tr>
				 <th>����ʱ��:&nbsp;</th>
            		<td>
						<select name="year">
							<option>2014</option>
							<option>2013</option>
              				<option>2012</option>
              				<option>2011</option>
              				<option>2010</option>
              				<option>2009</option>
              				<option>2008</option>
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
              				<option>07</option>
              				<option>08</option>
              				<option>09</option>
              				<option>10</option>
              				<option>11</option>
              				<option>12</option>
            			</select>
						&nbsp;��&nbsp;
						<select name="day">
              			<option>01</option>
              				<option>02</option>
              				<option>03</option>
              				<option>04</option>
			  				<option>05</option>
              				<option>06</option>
              				<option>07</option>
              				<option>08</option>
              				<option>09</option>
              				<option>10</option>
              				<option>11</option>
              				<option>12</option>
              				<option>13</option>
              				<option>14</option>
              				<option>15</option>
              				<option>16</option>
              				<option>17</option>
              				<option>18</option>
              				<option>19</option>
              				<option>20</option>
              				<option>21</option>
              				<option>22</option>
              				<option>23</option>
              				<option>24</option>
              				<option>25</option>
              				<option>26</option>
              				<option>27</option>
              				<option>28</option>
              				<option>29</option>
              				<option>30</option>
              				<option>31</option>              
            			</select>
						&nbsp;��
					</td>
          		 </tr>
				 <tr>
				 <th>���</th>
            		<td>
					  	<select name="category">
			    <option value="5">�������</option>
                <option value="1">ͼ������</option>
                <option value="2">ʱ������</option>
                <option value="3">��Ʒ���</option>
                <option value="4">�����Ʒ</option>
              </select> 
					</td>
          		 </tr>
				 <tr>
				 <th></th>
				 	<td><input type="button" class="bt2" name="button22" value="��ѯ" onClick="javascript:window.location.href='salesdata_list.html'"><td>
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
