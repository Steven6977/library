<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书馆管理系统</title>
<link rel="stylesheet" href="css/screen.css" />
<style type="text/css" title="currentStyle">
@import "css/demo_page.css";

@import "css/demo_table.css";
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>

<script type="text/javascript" language="javascript"
	src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/order/order.js" charset="gb2312"></script>
<script type="text/javascript">
    //错误提示信息
    var msg = "" + '${request.orderNewMessage}';

    if (msg != "") {
	alert(msg);
    }
    
    var msg1 = "" + '${request.orderretMessage}';

    if (msg1 != "") {
	alert(msg1);
    }
</script>
</head>

<body>
	<div class="wrapper">
		<%@include file="/WEB-INF/menu.jsp" %>
		<div class="header">
			<div class="logo"></div>
		</div>
		<div class="breadcrumb">Home &gt; 借阅管理</div>
		<form id="delOrderForm" method="post"></form>
		<div id="dynamic">
			<div id="application" class="module">
				<div class="moduleHeader">
					<div class="bkl"></div>
					<div class="bkr"></div>
					<h2>借阅列表</h2>
					<a href="orderManagement.action?operation=deleteall" class="button"><span><span>删除所有已归还记录</span>
					</span> </a> <a href="jumpLink?link=Order-new" class="button"><span><span>添加借阅</span>
					</span> </a>
				</div>
				<div class="moduleLeft"></div>
				<div class="moduleRight"></div>
				<div class="moduleBottom"></div>
				<div class="content">
					<table cellpadding="0" cellspacing="0" border="0" class="display"
						id="example">
						<thead>
							<tr>
								<th>用户名称</th>
								<th>书籍名称</th>
								<th>借阅日期</th>
								<th>归还日期</th>
								<th>相关操作</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>

				</div>
			</div>
		</div>
		<div class="footer">
			Library Management Version 0.1 - Copyright © 2013 CCB. All Rights
			Reserved | <a href="#">Contact Us</a>
		</div>
	</div>
</body>
</html>
