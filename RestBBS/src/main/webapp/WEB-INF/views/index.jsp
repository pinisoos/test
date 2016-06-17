<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.sql.*, java.util.*, java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="./include/header.jsp" %>
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
	<div class="container" style="width: 1000px;">
		<h2>목록</h2>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>글제목</th>
					<th>글쓴이</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ bbs_list }" var="list">
					<tr style=text-align:center;>
						<td>${ list.board_no }</td>
						<td><a href="/rest/${ list.board_no }">${ list.title }</a> [${ list.reply_cnt }]</td>
						<td>${ list.user_name }</td>
						<td>${ list.regdate }</td>
						<td>${ list.view_cnt }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="text-align: center;">
			<ul class='pagination'>
				<c:if test="${ pg.currentPage != 1 }">
					<li><a href="/rest/0/1">맨처음</a></li>
				</c:if>
				<c:if test="${ pg.currentBlock > 0 }">
					<c:set value="${ pg.currentBlock - 1 }" var="preBlock"></c:set>
					<li><a href="/rest/${ pg.currentBlock - 1 }/${ preBlock * pg.blockSize + 1 }">이전</a></li>
				</c:if>
				<c:forEach begin="1" end="${ pg.pageEnd }" var="i">
					<c:choose>
						<c:when test="${ pg.blockSize*pg.currentBlock + i == pg.currentPage }">
							<li class='active'><a href="/rest/${ pg.currentBlock }/${ pg.blockSize*pg.currentBlock + i }">${ pg.blockSize*pg.currentBlock + i }</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/rest/${ pg.currentBlock }/${ pg.blockSize*pg.currentBlock + i }">${ pg.blockSize*pg.currentBlock + i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${ pg.currentBlock + 1 < pg.totalBlock }">
					<c:set value="${ pg.currentBlock + 1 }" var="nextBlock"></c:set>
					<li><a href="/rest/${ pg.currentBlock + 1 }/${ nextBlock * pg.blockSize + 1}">다음</a></li>
				</c:if>
				<c:if test="${ pg.currentPage != pg.pageCount }">
					<li><a href="/rest/${ pg.totalBlock - 1 }/${ pg.pageCount }">맨뒤로</a></li>
				</c:if>
			</ul>
		</div>
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
	<script type="text/javascript">
		function toPostPage() {
			location.href = "/rest/new";
		}
	</script>
<%@include file="./include/footer.jsp" %>