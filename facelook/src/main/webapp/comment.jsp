<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<li id="fc_<s:property value="comment.fcId" />">
	<div class="menu">
		<span class="time"><s:property value="comment.fcCreateTime" /></span> <a
			href="#"
			onclick="replyIt('<s:property value="comment.facelookUser.fuUserName" />',<s:property value="comment.fcId" />)">回复</a>
	</div> <a href="#"><s:property value="comment.facelookUser.fuUserName" /></a>：<s:property value="comment.fcComment" />
</li>
