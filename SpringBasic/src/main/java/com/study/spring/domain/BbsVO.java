package com.study.spring.domain;

import java.sql.Date;

public class BbsVO {
	int no;
	String title;
	String uid;
	String contents;
	Date date;
	String reply_id;
	int cnt;
	String notice;
	Date lastReply;
	int replyCount;
	String lastReplyUid;
	String file;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getReply_id() {
		return reply_id;
	}
	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public Date getLastReply() {
		return lastReply;
	}
	public void setLastReply(Date lastReply) {
		this.lastReply = lastReply;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public String getLastReplyUid() {
		return lastReplyUid;
	}
	public void setLastReplyUid(String lastReplyUid) {
		this.lastReplyUid = lastReplyUid;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
}
