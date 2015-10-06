package com.dragonsnest.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonsnest.service.UserService;

@Controller
public class SignupController {

	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);

	@Autowired
	UserService service;
	
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
		
		logger.debug("user Info [{}]", params.toString());
		
		//추가 정보 입력
		params.put("role", "ROLE_USER");
		
		service.insertUser(params);
		
		
		
		return "login";
	}
	
}
