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
 * 1. ����ڰ� �������� ���� URI�� ȣ��
 * 2. ��Ĺ�� ��ġ �� ������ �����ӿ�ũ�� Controller���� �˻��ؼ� @RequestMapping ������̼��� ã�´�.
 * -> ������̼��� value�� ������ URI�� ��Ī��Ų��.
 * 3. URI�� ���� �� �ż��忡�� return ���ִ� ���ڿ��� �̸��� ���� jsp ������ ����ڿ��� �Ѱ��ش�.
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
