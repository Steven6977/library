<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书馆管理系统</title>

<link rel="stylesheet" href="css/screen.css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>

<script type="text/javascript" src="js/user/password.js"
	charset="gb2312"></script>
<script src="js/jquery.validationEngine-en.js" type="text/javascript"
	charset="gb2312">
    
</script>
<script src="js/jquery.validationEngine.js" type="text/javascript"
	charset="gb2312"></script>
<script type="text/javascript">
    //错误提示信息
    var msg = "" + '${request.tipMessage}';
    if (msg != "") {
	alert(msg);
    }
</script>
</head>

<body>
	<div class="wrapper">
	<%@include file="/WEB-INF/menu.jsp" %>
		<div class="header">
			<div class="logo"></div>
		</div>
		<div class="breadcrumb">
			Home &gt; <a href=""></a> &gt; 修改密码
		</div>
		<div id="application-new" class="module">
			<div class="moduleHeader">
				<div class="bkl"></div>
				<div class="bkr"></div>
				<h2>请修改密码</h2>
			</div>
			<div class="moduleLeft"></div>
			<div class="moduleRight"></div>
			<div class="moduleBottom"></div>
			<div class="content dataContent">
				<form id="modifyPasswordForm" method="post">
					<input type="hidden" name="id" id="id" />
					<div class="row">
						<label> 原密码 </label> <input type="password" name="oldpassword"
							id="oldpassword" />
					</div>
					<div class="row">
						<label> 新密码 </label> <input type="password" name="newpassword"
							id="newpassword" />
					</div>
					<div class="row">
						<label> 重复新密码 </label> <input type="password"
							name="repeatpassword" id="repeatpassword" />
					</div>

					<div class="bottomBar">
						<a class="button" id="savePassword"><span><span>保存</span>
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
