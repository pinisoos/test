<%@ page session="false" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
<head>
	<title>Member_list</title>
</head>
<body>
	<form action="/spring/member" method="post">
		<table>
			<tbody>
				<tr>
					<th>아이디 : </th>
					<td><input type="text" id="user_id" name="user_id"></td>
				<tr>
				<tr>
					<th>비밀번호 : </th>
					<td><input type="password" id="pw" name="pw"></td>
				<tr>
				<tr>
					<th>이름 : </th>
					<td><input type="text" id="user_name" name="user_name"></td>
				<tr>
				<tr>
					<th>이메일 : </th>
					<td><input type="text" id="email" name="email"></td>
				<tr>
			</tbody>
		</table>
		<input type="submit" value="등록">
	</form>
	
</body>
</html>