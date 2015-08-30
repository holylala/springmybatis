package com.holylala.springmybatis.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FetchController {

	@RequestMapping(value = "fetch")
	public String helloWorld(){
		return "fetch";
	}

	
}
