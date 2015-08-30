package com.holylala.springmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelpController {

	@RequestMapping(value = "help")
	public String helloWorld(){
		return "help";
	}
	
}
