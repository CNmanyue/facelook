<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="lefter">
		<ul>
			<li><a class="icon icon_feed" href="home.jsp">好友动态</a></li>
			<li class="current"><a class="icon icon_album" href="album_doListByUser.action?userId=${sessionScope.loginUser.fuUserId}">我的相册</a></li>
		</ul>
</div>