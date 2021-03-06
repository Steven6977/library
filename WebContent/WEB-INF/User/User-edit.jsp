<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="util.Constants"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Gold Copy</title>
<link rel="stylesheet" href="css/screen.css" />
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/user/user-edit.js"></script>
<script src="js/jquery.validationEngine-en.js" type="text/javascript"
	charset="gb2312">
    
</script>
<script src="js/jquery.validationEngine.js" type="text/javascript"
	charset="gb2312">
    
</script>
</head>

<body>
	<div class="wrapper">
		<%@include file="/WEB-INF/menu.jsp" %>
		<div class="header">
			<div class="logo"></div>
		</div>
		<div class="breadcrumb">
			Home &gt; <a href="jumpLink?link=User">用户管理</a> &gt; 用户资料修改
		</div>
		<div id="application-new" class="module">
			<div class="moduleHeader">
				<div class="bkl"></div>
				<div class="bkr"></div>
				<h2>请修改用户</h2>
			</div>
			<div class="moduleLeft"></div>
			<div class="moduleRight"></div>
			<div class="moduleBottom"></div>
			<div class="content dataContent">
				<form id="editUserForm" method="post">
						
					<input type="hidden" value = "<s:property value="user.getId()"/>" name = "id" id ="id"/>
					<div class="row">
						<label> 用户账号 </label> <input type="text" name="useraccount"
							value="<s:property value="user.getUseraccount()"/>"
							id="useraccount" readonly="readonly" disabled = "disabled"/>
					</div>
					<div class="row">
						<label> 用户姓名 </label> <input type="text" name="name"
							value="<s:property value="user.getName()"/>" id="name" />
					</div>
					<div class="row">
						<label>用户类型</label> <select name="type" id = "type">
							<option value="<%= Constants.int_reader%>">图书馆读者</option>
							<option value="<%= Constants.int_sysAdmin%>">系统管理员</option>
							<option value="<%= Constants.int_depotAdmin%>">图书库房管理员</option>
							<option value="<%= Constants.int_borrAdmin%>">图书借阅经办人员</option>							
						</select>
					</div>

					<div class="row">
						<label> 邮箱地址 </label> <input type="text" name="email"
							value="<s:property value="user.getEmail()"/>" id="email" />
					</div>

					<div class="bottomBar">
						<a class="button" id="editUser"><span><span>保存修改</span>
						</span> </a> <a href="javascript:window.history.go(-1);" class="button"><span><span>返回</span>
						</span> </a>

					</div>
					
				</form>
			</div>
		</div>
		<div class="footer">
			Library Management Version 0.1 - Copyright © 2013 CCB. All Rights
			Reserved | <a href="#">Contact Us</a>
		</div>
	</div>
</body>
</html>

