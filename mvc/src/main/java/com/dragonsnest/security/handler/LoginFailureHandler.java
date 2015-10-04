package com.dragonsnest.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


public class LoginFailureHandler implements AuthenticationFailureHandler
{
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, 
    								AuthenticationException auth) throws IOException, ServletException
    {
    	HttpSession session = request.getSession();
    	session.setAttribute("isLoginFailed", true);
    	response.sendRedirect(request.getContextPath() + "/login.nest");
    }
}

