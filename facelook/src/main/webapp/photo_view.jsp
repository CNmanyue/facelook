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
<link type="text/css" rel="stylesheet" href="css/quanren.css" />
<script type="text/javascript" src="scripts/jquery-1.7.2.js" ></script>
<script type="text/javascript" src="scripts/ui.core.min.js"></script>
<script type="text/javascript" src="scripts/ui.dragdrop.min.js"></script>
<script type="text/javascript" src="scripts/ui.resize.min.js"></script>
<script type="text/javascript" src="scripts/ui.imagemarker.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
	onload = function (){
		if(${!empty requestScope.existMsg}){
			alert("${requestScope.existMsg}");	
		}
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
			<div id="imgLeft">
				<div class="menubar">
					<ul class="menu clearfix">
						<li class="comment"><a href="#commentBox">评论</a></li>
						<li class="quan"><a id="quanren" href="#">圈人</a></li>
					</ul>
				</div>
				<div id="photo-box">
					<div class="imgContainer" id="imgContainer">
						<img src="showPhoto.action?type=big&id=<s:property value="fp.fpPhotoId" />" id="bigImage" />
					</div>
				</div>
				<div class="pager">
					<ul class="clearfix">
						<li class="gonext"><a href="photo_viewNext.action?id=<s:property value="fp.fpPhotoId" />&albumId=<s:property value="fp.facelookAlbum.faAlbumId" />&orderNo=<s:property value="fp.fpOrder" />">下一个</a></li>
						<li class="goahead"><a href="photo_viewPrevious.action?id=<s:property value="fp.fpPhotoId" />&albumId=<s:property value="fp.facelookAlbum.faAlbumId" />&orderNo=<s:property value="fp.fpOrder" />">上一个</a></li>
					</ul>
					上传时间：<fmt:formatDate value="${fp.fpCreateTime }" pattern="yyyy-MM-dd hh:mm:ss" />
				</div>
				<div class="clear"></div>
				<div class="comment">
					<ul id="fcList">
						<s:iterator value="map.get(null)" id="comm">
						<li id="fc_<s:property value="fcId" />">
							<div class="menu">
								<span class="time"><s:property value="fcCreateTime" /></span>
								<a href="#commentBox" onclick="replyIt('<s:property value="facelookUser.fuUserName" />',<s:property value="fcId" />)">回复</a>
							</div>
							<a href="#"><s:property value="facelookUser.fuUserName" /></a>：<s:property value="fcComment"/>
						</li>
							<s:iterator value="map.get(#comm)">
							<li id="fc_<s:property value="fcId" />">
								<div class="menu">
									<span class="time"><s:property value="fcCreateTime" /></span>
									<a href="#commentBox" onclick="replyIt('<s:property value="facelookUser.fuUserName" />',<s:property value="fcId" />)">回复</a>
								</div>
								<a href="#"><s:property value="facelookUser.fuUserName" /></a>：<s:property value="fcComment"/>
							</li>
							</s:iterator>
						</s:iterator>
					</ul>
					<dl class="clearfix">
						<dt><img src="images/face.gif" /></dt>
						<dd>
							<!-- 
								设置这个隐藏域，title-这条评论是回复照片还是评论；id-被回复内容的id
								title的默认值为'photoId'
								如果点击评论后面的回复按钮，那么这个隐藏与的title赋值为'parentId'
							 -->
							<input type="hidden" id="replyId" title="photoId" />
							<textarea id="commentBox"></textarea>
							<label class="ui-btn-normal">
							<input type="button" id="CommentBtn" name="comment" value="发表评论" /></label>
						</dd>
					</dl>
				</div>
			</div>
			<div id="imgSide"></div>
			<div class="clear"></div>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>Facelook &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
<script type="text/javascript">
var photo = [
	{"tagid":"1","tagname":"张三","taguserid":"8487373","leftL":"89","leftT":"47","rightL":"123","rightT":"80"},
	{"tagid":"2","tagname":"李四","taguserid":"4555444","leftL":"234","leftT":"58","rightL":"270","rightT":"95"},
	{"tagid":"3","tagname":"王二","taguserid":"3454322","leftL":"272","leftT":"132","rightL":"313","rightT":"175"}
];
</script>
<script type="text/javascript">
	$(function (){
		$("#CommentBtn").click(function (){
			var _op = $("#replyId").attr("title");
			var _parentId = $("#replyId").val();	//被评论对象的id
			var _photoId = <s:property value="fp.fpPhotoId" />;
			var _content = $("#commentBox").html();
			//alert(_content);
			var date = {option:_op,parentId:_parentId,photoId:_photoId,'comment.fcComment':_content};
			$.post("saveComment.action",date,function(redate){
				//alert(redate);
				if(_op=="photoId"){
					$("#fcList").append(redate);
				}else{
					$("#fc_"+_parentId).after(redate);
				}
				$("#replyId").attr("title","photoId");
				$("#commentBox").text("");
			});
			//alert(date);
		});
	});
</script>
<script type="text/javascript" src="scripts/quanren.js"></script>
<s:debug></s:debug>
</body>
</html>
