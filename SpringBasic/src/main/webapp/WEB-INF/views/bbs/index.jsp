<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.sql.*, java.util.*, java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/board/bbs/css/bootstrap.min.css">
	<link rel="stylesheet" href="/board/bbs/css/bootstrap.theme.min.css">
	<!-- [if lt IE 9]
			<script src="https://oss.maxcdn.com/htmlshiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	[endif] -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="/board/bbs/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function toPostPage() {
			location.href = "/board/Bbs/new";
		}
		function search() {
			location.href="/board/Bbs/" + document.getElementById("keyword").value + "/" + document.getElementById("search").value + "/0/1";
		}
	</script>
<style type="text/css">
	th {
		text-align: center;
	}
	a:link {
		color: black;
		TEXT-DECORATION: none
	}
	a:visited {
		color: black;
		TEXT-DECORATION: none
	}
	a:hover {
		TEXT-DECORATION: none
	}
	#notice {
		font-weight:bold;
		text-align:left;
	}
	</style>
	<title>BBS - List</title>
</head>
<body>
	<div class="container" style="width: 1000px;">
		<h2>목록 </h2>
		<table class="table">
			<thead>
				<tr>
					<th style="width:200px;">글쓴이</th>
					<th style="width:550px;">제목</th>
					<th style="width:250px;">최종 글</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${ bbs_list }" var="list">
						<tr style=text-align:center;>
							<td>${ list.getUid() }</td>
							<td style="text-align:left;"><c:if test="${ list.getNotice() == 'y' }"><font color="red" style="font-weight:bold"> [공지] </font></c:if><a href="/board/Bbs/${ list.getNo() }">${ list.getTitle() }<c:if test="${ list.getReplyCount() != 0}"><font style="font-weight:bold"> [${ list.getReplyCount() }]</font></c:if></a><c:if test="${ date == list.getDate() }"><font color="red" style="font-weight:bold"> N </font></c:if></td>
							<td><c:if test="${ list.getLastReply() != null}">${ list.getLastReply() } by ${ list.getLastReplyUid() }</c:if></td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
		<div class="form-inline">
			<select class="form-control"  id="search" name="search">
				<option value="uid" selected="selected">글쓴이</option>
				<option value="title">제목</option>
				<option value="contents">내용</option>
			</select>
			<input type="text" class="form-control" id="keyword" name="keyword">
			<input type="submit" class="btn btn-default" value="검색" onclick="search()">
			<input type="button" class="btn btn-primary" value="글쓰기" onclick="toPostPage()" style="float:right;">
		</div>
	</div>
</body>
</html>