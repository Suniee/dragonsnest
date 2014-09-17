package com.dragonsnest.auth;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.dragonsnest.model.Manager;
import com.dragonsnest.service.ManagerService;

@Repository("AuthRepository")
public class AuthenticationService implements UserDetailsService
{
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	/*@Autowired
	HelloService service;
	*/
	@Autowired
	ManagerService service;
	
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        
        AuthenticateUser user = new AuthenticateUser();
        
        logger.debug("user ["+userName+"]");
        Manager manager = service.getUser(userName);
        
        
        
        user.setUsername(userName);
        user.setPassword(encoder.encode(manager.getPassword()));
        
      /*  Manager userInfo = service.selectUserById(username);
        if(userInfo != null) {
	        logger.info("["+username+"][" + userInfo.toString()+"]");
	        user.setUsername(username);
	        //user.setPassword(encoder.encode("abcd"));
	        user.setPassword(userInfo.getPassword());
        }*/
        return user;
    }
}

