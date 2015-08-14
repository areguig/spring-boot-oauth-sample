package com.areguig.sample.controller;

import com.areguig.sample.bean.SampleUserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by akli on 14/08/15.
 */
@RestController
@RequestMapping("/protected")
public class ProtectedController {

	@RequestMapping(method = RequestMethod.GET)
	public String greetings(
			@AuthenticationPrincipal
			SampleUserDetails user) {
		return "Hello " + user.getUsername()
				+ " ! You are accessing the protected side of the app";
	}

}
