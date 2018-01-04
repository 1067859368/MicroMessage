<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>内容列表页面</title>
		<link href="<%= basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js"></script>
		<script src="<%= basePath %>resources/js/back/list.js"></script>
	</head>
	<body style="background: #e1e9eb;">	
		
		<form action="<%= basePath %>List.action" id="mainForm" method="post">
			<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表  &gt; 新增列表</div>
				<div class="rightCont">
					
					
				</div>
			</div>
	    </form>
	</body>
</html>