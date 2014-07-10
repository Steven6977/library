<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
                      + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书馆管理系统</title>
<link rel="stylesheet" href="css/screen.css" />
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script src="js/jquery.validationEngine-en.js" type="text/javascript"
	charset="gb2312">
	
</script>
<script src="js/jquery.validationEngine.js" type="text/javascript"
	charset="gb2312">
	
</script>
<script type="text/javascript">
	function reset() {
		$("#useraccount").attr("value", "");
		$("#password").attr("value", "");
	}
</script>
</head>

<body>
	<div class="wrapper" id="loginWrapper">
		<div class="header">
			<div class="logo"></div>
		</div>
		<div id="login" class="module centerModule">
			<div class="moduleHeader">
				<div class="bkl"></div>
				<div class="bkr"></div>
				<h2>用户登录</h2>
			</div>
			<div class="moduleLeft"></div>
			<div class="moduleRight"></div>
			<div class="moduleBottom"></div>
			<div class="content">
				<form id="loginForm" method="post">
					<div class="row">
						<label> 用户账户 </label> <input type="text" id="useraccount" value=""
							name="useraccount" />
					</div>
					<div class="row">
						<label> 密 码 </label> <input type="password" id="password" value=""
							name="password" />
					</div>
					<div class="row">
						<center>
							<font color="#FF0000">${requestScope.loginError}</font>
						</center>
					</div>
					<div class="bottomBar">
						<div class="buttonBarInside">
							<a href="javascript:;" id="tsb_submit" class="button formButton">
								<span><span>登录</span> </span>
							</a> <a href="javascript:;" onclick="reset()" id="tsb_cancel"
								class="button formButton"> <span><span>重置</span> </span>
							</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

