<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="Utf-8"%>
<%@ page import="entity.User"%>
<%@ page import="util.Constants"%>


<div class="topMenu">
	<ul class="menu">
		<%
			User user = (User) session.getAttribute("user");
			int type = user.getType();
		%>
		<%
			if (type == Constants.int_sysAdmin) {
		%>
		<li id="User"><a href="jumpLink?link=User">用户管理</a></li>
		<%
			}
			if (type == Constants.int_sysAdmin || type == Constants.int_depotAdmin) {
		%>
		<li id="Book"><a href="jumpLink?link=Book">书籍管理</a></li>
		<%
			}
			if (type == Constants.int_sysAdmin || type == Constants.int_borrAdmin) {
		%>
		<li id="Order"><a href="jumpLink?link=Order">借阅管理</a></li>
		<%
			}
			if (type == Constants.int_sysAdmin || type == Constants.int_reader) {
		%>
		<li id="MyOrder"><a href="jumpLink?link=MyOrder">我的借阅</a></li>
		<%
			}
		%>
		<li id="Password"><a href="jumpLink?link=Password">修改密码</a></li>
	</ul>
	<div class="userinfo">
		欢迎,
		<%=((User) session.getAttribute("user")).getName()%>
		| <a href="logout.action">退出</a>
	</div>

	<script>
	function currentChannel(){
		var href = window.location.href;
		var keys = ["link","login","userManagement","bookManagement","orderManagement"];
		var args = ["User","Book","MyOrder","Order","Password"];//MyOrder和Order顺序不能变
		var target = "MyOrder";
		for(var i=0;i<keys.length;i++){
			if(href.indexOf(keys[i])>0){
				if(keys[i] == "link"){
					for(var j=0;j<args.length;j++){
						if(href.indexOf(args[j])>0){
							return args[j];
						}
					}
				}
				else{
					switch(keys[i]){
					case "userManagement":target="User";break;
					case "bookManagement":target="Book";break;
					case "orderManagement":target="Order";break;
					case "login":target="MyOrder";break;
					}
					return target;
				}
			}
		}
	}
	
	
	$("#"+currentChannel()).attr("class","current");
</script>


</div>

