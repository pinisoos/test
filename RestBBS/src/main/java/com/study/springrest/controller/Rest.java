package com.study.springrest.controller;

import java.util.Map;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.study.springrest.domain.RestVO;
import com.study.springrest.domain.Paging;
import com.study.springrest.service.RestService;

/**
 * 1. ����ڰ� �������� ���� URI�� ȣ��
 * 2. ��Ĺ�� ��ġ �� ������ �����ӿ�ũ�� Controller���� �˻��ؼ� @RequestMapping ������̼��� ã�´�.
 * -> ������̼��� value�� ������ URI�� ��Ī��Ų��.
 * 3. URI�� ���� �� �ż��忡�� return ���ִ� ���ڿ��� �̸��� ���� jsp ������ ����ڿ��� �Ѱ��ش�.
 */
//@RestController
//@Service
//@Repository
//@Component
@RestController
@RequestMapping(value="/rest")
public class Rest {
	@Inject
	private RestService service;
	// /����/		���
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView list() {
		Paging pg=new Paging();
		ModelAndView view=new ModelAndView();
		Map<String, Object> map=service.getList(pg);
		view.setViewName("index");
		view.addObject("pg", map.get("pg"));
		view.addObject("bbs_list", map.get("bbs_list"));
		return view;
	}
	@RequestMapping(value = "/{currentBlock}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("currentBlock") Integer currentBlock, @PathVariable("currentPage") Integer currentPage) {
		Paging pg=new Paging();
		pg.setCurrentBlock(currentBlock);
		pg.setCurrentPage(currentPage);
		ModelAndView view=new ModelAndView();
		Map<String, Object> map=service.getList(pg);
		view.setViewName("index");
		view.addObject("pg", map.get("pg"));
		view.addObject("bbs_list", map.get("bbs_list"));
		return view;
	}
	// /����/�۹�ȣ		��
	@RequestMapping(value = "/{board_no}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("board_no") Integer board_no) {
		ModelAndView view=new ModelAndView();
		RestVO vo=service.get(board_no);
		vo.setView_cnt(vo.getView_cnt()+1);
		service.view_cntPlus(vo);		
		view.addObject("vo", vo);
		view.setViewName("detail");
		return view;
	}
	// /����/new �۾���
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView write() {
		return new ModelAndView("write");
	}
	// /����/ method=post
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView insert(RestVO vo) {
		service.insert(vo);
		return new ModelAndView("redirect:/rest");
	}
	@RequestMapping(value = "/{board_no}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("board_no") Integer board_no) {
		service.delete(board_no);
		return new ModelAndView("redirect:/rest");
	}
}
