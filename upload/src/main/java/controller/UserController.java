package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//转向登录界面
	@RequestMapping("tologin.u")
	public String tologin(){
		return "login";
	}
}
