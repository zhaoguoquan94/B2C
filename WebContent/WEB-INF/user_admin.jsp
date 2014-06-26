<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java"contentType = "text/html;
charset = gb2312" pageEncoding = "UTF-8"%>
<% String username = (String)session.getAttribute("username"); %>
<html>
<head>
<title>BC2商城</title>
<link href="../css/frame.css" rel="stylesheet" type="text/css"/>
<script language="javascript" src="../js/checkform.js">

</script>

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
			<li><a href="home.html">首页</a></li>
			<li><a href="category_list.html">商品管理</a></li>
			<li><a href="order_admin.html">订单管理</a></li>
			<li><a href="salesdata_admin.html">销售量统计</a></li>
			<li><a href="user_admin.html">会员管理</a></li>
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
				网站路径：<a href=""> 会员管理</a>
			</div>
		</div>
		<div id="double1">
			<div id="doublehead1"><strong>会员级别设置</strong></div>
			<div id="doublecontent1">
			<form action="" method="post" enctype="multipart/form-data" name="form1">
				<table id="xialabiao">
				<tr>
				<td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">会员级别&nbsp;&nbsp;</td>
              <td align="center" class="inputContent ">积分下限</td>
              <td width="18%" align="center" class="inputContent ">积分比例</td>
              <td width="33%" align="center" class="inputContent ">备注</td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">普通会员&nbsp;&nbsp;</td>
              <td align="center" class="inputContent">0</td>
              <td align="center" class="inputContent">100%</td>
              <td align="center" class="inputContent"><font color="#CC0000">只需注册即可成为普通会员</font></td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">银&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卡&nbsp;&nbsp;</td>
              <td align="center" class="inputContent">3000</td>
              <td align="center" class="inputContent">120%</td>
              <td align="left" class="inputContent">&nbsp;</td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卡&nbsp;&nbsp;</td>
              <td align="center" class="inputContent">8000</td>
              <td align="center" class="inputContent">130%</td>
              <td align="left" class="inputContent">&nbsp;</td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">白&nbsp;&nbsp;金&nbsp;&nbsp;卡&nbsp;&nbsp;</td>
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
              <td width="12%" align="center" class="inputHeader">会员级别：</td>
              <td width="25%" align="left" class="inputContent">
			  
			  <select name="userlevel">
                <option value="4">普通会员</option>
                <option value="1">银卡</option>
                <option value="2">金卡</option>
                <option value="3">白金卡</option>
              </select></td>
              <td colspan="2" align="center" class="inputContent"><font color="#CC0000">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</font></td>
              <td width="8%" align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader"><label></label></td>
              <td align="center" class="inputHeader">积分下限：</td>
              <td align="left" class="inputContent">
                <input type="text" class="inputtext" name="credit" onFocus="nextfield='credit'" maxlength="25">
              </td>
              <td colspan="2" align="left" class="inputContent"><font color="#CC0000">当会员积分大于相应等级的积分下限时，会员将自动升级</font></td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td align="center" class="inputHeader">积分比例：</td>
              <td align="left" class="inputContent"><input type="text" size="6" name="ratio" onFocus="nextfield='ratio'" maxlength="6">
                % </td>
              <td colspan="2" align="left" class="inputContent"><font color="#CC0000">会员购买物品时获得的积分占购买金额的比例</font></td>
              <td align="center" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="2" class="inputHeader">&nbsp;</td>
              <td colspan="3" align="left" class="inputContent">
                <input type="button" class="bt2" name="button22" value="提交" onClick="checkusersetform()">&nbsp;
                &nbsp;<input type="reset" class="bt2" name="button12" value="重填""></td>
              <td align="center" class="inputContent">&nbsp;</td>
				</tr>
            </table>
			</div>
			</div>
			
			
			
			<div id="double2">
			<div id="doublehead2"><strong>会员查询</strong></div>
			<div id="doublecontent2">
				<table width="100%">
				   <tr>
					  <td width="3%" class="inputHeader">&nbsp;</td>
              <td width="16%" class="inputHeader">会员号：</td>
              <td width="39%" class="inputContent"><input type="text" name="name" onFocus="nextfield='password'" value="" maxlength="15" size="15">              </td>
              <td width="42%" class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td class="inputHeader">会员级别：</td>
              <td class="inputContent"><select name="select">
                <option value="5">所有会员</option>
				<option value="4">普通会员</option>
                <option value="1">银卡</option>
                <option value="2">金卡</option>
                <option value="3">白金卡</option>
              </select></td>
              <td class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td width="16%" class="inputHeader">注册起始时间：</td>
              <td width="39%" class="inputContent"><select name="year">
                  <option>2007</option>
                  <option>2006</option>
                </select>
                &nbsp;&nbsp;年&nbsp;&nbsp;
                <select name="month">
                  <option>01</option>
                  <option>02</option>
                  <option>03</option>
                  <option>04</option>
                  <option>05</option>
                  <option>06</option>
                </select>
                &nbsp;&nbsp;
                月&nbsp;&nbsp;
              <select name="day">
                <option>01</option>
                <option>02</option>
                <option>03</option>
                <option>04</option>
                <option>05</option>
                <option>06</option>
              </select>
              &nbsp;&nbsp;日 </td>
              <td class="inputContent">&nbsp;</td>
            </tr>
            <tr>
              <td class="inputHeader">&nbsp;</td>
              <td class="inputHeader">注册结束时间：</td>
              <td class="inputContent"><select name="year">
                  <option>2007</option>
                  <option>2006</option>
                </select>
                &nbsp;&nbsp;年&nbsp;&nbsp;
                <select name="month">
                  <option>01</option>
                  <option>02</option>
                  <option>03</option>
                  <option>04</option>
                  <option>05</option>
                  <option>06</option>
                </select>
                &nbsp;&nbsp;
                月&nbsp;&nbsp;
              <select name="day">
                <option>01</option>
                <option>02</option>
                <option>03</option>
                <option>04</option>
                <option>05</option>
                <option>06</option>
              </select>
                &nbsp;&nbsp;日 </td>
              <td class="inputContent">&nbsp;</td>
            </tr>
          </table>
                <table width="100%" border="0" cellspacing="1" cellpadding="0">
                  <tr>
                    <td width="4%" class="inputContent">&nbsp;</td>
                    <td width="17%" class="inputHeader">&nbsp;</td>
                    <td width="39%" class="inputContent">
                      <strong> <input type="button" class="bt2" name="button222" value="查询" onClick="javascript:window.location.href='user_list.html'"></strong>&nbsp;&nbsp;
                     <input type="reset" class="bt2" name="button1" value="重填" onClick="clear()">
                      &nbsp; </td>
                    <td width="40%" class="inputContent">&nbsp;</td>
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