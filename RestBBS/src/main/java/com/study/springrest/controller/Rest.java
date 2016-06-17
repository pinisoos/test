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
 * 1. 사용자가 브라우져를 통해 URI를 호출
 * 2. 톰캣에 설치 된 스프링 프레임워크가 Controller들을 검색해서 @RequestMapping 어노테이션을 찾는다.
 * -> 어노테이션의 value의 값들을 URI와 매칭시킨다.
 * 3. URI와 매핑 된 매서드에서 return 해주는 문자열과 이름이 같은 jsp 파일을 사용자에게 넘겨준다.
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
	// /유닛/		목록
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
	// /유닛/글번호		상세
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
	// /유닛/new 글쓰기
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView write() {
		return new ModelAndView("write");
	}
	// /유닛/ method=post
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
