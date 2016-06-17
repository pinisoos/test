package com.study.spring.persistance;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.spring.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOImplTest {
	@Inject
	private MemberDAO dao;
	
	@Test
	public void test(){
		System.out.println("Test DAO = " + dao);
	}
	@Test
	public void getNowTest(){
		System.out.println("Test DAO now = " + dao.getNow());
	}
	@Test
	public void InsertMemberTest(){
		MemberVO vo=new MemberVO();
		vo.setUser_id("pinisoos");
		vo.setPw("qkrdlstn");
		vo.setUser_name("¹ÚÀÎ¼ö");
		vo.setEmail("pinisoos12@naver.com");
		dao.insert(vo);
	}
	@Test
	public void getTest(){
		MemberVO vo=dao.get("pinisoos");
		System.out.println(vo.getUser_id());
		System.out.println(vo.getPw());
		System.out.println(vo.getUser_name());
		System.out.println(vo.getEmail());
		System.out.println(vo.getRegdate());
		System.out.println(vo.getLastupdate());
	}
	@Test
	public void getListTest(){
		List<MemberVO> list=dao.getList();
		Iterator<MemberVO> it=list.iterator();
		while(it.hasNext()){
			MemberVO vo=it.next();
			System.out.println(vo.getUser_id());
			System.out.println(vo.getPw());
			System.out.println(vo.getUser_name());
			System.out.println(vo.getEmail());
			System.out.println(vo.getRegdate());
			System.out.println(vo.getLastupdate());
		}
	}
	@Test
	public void updateTest(){
		MemberVO vo=new MemberVO();
		vo.setUser_id("pinisoos1464758036761");
		vo.setLastupdate(new Timestamp(System.currentTimeMillis()));
		dao.update(vo);
	}
	@Test
	public void deleteTest(){
		dao.delete("pinisoos1464757957642");
	}
}
