<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Board project</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap-theme.min.css"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" style="width: 1000px;">
		<h2>글 등록</h2>
		<form id="frm" role="form" class="form-horizontal" action="/rest" method="post">
			<div class="row">
				<label class="col-sm-1">아이디</label>
				<div class="col-md-2">
					<input type="text" id="user_name" name="user_name" value="" class="form-control" placeholder="Enter ID" />
				</div>
			</div>
			<div class="row">
				<label class="col-sm-1">제목</label>
				<div class="col-md-5">
					<input type="text" id="title" name="title" value="" class="form-control" placeholder="Enter Title" />
				</div>
			</div>
			<br>
			<div class="form-group">
				<textarea id="content" name="content" rows="10" class="form-control" placeholder="내용을 입력하세요"></textarea>
			</div>
			<br />
			<div style="text-align: center; padding-left: 200px;">
				<button type="button" class="btn btn-primary" onclick="formPost(this)">등록</button>
				<button type="button" class="btn btn-default" onclick=history.back(); style="float: right;">목록</button>
				<button type="button" class="btn btn-default" onclick="getValue(this)" style="float: right;">불러오기</button>
				<button type="button" class="btn btn-default" onclick="prePost(this)" style="float: right;">임시저장</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function formPost(eClick){
			var frm=document.getElementById("frm");
			if(frm.user_name.value==""){
				alert("아이디를 입력하세요.");
				frm.user_name.focus();
			}else if(frm.title.value==""){
				alert("제목을 입력하세요.");
				frm.title.focus();
			}else{
				try{
					//eClick.form.action="bbs_insert.jsp";
					frm.submit();
				}catch(e){}
			}
		}
		function prePost(n){
			var frm=document.getElementById("frm");
			if(frm.user_name.value==""){
				alert("아이디를 입력하세요");
				frm.user_name.focus();
			}else if(frm.title.value==""){
				alert("제목을 입력하세요");
				frm.title.focus();
			}else{
				alert("임시저장되었습니다.");
				n.form.submit();
			}
		}
		function getValue(a){
			var frm=document.getElementById("frm");
		//	location.href="bbs_write.jsp?uid="+uidVal;
			if(document.getElementById("user_name").value==""){
				alert("ID값은 필수입니다.");
			}else{
				location.href="/board/Bbs/tmpUpload/"+frm.user_name.value;
			}
		} 
	</script>
</body>
</html>