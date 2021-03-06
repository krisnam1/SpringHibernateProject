package com.vastika.uis.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vastika.uis.model.User;
import com.vastika.uis.repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.getUserInfoByUsername(username);
		
		
		UserDetails u= new org.springframework.security.core.userdetails.User
				(user.getUserName(), user.getPassword(), 
				true,true,true,true, getGrantedAuthorities(user.getRole().getRoleName()));
		
		return u;

	}
	
	//this will give us the added list of users which have granted authorities.
	public Collection<? extends GrantedAuthority>getGrantedAuthorities (String role){
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority(role));
		return authList;
		
	}

}
