package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import MyException.UserException;
import bean.User;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//转向登录界面
	@RequestMapping("tologin.u")
	public String tologin(){
		return "login.u";
	}
	
	//登录验证
	@RequestMapping("login.u")
	public String login(@RequestParam("name") String name,
			@RequestParam("pwd") String pwd,Model model) throws UserException{
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		if(userService.loginCheck(user) != null){
			model.addAttribute("name",name);
			return "index.html";
		}else{
			model.addAttribute("error","账号或密码错误");
			return "login.u";
		}
	}
	
	
	//注册
	@RequestMapping("register.u")
	public String register(@RequestParam("name") String name,
			@RequestParam("pwd") String pwd) throws UserException{
		String message = "注册成功";
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		userService.register(user);
		if(user.getUid() != 0){
			return "login.u?messge";
		}
		return "register.u";
	}
}
