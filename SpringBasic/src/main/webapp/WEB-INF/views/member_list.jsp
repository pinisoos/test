<%@ page session="false" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
<head>
	<title>Member_list</title>
</head>
<body>
	<table>
		<thead>
		<tr>
			<th>User_id</th>
			<th>Pw</th>
			<th>User_name</th>
			<th>Email</th>
			<th>Regdate</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${ member_list }" var="list">
				<tr>
					<td>${ list.user_id }</td>
					<td>${ list.pw }</td>
					<td>${ list.user_name }</td>
					<td>${ list.email }</td>
					<td>${ list.regdate }</td>
					<form action="/spring/memberDelete" method="post">
						<input type="hidden" id="user_id" name="user_id" value="${ list.user_id }">
						<td><input type="submit" value="삭제"></td>
					</form>
					<form action="/spring/memberUpdateWrite" method="post">
						<input type="hidden" id="user_id" name="user_id" value="${ list.user_id }">
						<td><input type="submit" value="수정"></td>
					</form>
				<tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>