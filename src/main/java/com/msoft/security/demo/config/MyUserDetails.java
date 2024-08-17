package com.msoft.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.msoft.security.demo.model.User;
import com.msoft.security.demo.repo.UserRepository;

@Service
public class MyUserDetails implements UserDetailsService {
	
	@Autowired
	private UserRepository userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		return org.springframework.security.core.userdetails.User.builder()
				.username(username)
				.password(user.getPassword())
				.roles(getUserRoles(user))
				.build();
	}
	
	private String[] getUserRoles(User user) {
		if ( user.getRoles() == null)
			return new String[] {"USER" };
		return user.getRoles().split(",");
	}

}
