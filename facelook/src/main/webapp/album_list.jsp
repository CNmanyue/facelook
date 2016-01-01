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
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div id="main" class="wrap">
    <jsp:include page="left.jsp"></jsp:include>
    <div class="righter">
		<div class="main">
			<h2 class="icon icon_album">我的相册 - <s:property value="album.faAlbumName" /></h2>
			<div class="album_info">
				<a href="album_doListByUser.action?userId=${user.fuUserId}">返回相册列表</a>
				<label class="ui-btn-normal"><input type="button" name="button" value="上传照片" onclick="location.href = 'album_toUploadPhoto.action?userId=${sessionScope.loginUser.fuUserId }';" /></label>
				共<s:property value="album.facelookPhotos.size" />张照片
			</div>
			<!--
				 临时添加设置一个表单，将所有图片包含
				给每个图片增加一个复选框
			 -->
			<!--  <form action="delete.action" method="post" > -->
			<ul class="album-list clearfix">
				<s:iterator value="album.facelookPhotos" >
				<li>
					<dl>
						<%-- <dd><input type="checkbox" name="ids" value="${fpPhotoId }" /></dd> --%>
						<dt><a href="photo_view.action?id=<s:property value="fpPhotoId" />"><img src="showPhoto.action?id=<s:property value="fpPhotoId" />" /></a></dt>
						<dd><a href="photo_view.action?id=<s:property value="fpPhotoId" />"><s:property value="fpName" />[<s:property value="fpOrder" />]</a></dd>
					</dl>
				</li>
				</s:iterator>
			</ul>
			<!-- <input type="submit" value="删除,不用确认" />
			</form> -->
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
