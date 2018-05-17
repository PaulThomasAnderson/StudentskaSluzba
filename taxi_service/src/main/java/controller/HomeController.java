package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

}
