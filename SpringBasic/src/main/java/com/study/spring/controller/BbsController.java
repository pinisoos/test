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
