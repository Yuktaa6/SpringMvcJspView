package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.User;
import com.demo.service.LoginService;



@Controller
@RequestMapping("/login")
public class loginController 
{
	@Autowired
	LoginService lservice;
	public loginController() 
	{
		super();
	}
	
	@PostMapping("/validateUser")
	public ModelAndView validateUser(@RequestParam ("uname") String uname,@RequestParam("pass") String pass)
	{
		User user=lservice.validateUser(uname,pass);
		if(user!=null){
			
			return new ModelAndView("redirect:/product/viewProduct");
		}
		else {
			return new ModelAndView("login","msg","pls re-enter crendentials");
		}
	}

}
