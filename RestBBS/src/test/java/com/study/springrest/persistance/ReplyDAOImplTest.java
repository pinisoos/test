package com.study.springrest.persistance;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.persistence.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOImplTest {
	@Inject
	private ReplyDAO dao;
	@Test
	public void test(){System.out.println("TestDAO : "+dao);}
	
	@Test
	public void insert() throws Exception{
			ReplyVO vo = new ReplyVO();
			vo.setContent("content");
			vo.setUser_name("user_name"+System.currentTimeMillis());
			vo.setBoard_no(4);
			dao.insert(vo);
		}
	@Test
	public void get() throws Exception{
		Criteria cri=new Criteria();
		List<ReplyVO> list = dao.get(4, cri);
		for(ReplyVO vo : list){
			System.out.println("¿Ã∏ß : " + vo.getBoard_no());
		}
	}
	@Test
	public void getList() throws Exception{
			List<ReplyVO> list = dao.getList();
			Iterator<ReplyVO> it = list.iterator();
			while(it.hasNext()){
				ReplyVO vo = it.next();
				System.out.println("user_name : " + vo.getUser_name());
			}
		}
	@Test
	public void update() throws Exception{
			ReplyVO vo = new ReplyVO();
			vo.setUser_name("id");
			vo.setContent("123");
			dao.update(vo);
		}
	@Test
	public void delete() throws Exception{
			dao.delete(4);
		}
}
