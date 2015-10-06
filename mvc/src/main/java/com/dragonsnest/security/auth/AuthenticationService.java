package com.dragonsnest.security.auth;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.dragonsnest.model.User;
import com.dragonsnest.service.UserService;

@Repository("AuthRepository")
public class AuthenticationService implements UserDetailsService
{
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
	UserService service;
	
	/*public static AuthenticateUser getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth == null) return null;
		
		AuthenticateUser ret = null;
		Object obj = auth.getPrincipal();
		if(auth.isAuthenticated() && !"anonymousUser".equals(obj)){
			ret = (AuthenticateUser) obj;
		}
		return ret;
	}*/
	
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException
    {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        
        AuthenticateUser user = new AuthenticateUser();
        
        User manager = service.selectUser(userid);
        
        if(manager == null) {
        	throw new UsernameNotFoundException(userid);
        }
        
        logger.debug("manager [{}]", manager.toString());
        
        user.setUsername(manager.getName());
        user.setUserid(userid);
        user.setPassword(encoder.encode(manager.getPassword()));
//        user.setManager(manager);
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(manager.getRole()));
		
        return user;
    }
}

