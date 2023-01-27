/**
 * 
 */
package com.mjedli.testjanvier2023;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mjedli
 *
 */
@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping(value = "/")
	private String home() {
		return "home";
	}
	
	@GetMapping(value = "/list")
	private String list() {
		return "list";
	}
	
	@GetMapping(value = "/user/{id}")
	private String details() {
		return "details";
	}
	
}
