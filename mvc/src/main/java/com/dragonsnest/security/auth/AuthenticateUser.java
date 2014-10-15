package com.dragonsnest.security.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dragonsnest.model.User;


public class AuthenticateUser implements UserDetails
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    private User manager;
    
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();    
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        return authorities;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getUsername() 
    {
        return username;
    }
    
    public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isAccountNonExpired() 
    {
        return true;
    }
    
    public boolean isAccountNonLocked() 
    { 
        return true;
    }
    
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }
    
    public boolean isEnabled() 
    {
        return true;
    }
}