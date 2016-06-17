package com.study.springrest.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.study.springrest.domain.Paging;
import com.study.springrest.domain.RestVO;

@Repository
public class RestDAOImpl implements RestDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.study.springrest.mappers.restMapper";
	
	@Override
	public RestVO get(int board_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".get", board_no);
	}

	@Override
	public List<RestVO> getList(Paging pg) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".getList", pg);
	}

	@Override
	public void insert(RestVO vo) {
		sqlSession.insert(namespace+".insert", vo);
		
	}

	@Override
	public void update(RestVO vo) {
		sqlSession.update(namespace+".update", vo);
		
	}

	@Override
	public void delete(int board_no) {
		sqlSession.delete(namespace+".delete",board_no);
		
	}

	@Override
	public int getBbsCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getBbsCount");
	}

	@Override
	public void view_cntPlus(RestVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".view_cnt", vo);
	}

	@Override
	public void reply_cntPlus(RestVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".reply_cnt", vo);
	}

}
