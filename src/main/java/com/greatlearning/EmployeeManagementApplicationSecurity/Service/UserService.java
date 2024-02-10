package com.greatlearning.EmployeeManagementApplicationSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.User;
import com.greatlearning.EmployeeManagementApplicationSecurity.Repository.UserRepository;
import com.greatlearning.EmployeeManagementApplicationSecurity.Security.MyUserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		log.info("Service UserService loadUserByUsername(String username)  user.getUsername(): "+user.getUsername()+"  user.getPassword() : "+user.getPassword());

		if(user == null) {
			throw new UsernameNotFoundException("Could not found the user");
		}
		return new MyUserDetails(user);
	}

}
