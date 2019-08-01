package com.shxt.manager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	//登录页面
	@RequestMapping(path={"/","/index"})
	public String index(){
		return "jsp/login";
	}

	//主页面
	@GetMapping("sys/main")
	public String main(Model model){
		return "jsp/main";
	}
}
