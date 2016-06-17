package com.study.springrest.service;

import java.util.List;
import java.util.Map;
import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;

public interface ReplyService {
	public Map<String, Object> get(int board_no, Criteria cri);
	public List<ReplyVO> getList();
	public void insert(ReplyVO vo);
	public void update(ReplyVO vo);
	public void delete(int reply_no);
	public int getReplyCount(int board_no);
}
