package com.dragonsnest.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonsnest.security.auth.AuthenticateUser;


@Controller
public class MainController {

	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	/**
	 * 메인화면 호출
	 * @param param
	 * @param model
	 * @param principal
	 * @param locale
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/index.nest", method = RequestMethod.GET)
	public String index(@RequestParam Map<String, Object> param, ModelMap model,
				Principal principal, Locale locale) throws Throwable {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		AuthenticateUser user = (AuthenticateUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		logger.info("USER INFO [{}]", user.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String serverTime = dateFormat.format(date);
		String userName = "";
		if(principal != null) {
			userName = principal.getName();
//		} else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			userName = auth.getName();
		}
		
		model.addAttribute("serverTime", serverTime);
		model.addAttribute("userName", userName);
		
		return "index";
	}
}
