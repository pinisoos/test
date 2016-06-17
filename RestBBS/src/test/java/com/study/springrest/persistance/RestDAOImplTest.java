package com.study.springrest.persistance;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.Paging;
import com.study.springrest.domain.RestVO;
import com.study.springrest.persistence.RestDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class RestDAOImplTest {

	@Inject
	private RestDAO dao;

	@Test
	public void test() {
		System.out.println("TestDAO : " + dao);
	}

	@Test
	public void insert() throws Exception {
		RestVO vo = new RestVO();
		vo.setTitle("title");
		vo.setContent("content");
		vo.setUser_name("user_name");
		dao.insert(vo);
	}

	@Test
	public void get() throws Exception {
		int board_no = 1;
		RestVO vo = dao.get(board_no);
		System.out.println("이름 : " + vo.getUser_name());
	}

	@Test
	public void getList(Paging pg) throws Exception {
		pg.setCurrentBlock(0);
		pg.setCurrentPage(1);
		List<RestVO> list = dao.getList(pg);
		Iterator<RestVO> it = list.iterator();
		while (it.hasNext()) {
			RestVO vo = it.next();
			System.out.println("user_name : " + vo.getUser_name());
		}
	}

	@Test
	public void update() throws Exception {
		RestVO vo = new RestVO();
		vo.setUser_name("수정");
		vo.setContent("수정");
		vo.setTitle("수정");
		dao.update(vo);
	}

	@Test
	public void delete() throws Exception {
		dao.delete(3);
	}
}
