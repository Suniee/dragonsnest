package com.dragonsnest.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/", "/login.do"}, method=RequestMethod.GET) 
	public String login(Locale locale, Model model) {
		return "login";
	}
	
	
	/**
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
		
		return "home";
	}
	
}
