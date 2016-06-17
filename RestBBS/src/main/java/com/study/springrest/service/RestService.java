package com.study.springrest.service;

import java.util.Map;
import com.study.springrest.domain.RestVO;
import com.study.springrest.domain.Paging;

public interface RestService {
	public RestVO get(int board_no);
	public Map<String, Object> getList(Paging pg);
	public void insert(RestVO vo);
	public void update(RestVO vo);
	public void delete(int board_no);
	public void view_cntPlus(RestVO vo);
}
