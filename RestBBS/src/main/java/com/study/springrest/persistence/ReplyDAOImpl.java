package com.study.springrest.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;

@Repository
public class ReplyDAOImpl  implements ReplyDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.study.springrest.mappers.replyMapper";
	

	@Override
	public List<ReplyVO> get(int board_no, Criteria cri) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("board_no", board_no);
		map.put("cri", cri);
		return sqlSession.selectList(namespace+".get", map);
	}

	@Override
	public List<ReplyVO> getList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".getList");
	}

	@Override
	public void insert(ReplyVO vo) {
		sqlSession.insert(namespace+".insert", vo);
		
	}

	@Override
	public void update(ReplyVO vo) {
		sqlSession.update(namespace+".update", vo);
	}

	@Override
	public void delete(int reply_no) {
		sqlSession.delete(namespace+".delete", reply_no);
		
	}

	@Override
	public int getReplyCount(int board_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getReplyCount", board_no);
	}

}
