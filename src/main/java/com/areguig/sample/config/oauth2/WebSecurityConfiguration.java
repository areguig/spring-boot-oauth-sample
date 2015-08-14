package com.areguig.sample.config.oauth2;

import com.areguig.sample.service.SampleUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by akli on 14/08/15.
 */

@Configuration
@EnableWebSecurity
@EnableWebMvcSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private SampleUserDetailsService userDetailsService;

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin().permitAll().and().authorizeRequests().anyRequest()
				.authenticated().and().httpBasic()
				.authenticationEntryPoint(authenticationEntryPoint()).and()
				.csrf().requireCsrfProtectionMatcher(
				new AntPathRequestMatcher("/oauth/token")).disable()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
	}

	@Bean
	protected AccessDeniedHandler accessDeniedHandler() {
		return new OAuth2AccessDeniedHandler();
	}

	@Bean
	protected AuthenticationEntryPoint authenticationEntryPoint() {
		OAuth2AuthenticationEntryPoint entryPoint = new OAuth2AuthenticationEntryPoint();
		entryPoint.setTypeName("Basic");
		entryPoint.setRealmName("oauth2/client");
		return entryPoint;
	}
}
