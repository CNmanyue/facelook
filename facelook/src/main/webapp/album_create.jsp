<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎来到Facelook</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
window.onload = function(){
	initAlbumCreate();
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
			<div id="album_dialog" class="dialog">
				<h4>创建相册</h4>
				<form action="album_doCreateAlbum.action" method="post">
					<div class="infos">
						<dl id="album_create" class="field clearfix">
							<dt>相册名称：</dt>
							<dd><input class="text" type="text" name="album.faAlbumName" /></dd>
							<!-- <dt>创建地点：</dt>
							<dd><input class="text" type="text" name="album_name" /></dd> -->
							<dt>访问权限：</dt>
							<dd>
								<span class="select tiny_icon">
									<input id="privency" type="button" value="允许所有人访问" />
									<ul class="hide">
										<li><a href="#" title="1">允许所有人访问</a></li>
										<li><a href="#" title="2">只允许好友访问</a></li>
										<li><a href="#" title="3">不允许任何人访问</a></li>
									</ul>
								</span>
								<input id="hiddenId" type="hidden" name="album.faLimit" value="1" />
							</dd>
						</dl>
					</div>
					<div class="buttons">
						<label class="ui-btn-cancel"><input type="button" name="button" value="取消" /></label>
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
