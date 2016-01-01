<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div class="dialog">
				<h4>创建相册</h4>
					<div class="infos">
						恭喜：创建成功！
					</div>
					<div class="buttons">
						<label class="ui-btn-cancel"><input type="button" name="button" value="返回列表" onclick="location.href='album_doListByUser.action?userId=${sessionScope.loginUser.fuUserId}'" /></label>
						<label class="ui-btn-normal"><input type="button" name="button" value="上传照片" onclick="location.href = 'album_toUploadPhoto.action?userId=${sessionScope.loginUser.fuUserId }';" /></label>
					</div>
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
