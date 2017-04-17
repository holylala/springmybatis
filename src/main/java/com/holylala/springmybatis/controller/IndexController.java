package com.holylala.springmybatis.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.holylala.springmybatis.common.PageParam;
import com.holylala.springmybatis.entity.User;
import com.holylala.springmybatis.service.TableIpService;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
	
	@Resource
	TableIpService service;

	@RequestMapping(value = "index")
	public String helloWorld(HttpServletRequest request,ModelMap model){
		//jsp 页面 通过 ${content1},${content2} 这种方式取得
		model.put("content1", "这是从model中取的值1");
		model.addAttribute("content2", "这是从model中取的值2");
		String currPageStr = request.getParameter("page");
		int currPage = 1;
		try {
			if (currPageStr != null) {
				currPage = Integer.parseInt(currPageStr);
			}
		} catch (Exception e) {
		}
		
		int rowCount = service.getRowCount();
		PageParam pageParam = new PageParam();
		pageParam.setRowCount(rowCount);
		if (pageParam.getTotalPage() < currPage) {
			currPage = pageParam.getTotalPage();
		}
		pageParam.setCurrPage(currPage);
		pageParam = service.getIpListByPage(pageParam);
		
		request.setAttribute("pageParam", pageParam);
		
		return "index";
	}
	//http://localhost:8080/sbdemo/page/huang/12.html
	@RequestMapping(value="/page/{name}/{age}",method=RequestMethod.GET)
	public String getName(ModelMap model,@PathVariable("name") String name,@PathVariable("age") int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "name";
	}
	//接收URL参数:
	//http://localhost:8080/sbdemo/page.html?name=huang&age=10
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public String result(ModelMap model,@RequestParam String name,@RequestParam int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "name";
	}
	
	@RequestMapping(value="/page",method=RequestMethod.POST)
	public String resultpost(ModelMap model,@RequestParam String name,@RequestParam int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "name";
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.GET)
	public String adduser(ModelMap model) {
		
		//使用spring mvc的表单 可以显示user中的默认值
		User user = new User();
		model.addAttribute("user", user);
		
		
		return "adduser";
	}
	
}
