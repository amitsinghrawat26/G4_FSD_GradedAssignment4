package com.greatlearning.EmployeeManagementApplicationSecurity.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.Role;
import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyUserDetails implements org.springframework.security.core.userdetails.UserDetails{

	private User user;

	public MyUserDetails(User user) {
		super();
		log.info("MyUserDetails user : "+ user.getId() +"  :  "+ user.getUsername()  +"  :  "+  user.getPassword());

		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for(Role role : roles) {
			log.info("getAuthorities() role.getName() : "+role.getName()+"  role.getName() : "+role.getName());
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		log.info("MyUserDetails getPassword()");
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		log.info("MyUserDetails getUsername() user:"+user);

		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
