package com.study.hibernate;

import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.study.hibernate.domain.EmpVO;
import com.study.hibernate.persistence.EmpDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Inject
	private EmpDAO dao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<EmpVO> list=dao.getList();
		
		model.addAttribute("l", list);
		
		return "home";
	}
	
}
