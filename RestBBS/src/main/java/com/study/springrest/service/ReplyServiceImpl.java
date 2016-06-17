package com.study.springrest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.domain.RestVO;
import com.study.springrest.persistence.ReplyDAO;
import com.study.springrest.persistence.RestDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	private ReplyDAO dao;
	@Inject
	private RestDAO restDao;
	
	@Override
	public Map<String, Object> get(int board_no, Criteria cri) {
		// TODO Auto-generated method stub
		int replyCount = dao.getReplyCount(board_no);
		int pageCount, totalBlock;
		int pageEnd = 0;
		if (replyCount % cri.getPageSize() == 0) {
			pageCount = replyCount / (cri.getPageSize());
		} else {
			pageCount = replyCount / (cri.getPageSize()) + 1;
		}
		totalBlock = (int) Math.ceil((double) pageCount / cri.getBlockSize());
		for (int i = 1; i <= cri.getBlockSize(); i++) {
			int pageTemp = cri.getBlockSize() * cri.getCurrentBlock() + i;
			pageEnd = i;
			if (pageTemp == pageCount) {
				break;
			}
		}
		cri.setPageCount(pageCount);
		cri.setTotalBlock(totalBlock);
		cri.setPageEnd(pageEnd);

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cri", cri);
		map.put("reply_list", dao.get(board_no, cri));
		
		return map;
	}

	@Override
	public List<ReplyVO> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

	@Override
	public void insert(ReplyVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
		RestVO restVo=new RestVO();
		restVo.setBoard_no(vo.getBoard_no());
		restVo.setReply_cnt(restDao.get(vo.getBoard_no()).getReply_cnt() + 1);
		restDao.reply_cntPlus(restVo);
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(int reply_no) {
		// TODO Auto-generated method stub
		dao.delete(reply_no);
	}

	@Override
	public int getReplyCount(int board_no) {
		// TODO Auto-generated method stub
		return dao.getReplyCount(board_no);
	}

}
