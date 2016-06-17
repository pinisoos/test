package com.study.springrest.service;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.study.springrest.domain.RestVO;
import com.study.springrest.persistence.RestDAO;
import com.study.springrest.domain.Paging;

@Service
public class RestServiceImpl implements RestService{

	//@Inject 식별자(이름)와 상관없이 해당 타입이 맞는것들을 인젝트해줌 
	//@Autowired 이름이 같아야함
	//@ Resource 이름이 같아야함 
	@Inject
	private RestDAO dao;
	@Override
	public RestVO get(int board_no) {
		// TODO Auto-generated method stub
		return dao.get(board_no);
	}

	@Override
	public Map<String, Object> getList(Paging pg) {
		// TODO Auto-generated method stub
		int bbsCount = dao.getBbsCount();
		int pageCount, totalBlock;
		int pageEnd = 0;
		if (bbsCount % pg.getPageSize() == 0) {
			pageCount = bbsCount / (pg.getPageSize());
		} else {
			pageCount = bbsCount / (pg.getPageSize()) + 1;
		}
		totalBlock = (int) Math.ceil((double) pageCount / pg.getBlockSize());
		for (int i = 1; i <= pg.getBlockSize(); i++) {
			int pageTemp = pg.getBlockSize() * pg.getCurrentBlock() + i;
			pageEnd = i;
			if (pageTemp == pageCount) {
				break;
			}
		}
		pg.setPageCount(pageCount);
		pg.setTotalBlock(totalBlock);
		pg.setPageEnd(pageEnd);
		pg.setLimit(pg.getPageSize());
		pg.setOffset(pg.getPageSize()*(pg.getCurrentPage()-1));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pg", pg);
		map.put("bbs_list", dao.getList(pg));
		
		return map;
	}

	@Override
	public void insert(RestVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public void update(RestVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(int board_no) {
		// TODO Auto-generated method stub
		dao.delete(board_no);
	}

	@Override
	public void view_cntPlus(RestVO vo) {
		// TODO Auto-generated method stub
		dao.view_cntPlus(vo);
	}

}
