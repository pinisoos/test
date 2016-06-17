package com.study.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.persistance.MemberDAO;

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
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private MemberDAO dao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		System.out.println(dao.getNow());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}
