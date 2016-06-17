<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="./include/header.jsp" %>
	<div class="container" style="width: 1000px; margin:0 auto;">
		<h2>글읽기</h2>
		<table class="table">
			<tbody>
				<tr>
					<th>제목</th><td>${ vo.title }</td>
				</tr>
				<tr>
					<th>글쓴이</th><td>${ vo.user_name }</td>
				</tr>
				<tr>
					<th>작성일</th><td>${ vo.regdate }</td>
				</tr>
				<tr>
					<th>내용</th><td>${ vo.content }</td>
				</tr>
			</tbody>
		</table>
		<form action="/rest/${ vo.board_no }" method="post">
			<input type="hidden" id="_method" name="_method" value="delete">
			<input type="submit" value="삭제" class="btn btn-default" style="float:right;">
		</form>
		<h3 style="clear:both;">댓글</h3>
		작성자 : <input type="text" id="user_name" name="user_name" size="10">
		댓글 : <input type="text" id="content" name="content" size="50">
		<input type="hidden" id="board_no" name="board_no" value="${ vo.board_no }">
		<input type="button" value="등록" class="btn btn-default" onclick="postReply()">
		<div id="reply_list" style="text-align:center;"></div>	
		<div style="text-align: center;">
			<ul id="reply_paging" class="pagination">
			
			</ul>
		</div>
	</div>
	<script type="text/javascript">
		var currentBlock=0;
		var currentPage=1;
		var totalBlock;
		var pageCount;
		var replyCount;
		function setReplyList(reply_list){
			$("#reply_list").html("");
			$("#user_name").val("");
			$("#content").val("");
			$("#reply_list").append("<ul>");
			$(reply_list).each(function(){
				$("#reply_list").append("<li> 작성자 : "+ this.user_name + " 댓글 : " + this.content + "<input type='button' value='삭제' onclick='deleteReply(" + this.reply_no + ")' class='btn btn-default'></li>");
			});
			$("#reply_list").append("</ul>");
		}
		function setReplyPage(cri, reply_list){
			if(reply_list!=""){
				$("#reply_paging").html("");
				if(cri.currentPage!=1){
					$("#reply_paging").append("<li><a onclick='getReplyList(0, 1)'>맨처음</a></li>");
				}
				if(cri.currentBlock > 0){
					$("#reply_paging").append("<li><a onclick='getReplyList(" + (cri.currentBlock - 1) + ", " + (((cri.currentBlock + -1)* cri.blockSize) + 1) + ")'>이전</a></li>");
				}
				for(var i = 1; i <= cri.pageEnd; i++){
					if(cri.currentBlock*cri.blockSize+i==cri.currentPage){
						$("#reply_paging").append("<li class='active'><a onclick='getReplyList(" + cri.currentBlock + ", " + (cri.currentBlock * cri.blockSize + i) +")'>" + (cri.currentBlock * cri.blockSize + i) + "</a></li>");
					}else{
						$("#reply_paging").append("<li><a onclick='getReplyList(" + cri.currentBlock + ", " + (cri.currentBlock * cri.blockSize + i) +")'>" + (cri.currentBlock * cri.blockSize + i) + "</a></li>");
					}
				}
				if(cri.currentBlock + 1 < cri.totalBlock){
					$("#reply_paging").append("<li><a onclick='getReplyList(" + (cri.currentBlock + 1) + ", " + (((cri.currentBlock + 1)* cri.blockSize) + 1) + ")'>다음</a></li>");
				}
				if(cri.currentPage != cri.pageCount){
					$("#reply_paging").append("<li><a onclick='getReplyList(" + (cri.totalBlock - 1) + ", " + cri.pageCount + ")'>맨뒤로</a></li>");
				}
			}
		}
		function getReplyList(currentBlock, currentPage){
			$(document).ready(function() {
				$.ajax({
					url : '/reply',
					headers : {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "GET"},
					type : 'GET',
					dataType : 'JSON',
					data : {"board_no" : "${ vo.board_no }", "currentBlock" : currentBlock, "currentPage" : currentPage},
					success : function(data, textStatus, jqXHR) {
						setReplyList(data.reply_list);
						setReplyPage(data.cri, data.reply_list);
						currentInfo(data.cri);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR + "," + textStatus + "," + errorThrown);
					}
				});
			});
		}
		getReplyList(0, 1);
		function postReply(){
			$(document).ready(function() {
				var jsondata={"board_no" : $("#board_no").val(), "user_name" : $("#user_name").val(), "content" : $("#content").val()};
				$.ajax({
					url : '/reply',
					headers : {"Content-Type" : "application/json; charset=UTF-8"},
					type : 'POST',
					data : JSON.stringify(jsondata),
					success : function(data, textStatus, jqXHR) {
						replyCount=data;
						if(replyCount%100==1){
							getReplyList(totalBlock, pageCount+1);
						}else if(replyCount%10==1){
							getReplyList(totalBlock-1, pageCount+1);
						}else{
							getReplyList(totalBlock-1, pageCount);
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR + "," + textStatus + "," + errorThrown);
					}
				});
			});
		}
		function deleteReply(reply_no){
			$(document).ready(function() {
				var jsondata={"reply_no" : reply_no, "board_no" : $("#board_no").val()};
				$.ajax({
					url : '/reply',
					headers : {"Content-Type" : "application/json; charset=UTF-8"},
					type : 'DELETE',
					data : JSON.stringify(jsondata),
					success : function(data, textStatus, jqXHR) {
						replyCount=data;
						if(replyCount%100==0){
							getReplyList(totalBlock-2, pageCount-1);
						}else if(replyCount%10==0){
							getReplyList(totalBlock-1, pageCount-1);
						}else{
							getReplyList(currentBlock, currentPage);
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR + "," + textStatus + "," + errorThrown);
					}
				});
			});
		}
		function currentInfo(cri){
			currentBlock=cri.currentBlock;
			currentPage=cri.currentPage;
			totalBlock=cri.totalBlock;
			pageCount=cri.pageCount;
		}
	</script>
<%@include file="./include/footer.jsp" %>