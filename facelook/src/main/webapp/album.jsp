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
			<h2 class="icon icon_album">我的相册</h2>
			<div class="album_info">
				<a href="album_create.jsp"><img alt="创建相册" src="images/btn_create_album.png" /></a>
				<!-- My Code Begin -->
				<a href="album_toUploadPhoto.action?userId=${sessionScope.loginUser.fuUserId }" ><img alt="上传照片" src="images/btn_upload_photo.png"></a>
				<!-- My Code Begin -->
				共<s:property value="albums.size" default="0"/>个相册</div>
			<ul class="album clearfix">
				<s:iterator value="albums">
				<li>
					<dl>
						<dt onmouseover="toggleCloseButton(this,true)" onmouseout="toggleCloseButton(this,false)">
							<a href="album_getById.action?id=<s:property value="faAlbumId"/>">
								<%-- 
									<img src='<s:if test='facelookPhotos.size<1'>${pageContext.request.contextPath }/images/album_photo_1.gif</s:if>
									<s:if test='facelookPhotos.size>0'>showPhoto.action?id=<s:property  value="facelookPhotos.toArray()[0].fpPhotoId"/></s:if> 
									' /> 
								--%>
								<img src="${pageContext.request.contextPath }/images/album_photo_1.gif">
							</a>
							<em class="tiny_icon" onclick="deleteAlbum(1);"></em>
						</dt>
						<dd><a href="album_list.jsp" class="bold"><s:property value="faAlbumName"/> </a></dd>
						<dd class="gray"><s:property value="facelookPhotos.size" />张照片 | <a href="album_create.jsp">编辑</a></dd>
					</dl>
				</li>
				</s:iterator>
			</ul>
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
