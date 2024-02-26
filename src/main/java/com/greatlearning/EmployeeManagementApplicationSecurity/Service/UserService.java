package com.greatlearning.EmployeeManagementApplicationSecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.User;
import com.greatlearning.EmployeeManagementApplicationSecurity.Repository.UserRepository;
import com.greatlearning.EmployeeManagementApplicationSecurity.Security.MyUserDetails;
import com.greatlearning.EmployeeManagementApplicationSecurity.Security.WebSecurityConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	public UserRepository userRepository;
	

    // Create an instance of BCryptPasswordEncoder
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	WebSecurityConfig webSecurityConfig;

	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		log.info("Service UserService loadUserByUsername(String username)  user.getUsername(): "+user.getUsername()+"  user.getPassword() : "+user.getPassword());

		if(user == null) {
			throw new UsernameNotFoundException("Could not found the user");
		}
		return new MyUserDetails(user);
	}
	
	public String createUser(User user) {
		log.info("Service createUser  user.getPassword() : "+ user);

        String encodedPassword = passwordEncoder.encode( user.getPassword() );
		log.info("Service createUser  user.getPassword() : " + encodedPassword );
		user.setPassword(encodedPassword);
		
		userRepository.saveAndFlush(user);
		return "User create sucessfully";
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}

}
