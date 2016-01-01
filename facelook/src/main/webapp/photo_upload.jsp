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
window.onload = function(){
	initPhotoUpload();
}
</script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div id="main" class="wrap">
    <jsp:include page="left.jsp"></jsp:include>
    <div class="righter">
		<div class="main">
			<h2 class="icon icon_album">我的相册</h2>
			<div id="upload_dialog" class="dialog">
				<h4>上传照片</h4>
				<form action="photo_upload.action" method="post" enctype="multipart/form-data">
					<div class="infos">
						<dl id="album_create" class="field clearfix">
							<dt>选择相册：</dt>
							<dd>
								<span class="select">
									<input id="albumId" type="button" value="<s:property value='albums[0].faAlbumName' default="第一个相册名称" />" />
									<ul class="hide">
										<s:iterator value="albums">
											<li><a href="#" title="<s:property value='faAlbumId' />"><s:property value="faAlbumName" /></a></li>
										</s:iterator>
									</ul>
								</span>
								<input id="hiddenId" type="hidden" name="albumId" value="<s:property value='albums[0].faAlbumId' default="4" />" />
							</dd>
							<dt>照片名称：</dt>
							<dd><input class="text" type="text" name="fp.fpName" /></dd>
							<dt>本地浏览：</dt>
							<dd><input class="text" type="file" name="photo" /></dd>
						</dl>
					</div>
					<div class="buttons">
						<p>你可以上传jpg,jpeg,gif,png或bmp文件。</p>
						<label class="ui-btn-cancel"><input type="button" name="button" value="取消" /></label>
						<label class="ui-btn-cancel"><input type="reset" name="button" value="重置" /></label>
						<label class="ui-btn-normal"><input type="submit" name="button" value="提交" /></label>
					</div>
				</form>
			</div>
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
