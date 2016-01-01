<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎来到Facelook</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div id="main" class="wrap">
    <jsp:include page="left.jsp"></jsp:include>
    <div class="righter">
		<div class="main">
			<h2 class="icon icon_feed">好友动态</h2>
			<dl class="feed clearfix">
			
			<s:iterator value="activitys" end="4">
				<!-- 
					好友动态type属性==2代表留了言
				 -->
				<s:if test="faType==2">
					<dt><img src="images/face.gif" /></dt>
					<dd><a href="album_doListByUser.action?userId=<s:property value="facelookUser.fuUserId"/>" class="bold"><s:property value="facelookUser.fuUserName"/></a> 在照片 <a href="#"><s:property value="facelookPhoto.fpName" /></a>发表了评论</dd>
					<dd class="photo">
						<ul class="clearfix">
							<li><a href="photo_view.action?id=<s:property value="facelookPhoto.fpPhotoId" />"><img src="showPhoto.action?id=<s:property value="facelookPhoto.fpPhotoId" />" /></a></li>
						</ul>
					</dd>
					<dd class="comment">
						<div class="tiny_icon lasttime"><p class="icon icon_comment"><span class="time"><fmt:formatDate value="${facelookPhoto.fpCreateTime}" pattern="yyyy-MM-dd hh:mm" /></span></p></div>
						<ul>
							<s:iterator value="facelookPhoto.facelookComments" status="status" end="2">
								<li><span class="time"><s:property value="fcCreateTime"/> </span><a href="#"><s:property value="facelookUser.fuUserName" /> </a>：<s:property value="fcComment"/> </li>
							</s:iterator>
						</ul>
					</dd>
					<dd class="line"></dd>
				</s:if>
				<!-- 
					好友动态type属性==1代表上传了照片
				 -->
				<s:if test="faType==1">
					<dt><img src="images/face.gif" /></dt>
					<dd><a href="album_doListByUser.action?userId=<s:property value="facelookUser.fuUserId"/>" class="bold"><s:property value="facelookUser.fuUserName"/></a> 上传了新照片 <a href="#"><s:property value="facelookPhoto.fpName" /> </a></dd>
					<dd class="photo">
						<ul class="clearfix">
							<li><a href="photo_view.action?id=<s:property value="facelookPhoto.fpPhotoId" />"><img src="showPhoto.action?id=<s:property value="facelookPhoto.fpPhotoId" />" /></a></li>
						</ul>
					</dd>
					<dd class="comment">
						<div class="tiny_icon lasttime"><p class="icon icon_comment"><span class="time"><fmt:formatDate value="${facelookPhoto.fpCreateTime}" pattern="yyyy-MM-dd hh:mm" /></span></p></div>
						<ul>
							<s:iterator value="facelookPhoto.facelookComments" status="status" end="2">
								<li><span class="time"><s:property value="fcCreateTime"/> </span><a href="#"><s:property value="facelookUser.fuUserName" /> </a>：<s:property value="fcComment"/> </li>
							</s:iterator>
						</ul>
					</dd>
					<dd class="line"></dd>
				</s:if>
			</s:iterator>
			</dl>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>Facelook &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
<s:debug></s:debug>
</body>
</html>
