package com.areguig.sample.controller;

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
	public String greetings() {
		return "Hello ! you are accessing the protected side of the app";
	}



}
