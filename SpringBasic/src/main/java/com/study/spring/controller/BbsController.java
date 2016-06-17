package com.study.spring.controller;

import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.study.spring.domain.BbsVO;
import com.study.spring.service.BbsService;

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
public class BbsController {
	
	@Inject
	private BbsService service;
	
	@RequestMapping(value = "/bbs", method = RequestMethod.GET)
	public String member(Locale locale, Model model) {
		List<BbsVO> bbs_list=service.getList();
		model.addAttribute("bbs_list", bbs_list);
		return "bbs/index";
	}
}
