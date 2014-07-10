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

<script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/user/user.js" charset="gb2312"></script>
<script type="text/javascript">

    //错误提示信息
    var msg = "" + '${request.userEditMessage}';
    var msg1 = "" + '${request.userNewMessage}';
    if (msg != "") {
	alert(msg);
    }
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
		<div class="breadcrumb">Home &gt; 用户管理</div>
		<form id = "delUserForm" method="post"></form>
		<div id="dynamic">
		<div id="application" class="module">
			<div class="moduleHeader">
				<div class="bkl"></div>
				<div class="bkr"></div>
				<h2>用户列表</h2>
				<a href="jumpLink?link=User-new" class="button"><span><span>添加用户</span> </span> </a>
			</div>
			<div class="moduleLeft"></div>
			<div class="moduleRight"></div>
			<div class="moduleBottom"></div>
			<div class="content">
					<table cellpadding="0" cellspacing="0" border="0" class="display"
						id="example">
						<thead>
							<tr>
								<th>用户姓名</th>
								<th>用户账户</th>
								<th>用户邮箱</th>
								<th>用户类型</th>
								<th>用户状态</th>
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
