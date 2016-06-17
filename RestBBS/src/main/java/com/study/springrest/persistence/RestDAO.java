package com.study.springrest.persistence;

import java.util.List;
import com.study.springrest.domain.Paging;
import com.study.springrest.domain.RestVO;

public interface RestDAO {
	public RestVO get(int board_no);
	public List<RestVO> getList(Paging pg);
	public void insert(RestVO vo);
	public void update(RestVO vo);
	public void delete(int board_no);
	public int getBbsCount();
	public void view_cntPlus(RestVO vo);
	public void reply_cntPlus(RestVO vo);
}
