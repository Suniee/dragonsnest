package com.dragonsnest.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.dragonsnest.model.User;
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
	@RequestMapping(value={"/", "/login.nest"}, method=RequestMethod.GET) 
	public String login(@RequestParam Map<String, Object> param, ModelMap model, Locale locale) throws Throwable {
//		logger.info("Welcome home! The client locale is {}.", locale);
		return "login";
	}
	
	/**
	 * 로그인 실패 화면 호출
	 * @param param
	 * @param model
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value="/loginfailed.nest", method=RequestMethod.GET)
	public String loginFailed(@RequestParam Map<String, Object> param, ModelMap model) throws Throwable {
		return "loginfailed";
	}
	
	
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
	
	/**
	 * 사용자 등록 화면 호출
	 * @param param
	 * @param request
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value="/signup.nest", method=RequestMethod.GET)
	public String signup(@RequestParam Map<String, Object> param, HttpServletRequest request) throws Throwable {
		logger.info("try to sign up from [{}]", request.getRemoteAddr());
		return "signup";
	}
	
	/**
	 * 사용자 등록 요청
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/signup.nest", method=RequestMethod.POST)
	public String signup(@RequestParam Map<String, Object> params) {
		String username = (String)params.get("username");
		String password = (String)params.get("password");
		String name = (String)params.get("name");
		String phone = "1";
		
		User user = new User();
		user.setId(username);
		user.setPassword(password);
		user.setName(name);
		user.setPhone(phone);
		user.setRole("ROLE_USER");
		
		Map<String, Object> sqlParams = new HashMap<String, Object>();
		sqlParams.put("id", username);
		sqlParams.put("password", password);
		sqlParams.put("name", name);
		sqlParams.put("phone", phone);
		sqlParams.put("role", "ROLE_USER");
		
		
		logger.debug(user.toString());
		
		service.insertUser2(sqlParams);
		
		
		
		return "login";
	}
	
}
