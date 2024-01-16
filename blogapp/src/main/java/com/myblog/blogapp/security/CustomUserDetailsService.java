package com.myblog.blogapp.security;

import java.util.Collection;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myblog.blogapp.entity.Role;
import com.myblog.blogapp.entity.User;
import com.myblog.blogapp.repository.UserRepository;




@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	
	private UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String usernamerorEmail) throws UsernameNotFoundException {
		User user = userRepository.findByUsernameOrEmail(usernamerorEmail, usernamerorEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with  user name:" + usernamerorEmail));

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {

		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
