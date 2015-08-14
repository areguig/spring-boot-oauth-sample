package com.areguig.sample.service;

import com.areguig.sample.bean.SampleUserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by akli on 14/08/15.
 */
@Service
public class SampleUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		//
		return new SampleUserDetails(username,username);
	}
}
