package com.areguig.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by akli on 14/08/15.
 */

@RestController
@RequestMapping("/public")
public class PublicController {

	@RequestMapping(method = RequestMethod.GET)
	public String greetings() {
		return "Hello ! you are accessing the public side of the app";
	}

}
