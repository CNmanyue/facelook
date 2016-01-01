<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎来到Facelook</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
var timer, currentId = 1;
window.onload = initIndex;
</script>
</head>
<body>
<div id="indextop">
	<div class="wrap">
    	<div class="logo"><img src="images/logo.png" /></div>
    </div>
</div>
<div id="network">
    <div class="wrap">
        <div class="network">
            <h1>Facelook帮助你与周围的人联系和分享。</h1>
            <div class="transfer">
				<img id="transImage" src="images/photo_1.jpg" />
				<ul>
					<li class="current">1</li>
					<li>2</li>
					<li>3</li>
					<li>4</li>
				</ul>
			</div>
        </div>
        <div class="register">
        	<form action="user_doLogin.action" method="post">
                <h2>登录</h2>
                <h4>登录Facelook，进入属于你的空间</h4>
                <table cellpadding="10">
                    <tr>
                        <td class="i">账号:</td>
                        <td><input class="text" type="text" value="1" name="user.fuUserId" /></td>
                    </tr>
                    <tr>
                        <td class="i">密码:</td>
                        <td><input class="text" type="password" value="admin" name="user.fuPassword" /></td>
                    </tr>
                    <tr>
                    	<td></td>
                    	<td style="color:red;"><s:fielderror value="loginMsg" /> </td>
                    </tr>
					<tr>
                        <td class="i"></td>
                        <td><label class="ui-btn-large-green"><input type="submit" name="reg" value="登录" /></label></td>
                    </tr>
                </table>
            </form>
            <p>Facelook，随时随地，快乐与朋友分享！</p>
        </div>
    </div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>Facelook &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
</body>
</html>
