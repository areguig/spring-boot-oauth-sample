package com.areguig.sample.bean;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by akli on 14/08/15.
 */
public class SampleUserDetails implements UserDetails {

	private String password;
	private String username;

	public SampleUserDetails(String username, String password) {
		this.username=username;
		this.password=password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Lists.newArrayList(new SimpleGrantedAuthority("sample-role"));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
