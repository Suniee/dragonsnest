package com.dragonsnest.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dragonsnest.model.User;
import com.dragonsnest.security.auth.AuthenticateUser;
import com.dragonsnest.service.UserService;

/**
 * Handles requests for the application home page.
 */
/**
 * 로그인 컨트롤러
 * @author sypark
 *
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService service;
	
	/**
	 * 로그인 화면 호출
	 * @param param
	 * @param model
	 * @param locale
	 * @return 
	 * @throws Throwable
	 */
	@RequestMapping(value={"/", "/login.nest"}) 
	public ModelAndView login(@RequestParam Map<String, Object> param, HttpServletRequest request,
												ModelMap model, Locale locale) throws Throwable {
		HttpSession session = request.getSession();
		logger.info("Access to Login client locale is [{}].", locale);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("isLoginFailed", session.getAttribute("isLoginFailed"));
		session.invalidate();
		return mav;
	}
	
	
}
