package com.study.spring.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.study.spring.domain.BbsVO;
import com.study.spring.persistance.BbsDAO;

@Service
public class BbsServiceImpl implements BbsService {

	@Inject
	private BbsDAO dao;
	@Override
	public List<BbsVO> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

}
