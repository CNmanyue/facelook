<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="top">
	<div class="wrap">
    	<div class="logo"><img src="images/logo-tiny.png" /></div>
		<div class="navbar"><a href="home.jsp">个人中心</a><a href="album_doListByUser.action?userId=${sessionScope.loginUser.fuUserId}">相册</a></div>
    </div>
</div>