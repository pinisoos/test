package com.study.spring.persistance;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.study.spring.domain.BbsVO;

@Repository
public class BbsDAOImpl implements BbsDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.study.spring.mapper.bbsMapper";
	@Override
	public List<BbsVO> getList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getList");
	}

}
