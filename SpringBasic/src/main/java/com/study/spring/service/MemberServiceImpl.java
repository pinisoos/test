package com.study.spring.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.study.spring.domain.MemberVO;
import com.study.spring.persistance.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao;
	@Override
	public String getNow() {
		// TODO Auto-generated method stub
		return dao.getNow();
	}

	@Override
	public void insert(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public MemberVO get(String user_id) {
		// TODO Auto-generated method stub
		return dao.get(user_id);
	}

	@Override
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

	@Override
	public void update(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(String user_id) {
		// TODO Auto-generated method stub
		dao.delete(user_id);
	}

}
