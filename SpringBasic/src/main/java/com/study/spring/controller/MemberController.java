package com.study.spring.controller;

import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.domain.MemberVO;
import com.study.spring.service.MemberService;

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
@Controller
public class MemberController {
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String member(Locale locale, Model model) {
		List<MemberVO> member_list=service.getList();
		model.addAttribute("member_list", member_list);
		return "member_list";
	}
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String memberInsert(MemberVO vo, Model model) {
		
		service.insert(vo);
		
		return "redirect:/member";
	}
	@RequestMapping(value = "/memberDelete", method = RequestMethod.POST)
	public String memberDelete(@RequestParam("user_id") String user_id, Model model) {
		
		service.delete(user_id);
		
		return "redirect:/member";
	}
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String memberDelete(MemberVO vo, Model model) {
		
		service.update(vo);
		
		return "redirect:/member";
	}
	@RequestMapping(value = "/memberUpdateWrite", method = RequestMethod.POST)
	public String memberUpdateWrite(@RequestParam("user_id") String user_id, Model model) {
		MemberVO vo=service.get(user_id);
		model.addAttribute("vo", vo);
		return "memberUpdate";
	}
	@RequestMapping(value = "/memberWrite", method = RequestMethod.GET)
	public void memberWrite(Locale locale, Model model) {

	}
}
